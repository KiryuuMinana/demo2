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
 * 评标价对照表法 - 偏差率脚本自测。
 * 脚本：custom_deviation_price_table.av
 */
public class AvaitorDeviationPriceTableDemo {

	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_deviation_price_table.av";
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath, true);

		Map<String, Object> env = new HashMap<>();
		List<Map<String, Object>> epnList = new ArrayList<>();

		// 基准价 100000；构造若干边界报价
		epnList.add(bidder("001", "100000"));   // 偏差 0
		epnList.add(bidder("002", "99700"));    // -0.3%
		epnList.add(bidder("003", "99699"));    // 略低于 -0.3%
		epnList.add(bidder("004", "98700"));    // -1.3%
		epnList.add(bidder("005", "100500"));   // +0.5%
		epnList.add(bidder("006", "100501"));   // 略高于 +0.5%
		epnList.add(bidder("007", "101000"));   // +1.0%

		env.put("EPn", epnList);
		env.put("BP", new BigDecimal("100000"));

		Object result = expression.execute(env);
		printList(result);
	}

	private static Map<String, Object> bidder(String id, String price) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("price", new BigDecimal(price));
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
