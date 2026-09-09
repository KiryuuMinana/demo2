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
 *
 */
public class AvaitorEmptyDemo {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\empty_list.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourPLList = new ArrayList<>();
		Boolean yourIsFilterValue = true;
		List<Map<String, Object>> yourEPnList = new ArrayList<>();
		BigDecimal yourMBPLValue = new BigDecimal("70000");

		// 定义数组内容
//        yourPLList.add(BidderIdPriceBO.builder().bidderId("00001").price(new BigDecimal(500)).build());
		Map<String,Object> plMap1 = new HashMap<>();
		plMap1.put("id","001");
		plMap1.put("price",new BigDecimal(10));
		yourPLList.add(plMap1);

		Map<String,Object> plMap2 = new HashMap<>();
		plMap2.put("id","002");
		plMap2.put("price",new BigDecimal(10));
		yourPLList.add(plMap2);

		Map<String,Object> plMap3 = new HashMap<>();
		plMap3.put("id","003");
		plMap3.put("price",new BigDecimal(9));
		yourPLList.add(plMap3);

		Map<String,Object> plMap4 = new HashMap<>();
		plMap4.put("id","004");
		plMap4.put("price",new BigDecimal(9));
		yourPLList.add(plMap4);

		Map<String,Object> plMap5 = new HashMap<>();
		plMap5.put("id","005");
		plMap5.put("price",new BigDecimal(8));
		yourPLList.add(plMap5);


		env.put("RQ", yourPLList); // 替换为您的 PL 列表

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