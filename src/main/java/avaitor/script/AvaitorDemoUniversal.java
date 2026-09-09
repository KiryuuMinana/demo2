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
 * 	通用列表计算
 */
public class AvaitorDemoUniversal {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\universal_list_calc.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourPLList = new ArrayList<>();
		BigDecimal yourPEValue = new BigDecimal("700");
		BigDecimal yourPSValue = new BigDecimal("2200");

		// 定义数组内容
//        yourPLList.add(BidderIdPriceBO.builder().bidderId("00001").price(new BigDecimal(500)).build());
		Map<String,Object> plMap1 = new HashMap<>();
		plMap1.put("bidderId","001");
		plMap1.put("price",new BigDecimal(100000));
		yourPLList.add(plMap1);


		Map<String,Object> plMap2 = new HashMap<>();
		plMap2.put("bidderId","002");
		plMap2.put("price",new BigDecimal(50000));
		yourPLList.add(plMap2);


		Map<String,Object> plMap3 = new HashMap<>();
		plMap3.put("bidderId","003");
		plMap3.put("price",new BigDecimal(20000));
		yourPLList.add(plMap3);


		env.put("list", yourPLList); // 替换为您的 RQ 列表 修正后报价
		env.put("operate", 2);
//		env.put("PE", yourPEValue); // 替换为您的 PE 值 暂估价
//		env.put("PS", yourPSValue); // 替换为您的 PS 值 暂列金



		// 执行 Aviator 脚本
		Object result = expression.execute(env);

		// 处理脚本执行结果
		if (result != null) {
			if (result instanceof List) {
				List<Map<String, Object>> epnList = (List<Map<String, Object>>) result;
				// 对 sepnList 进行后续处理 （打印）
				for (Map<String, Object> epn : epnList) {
					System.out.println(epn);
				}
			}
		}
	}
}