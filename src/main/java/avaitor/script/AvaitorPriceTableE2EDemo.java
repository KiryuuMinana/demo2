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
 * 评标价对照表法端到端自测：EPn+BP → DR → QS。
 */
public class AvaitorPriceTableE2EDemo {

	private static final String DEVIATION_SCRIPT =
			"D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_deviation_price_table.av";
	private static final String QS_SCRIPT =
			"D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_qs_price_table.av";

	public static void main(String[] args) throws IOException {
		List<Map<String, Object>> epnList = new ArrayList<>();
		epnList.add(bidder("001", "100000")); // 0% → 30
		epnList.add(bidder("002", "99700"));  // -0.3% → 30
		epnList.add(bidder("003", "98700"));  // -1.3% → 27
		epnList.add(bidder("004", "100500")); // +0.5% → 27
		epnList.add(bidder("005", "101000")); // +1.0% → 24
		epnList.add(bidder("006", "95000"));  // -5% → 15
		epnList.add(bidder("007", "105000")); // +5% → 0

		Map<String, Object> deviationEnv = new HashMap<>();
		deviationEnv.put("EPn", epnList);
		deviationEnv.put("BP", new BigDecimal("100000"));

		Expression deviationExpr = AviatorEvaluator.getInstance().compileScript(DEVIATION_SCRIPT, true);
		Object drResult = deviationExpr.execute(deviationEnv);
		System.out.println("===== DR =====");
		printList(drResult);

		Map<String, Object> qsEnv = new HashMap<>();
		qsEnv.put("DR", drResult);
		qsEnv.put("score", new BigDecimal("30"));

		Expression qsExpr = AviatorEvaluator.getInstance().compileScript(QS_SCRIPT, true);
		Object qsResult = qsExpr.execute(qsEnv);
		System.out.println("===== QS =====");
		printList(qsResult);
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
