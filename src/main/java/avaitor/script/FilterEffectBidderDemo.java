/**
 * Copyright (C) 2025, 雾生三柒.
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
 * filter_effect_bidder
 */
public class FilterEffectBidderDemo {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\filter_effect_bidder.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> Epn = new ArrayList<>();
		List<Map<String, Object>> Kn = new ArrayList<>();

		// 定义数组内容Epn
		Map<String,Object> yourMap1 = new HashMap<>();
		yourMap1.put("id","bidder001");
		yourMap1.put("price",new BigDecimal(500));
		Epn.add(yourMap1);

		Map<String,Object> yourMap2 = new HashMap<>();
		yourMap2.put("id","bidder002");
		yourMap2.put("price",new BigDecimal(400));
		Epn.add(yourMap2);

		Map<String,Object> yourMap3 = new HashMap<>();
		yourMap3.put("id","bidder003");
		yourMap3.put("price",new BigDecimal(300));
		Epn.add(yourMap3);

		Map<String,Object> yourMap4 = new HashMap<>();
		yourMap4.put("id","bidder004");
		yourMap4.put("price",new BigDecimal(200));
		Epn.add(yourMap4);

		Map<String,Object> yourMap5 = new HashMap<>();
		yourMap5.put("id","bidder005");
		yourMap5.put("price",new BigDecimal(700));
		Epn.add(yourMap5);

		// 定义数组内容Kn
		Map<String,Object> yourMap11 = new HashMap<>();
		yourMap11.put("id","bidder001");
		yourMap11.put("price",new BigDecimal(0.86));
		Kn.add(yourMap11);

		Map<String,Object> yourMap22 = new HashMap<>();
		yourMap22.put("id","bidder002");
		yourMap22.put("price",new BigDecimal(0.98));
		Kn.add(yourMap22);

		Map<String,Object> yourMap44 = new HashMap<>();
		yourMap44.put("id","bidder004");
		yourMap44.put("price",new BigDecimal(0.66));
		Kn.add(yourMap44);


		env.put("list", Epn);
		env.put("arr", Kn);

		// 执行 Aviator 脚本
		Object result = expression.execute(env);

		// 处理脚本执行结果
		if (result != null) {
			if (result instanceof List) {
				List<Map<String, Object>> sepnList = (List<Map<String, Object>>) result;
				// 对 sepnList 进行后续处理 （打印）
				for (Map<String, Object> sepn : sepnList) {
					System.out.println(sepn);
				}
			}
		}
	}
}