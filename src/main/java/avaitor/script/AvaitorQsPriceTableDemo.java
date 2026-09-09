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
 * 评标价对照表法 - 报价得分脚本自测。
 * 脚本：custom_qs_price_table.av
 * <p>
 * DR.price 使用「比例」：-0.3% → -0.003；满分默认 30。
 * 期望：
 * <pre>
 *  0%      → 30
 * -0.3%    → 30
 * -0.3001% → 27
 * -1.3%    → 27
 * -1.3001% → 24
 *  0.5%    → 27
 *  0.5001% → 24
 *  1.0%    → 24
 * -10.3%   → 0
 *  5.0%    → 0
 * </pre>
 */
public class AvaitorQsPriceTableDemo {

	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_qs_price_table.av";
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath, true);

		Map<String, Object> env = new HashMap<>();
		List<Map<String, Object>> drList = new ArrayList<>();

		drList.add(dr("001", "0"));          // 0% → 30
		drList.add(dr("002", "-0.003"));     // -0.3% → 30
		drList.add(dr("003", "-0.003001"));  // 略低于 -0.3% → 27
		drList.add(dr("004", "-0.013"));     // -1.3% → 27
		drList.add(dr("005", "-0.013001"));  // 略低于 -1.3% → 24
		drList.add(dr("006", "0.005"));      // 0.5% → 27
		drList.add(dr("007", "0.005001"));   // 略高于 0.5% → 24
		drList.add(dr("008", "0.01"));       // 1.0% → 24
		drList.add(dr("009", "-0.103"));     // -10.3% → 0
		drList.add(dr("010", "0.05"));       // 5.0% → 0
		drList.add(dr("011", "-0.023"));     // -2.3% → 24
		drList.add(dr("012", "0.015"));      // 1.5% → 21

		env.put("DR", drList);
		env.put("score", new BigDecimal("30"));

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
