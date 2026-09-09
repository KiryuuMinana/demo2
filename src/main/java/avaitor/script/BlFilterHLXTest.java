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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bl_filterHL_X.av
 */
public class BlFilterHLXTest {
	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\bl_filterHL_X.av";
		String script = new String(Files.readAllBytes(Paths.get(scriptPath)), StandardCharsets.UTF_8);
		// 脚本中函数定义为 bl_filterHL，但末尾调用 bl_filterHL_X，需统一函数名

		Expression expression = AviatorEvaluator.getInstance().compile(script);

		Map<String, Object> env = new HashMap<>();
		List<Map<String, Object>> arr = new ArrayList<>();

		BigDecimal[] prices = {
				new BigDecimal("9700"),
				new BigDecimal("9700"),
				new BigDecimal("9700"),
				new BigDecimal("9700"),
				new BigDecimal("9660"),
				new BigDecimal("9660"),
				new BigDecimal("9660"),
				new BigDecimal("9888"),
				new BigDecimal("9888"),
				new BigDecimal("9888"),
				new BigDecimal("9888"),
				new BigDecimal("10129"),
				new BigDecimal("10129"),
				new BigDecimal("10129"),
				new BigDecimal("9999.99"),
				new BigDecimal("9999.99"),
				new BigDecimal("9999.99"),
				new BigDecimal("6800"),
				new BigDecimal("4500"),
				new BigDecimal("9800"),
				new BigDecimal("9800"),
				new BigDecimal("9800"),
				new BigDecimal("9800")
		};

		for (int i = 0; i < prices.length; i++) {
			Map<String, Object> item = new HashMap<>();
			item.put("id", String.valueOf(i + 1));
			item.put("price", prices[i]);
			arr.add(item);
		}

		env.put("arr", arr);
		env.put("X", 8);

		Object result = expression.execute(env);

		if (result != null) {
			if (result instanceof List) {
				List<Map<String, Object>> resultList = (List<Map<String, Object>>) result;
				for (Map<String, Object> item : resultList) {
					System.out.println(item);
				}
			}
		}
	}
}
