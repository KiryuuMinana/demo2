/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bill_score_sum_2.av
 */
public class BBPPriceTest {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\calc_bill_price_bbp.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> yourMap1 = new HashMap<>();
		yourMap1.put("billId","zhucai001");
		yourMap1.put("avgPrice",100);
		yourList.add(yourMap1);

		Map<String,Object> yourMap11 = new HashMap<>();
		yourMap11.put("billId","zhucai002");
		yourMap11.put("avgPrice",200);
		yourList.add(yourMap11);

		env.put("Ct", yourList); // 替换为您的 arr 列表

		// 组装参数
		List<Map<String, Object>> yourList2 = new ArrayList<>();
		// 定义数组内容
		Map<String,Object> yourMap2 = new HashMap<>();
		yourMap2.put("id","zhucai001");
		yourMap2.put("price",50);
		yourList2.add(yourMap2);

		Map<String,Object> yourMap21 = new HashMap<>();
		yourMap21.put("id","zhucai002");
		yourMap21.put("price",60);
		yourList2.add(yourMap21);

		env.put("Cx", yourList2); // 替换为您的 arr 列表

		// 组装参数
		List<Map<String, Object>> yourList3 = new ArrayList<>();
		// 定义数组内容
		Map<String,Object> yourMap3 = new HashMap<>();
		yourMap3.put("id","zhucai001");
		yourMap3.put("price",30);
		yourList3.add(yourMap3);

		Map<String,Object> yourMap31 = new HashMap<>();
		yourMap31.put("id","zhucai002");
		yourMap31.put("price",40);
		yourList3.add(yourMap31);

		env.put("Cz", yourList3); // 替换为您的 arr 列表


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