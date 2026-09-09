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
 * enterBidder1.av 脚本测试
 * <p>
 * 覆盖三条分支：
 *   case1 - 人数不足(total_person > FB) 且 非第一轮(CR != 0)：不开启本轮，返回 isOpen=false
 *   case2 - 人数不足(total_person > FB) 且 第一轮(CR == 0)：开启本轮，全部打钩，checkStatus=-1
 *   case3 - 人数充足(total_person <= FB)：开启下一轮，正常可勾选，checkStatus=0
 */
public class EnterBidder1 {

	static final String SCRIPT_PATH =
			"D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\enterbidderAv\\enterBidder1.av";

	public static void main(String[] args) throws IOException {
		Expression expression = AviatorEvaluator.getInstance().compileScript(SCRIPT_PATH, true);

		System.out.println("========== case1: 人数不足 + 非第一轮(CR=2) => 不开启本轮 ==========");
		testCase1(expression);

		System.out.println("========== case2: 人数不足 + 第一轮(CR=0) => 开启，全部打钩 ==========");
		testCase2(expression);

		System.out.println("========== case3: 人数充足 + CR=1 => 开启第2轮，正常勾选 ==========");
		testCase3(expression);
	}

	/**
	 * case1: total_person=5, FB=3, CR=2 => 人数不足(5>3) 且 非第一轮 => isOpen=false
	 */
	private static void testCase1(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 当前初始化投标人列表（差集结果，只剩3人）
		List<String> IB = Arrays.asList("bidder001", "bidder002", "bidder003");

		// args: 各轮次可勾选人数，索引0-based，第1轮取args[0]=3，第2轮取args[1]=2
		List<Integer> argsVal = Arrays.asList(3, 2, 1);

		env.put("total_round", 3);   // 总轮次3轮
		env.put("total_person", 5);  // 触发阈值：需要>=5人
		env.put("CR", 2);            // 已生成2轮
		env.put("FB", 3);            // 步骤开始时有效投标单位数=3，不足5人
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=false}
	}

	/**
	 * case2: total_person=5, FB=3, CR=0 => 人数不足(5>3) 且 第一轮 => isOpen=true, checkStatus=-1, 全部checked=1
	 */
	private static void testCase2(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 当前全部有效投标人（入围轮次详情为空，直接用有效投标人列表）
		List<String> IB = Arrays.asList("bidder001", "bidder002", "bidder003");

		// args: 第1轮取args[0]=3
		List<Integer> argsVal = Arrays.asList(3, 2, 1);

		env.put("total_round", 3);
		env.put("total_person", 5);  // 触发阈值：需要>=5人
		env.put("CR", 0);            // 尚未开始任何轮次
		env.put("FB", 3);            // 步骤开始时有效投标单位数=3，不足5人
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=true, currentRound=1, checkStatus=-1, checkableCount=0, IbList=[{id=bidder001,checked=1},...] }
	}

	/**
	 * case3: total_person=3, FB=5, CR=1 => 人数充足(3<=5) => 开启第2轮，checkStatus=0，全部checked=0
	 */
	private static void testCase3(Expression expression) {
		Map<String, Object> env = new HashMap<>();

		// IB: 有效投标人列表与已勾选的差集（已勾选过1人，剩余4人）
		List<String> IB = Arrays.asList("bidder002", "bidder003", "bidder004", "bidder005");

		// args: 第1轮取args[0]=3，第2轮取args[1]=2
		// nextRound = CR+1 = 2, nextCheckableCount = args[nextRound-1] = args[1] = 2
		List<Integer> argsVal = Arrays.asList(3, 2, 1);

		env.put("total_round", 3);
		env.put("total_person", 3);  // 触发阈值：需要>=3人
		env.put("CR", 1);            // 已完成第1轮
		env.put("FB", 5);            // 步骤开始时有效投标单位数=5，满足>=3
		env.put("IB", IB);

		Object result = expression.execute(env);
		printResult(result);
		// 预期：{isOpen=true, currentRound=2, checkStatus=0, checkableCount=2, IbList=[{id=bidder002,checked=0},...] }
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