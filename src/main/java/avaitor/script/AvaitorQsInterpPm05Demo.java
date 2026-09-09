/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ±0.5% 内满分、超出按偏差率插值扣分 - 报价得分脚本自测。
 * 脚本：custom_qs_interp_pm05.av
 * <p>
 * DR.price 使用「比例」：0.75% → 0.0075；满分默认 10。
 * 期望：
 * <pre>
 *  0%      → 10
 *  0.5%    → 10
 * -0.5%    → 10
 *  0.3%    → 10
 *  0.75%   → 9.25    （扣 0.75*1，不是 (0.75-0.5)*1）
 *  1%      → 9
 *  10%     → 0
 *  10.1%   → 0
 * -0.75%   → 9.625   （扣 0.75*0.5）
 * -1%      → 9.5
 * -20%     → 0
 * -20.1%   → 0
 * </pre>
 */
public class AvaitorQsInterpPm05Demo {

	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_qs_interp_pm05.av";
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath, true);

		Map<String, Object> env = new HashMap<>();
		List<Map<String, Object>> drList = new ArrayList<>();

		drList.add(dr("001", "0"));          // 0% → 10
		drList.add(dr("002", "0.005"));      // 0.5% → 10
		drList.add(dr("003", "-0.005"));     // -0.5% → 10
		drList.add(dr("004", "0.003"));      // 0.3% → 10
		drList.add(dr("005", "0.0075"));     // 0.75% → 9.25
		drList.add(dr("006", "0.01"));       // 1% → 9
		drList.add(dr("007", "0.10"));       // 10% → 0
		drList.add(dr("008", "0.101"));      // 10.1% → 0
		drList.add(dr("009", "-0.0075"));    // -0.75% → 9.625
		drList.add(dr("010", "-0.01"));      // -1% → 9.5
		drList.add(dr("011", "-0.20"));      // -20% → 0
		drList.add(dr("012", "-0.201"));     // -20.1% → 0

		env.put("DR", drList);
		env.put("score", new BigDecimal("10"));

		Object result = expression.execute(env);
		printList(result);
	}

	private static Map<String, Object> dr(String id, String ratio) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("price", new BigDecimal(ratio));
		return map;
	}

	@SuppressWarnings("unchecked")
	private static void printList(Object result) {
		if (!(result instanceof List)) {
			System.out.println(result);
			return;
		}
		List<Map<String, Object>> list = (List<Map<String, Object>>) result;
		for (Map<String, Object> item : list) {
			System.out.println(item);
		}
	}
}
