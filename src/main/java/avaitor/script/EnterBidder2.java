/**
 * Copyright (C) 2026, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * enterBidder2.av 脚本测试（固定总人数、不固定轮数）
 * <p>
 * 覆盖四条分支：
 *   case1 - 人数不足(total_person > FB) 且 非第一轮(CR != 0)：不开启本轮，checkStatus=-1
 *   case2 - 人数不足(total_person > FB) 且 第一轮(CR == 0)：开启本轮，全部打钩，checkStatus=-1
 *   case3 - 人数充足(total_person <= FB) 且 名额已满(EB == total_person)：不开启本轮，checkStatus=-3
 *   case4 - 人数充足(total_person <= FB) 且 名额未满(EB != total_person)：开启下一轮，checkStatus=-2
 */
public class EnterBidder2 {

	static final String SCRIPT_PATH =
			"D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\enterbidderAv\\enterBidder2.av";

	public static void main(String[] args) throws IOException {
		Expression expression = AviatorEvaluator.getInstance().compileScript(SCRIPT_PATH, true);

		System.out.println("========== case1: 人数不足 + 非第一轮(CR=2) => 不开启本轮, checkStatus=-1 ==========");
		testCase1(expression);

		System.out.println("========== case2: 人数不足 + 第一轮(CR=0) => 开启本轮，全部打钩, checkStatus=-1 ==========");
		testCase2(expression);

		System.out.println("========== case3: 人数充足 + 名额已满(EB==total_person) => 不开启本轮, checkStatus=-3 ==========");
		testCase3(expression);

		System.out.println("========== case4: 人数充足 + 名额未满(EB<total_person) => 开启下一轮, checkStatus=-2 ==========");
		testCase4(expression);
	}

	/**
	 * case1: total_person=15, FB=8, CR=2, EB=5
	 * => 人数不足(15>8) 且 非第一轮(CR=2)
	 * => isOpen=false, checkStatus=-1
	 */
	private static void testCase1(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 当前初始化投标人列表（差集结果，剩余8人）
		List<String> IB = Arrays.asList(
				"bidder001", "bidder002", "bidder003", "bidder004",
				"bidder005", "bidder006", "bidder007", "bidder008"
		);

		env.put("total_person", 15); // 固定入围总人数15人
		env.put("CR", 1);            // 已生成1轮
		env.put("FB", 8);            // 步骤开始时有效投标单位数=8，不足15人
		env.put("EB", 8);            // 已勾选8人
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=false, checkStatus=-1}
	}

	/**
	 * case2: total_person=15, FB=8, CR=0, EB=0
	 * => 人数不足(15>8) 且 第一轮(CR=0)
	 * => isOpen=true, currentRound=1, checkStatus=-1, checkableCount=0, IbList全部checked=1
	 */
	private static void testCase2(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 入围轮次详情表为空，直接使用有效投标人列表
		List<String> IB = Arrays.asList(
				"bidder001", "bidder002", "bidder003", "bidder004",
				"bidder005", "bidder006", "bidder007", "bidder008"
		);

		env.put("total_person", 15); // 固定入围总人数15人
		env.put("CR", 0);            // 尚未开始任何轮次
		env.put("FB", 8);            // 步骤开始时有效投标单位数=8，不足15人
		env.put("EB", 0);            // 尚未勾选任何人
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=true, currentRound=1, checkStatus=-1, checkableCount=0, IbList=[{id=bidder001,checked=1},...]}
	}

	/**
	 * case3: total_person=15, FB=20, CR=3, EB=15
	 * => 人数充足(15<=20) 且 名额已满(EB==total_person)
	 * => isOpen=false, checkStatus=-3
	 */
	private static void testCase3(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 差集为空（所有人都已被勾选入围）
		List<String> IB = Arrays.asList();

		env.put("total_person", 15); // 固定入围总人数15人
		env.put("CR", 3);            // 已生成3轮
		env.put("FB", 20);           // 步骤开始时有效投标单位数=20，满足>=15
		env.put("EB", 15);           // 已勾选15人，名额已满
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=false, checkStatus=-3}
	}

	/**
	 * case4: total_person=15, FB=20, CR=1, EB=10
	 * => 人数充足(15<=20) 且 名额未满(EB=10 < total_person=15)
	 * => isOpen=true, currentRound=2, checkStatus=-2, checkableCount=5, IbList全部checked=0
	 */
	private static void testCase4(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 有效投标人列表与已勾选的差集（已勾选10人，剩余10人待勾选）
		List<String> IB = Arrays.asList(
				"bidder011", "bidder012", "bidder013", "bidder014", "bidder015",
				"bidder016", "bidder017", "bidder018", "bidder019", "bidder020"
		);

		env.put("total_person", 15); // 固定入围总人数15人
		env.put("CR", 1);            // 已完成第1轮
		env.put("FB", 20);           // 步骤开始时有效投标单位数=20，满足>=15
		env.put("EB", 10);           // 已勾选10人，还差5人
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=true, currentRound=2, checkStatus=-2, checkableCount=5, IbList=[{id=bidder011,checked=0},...]}
	}

	@SuppressWarnings("unchecked")
	private static void printResult(Object result) {
		if (result instanceof Map) {
			Map<String, Object> resultMap = (Map<String, Object>) result;
			System.out.println("isOpen        = " + resultMap.get("isOpen"));
			if (resultMap.containsKey("currentRound")) {
				System.out.println("currentRound  = " + resultMap.get("currentRound"));
			}
			if (resultMap.containsKey("checkStatus")) {
				System.out.println("checkStatus   = " + resultMap.get("checkStatus"));
			}
			if (resultMap.containsKey("checkableCount")) {
				System.out.println("checkableCount= " + resultMap.get("checkableCount"));
			}
			if (resultMap.containsKey("IbList")) {
				List<Map<String, Object>> ibList = (List<Map<String, Object>>) resultMap.get("IbList");
				System.out.println("IbList:");
				for (Map<String, Object> item : ibList) {
					System.out.println("  " + item);
				}
			}
		} else {
			System.out.println("result = " + result);
		}
		System.out.println();
	}
}
