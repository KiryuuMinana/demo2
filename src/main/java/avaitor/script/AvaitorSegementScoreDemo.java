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
public class AvaitorSegementScoreDemo {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

//        String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\aaa.av";
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\segment_score.av";

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
		plMap1.put("price",new BigDecimal(0.47157));
		yourPLList.add(plMap1);


		Map<String,Object> plMap2 = new HashMap<>();
		plMap2.put("id","002");
		plMap2.put("price",new BigDecimal(-0.4324));
		yourPLList.add(plMap2);


		Map<String,Object> plMap3 = new HashMap<>();
		plMap3.put("id","003");
		plMap3.put("price",new BigDecimal(-0.32728));
		yourPLList.add(plMap3);

		Map<String,Object> plMap4 = new HashMap<>();
		plMap4.put("id","004");
		plMap4.put("price",new BigDecimal(-0.00985));
		yourPLList.add(plMap4);

		Map<String,Object> plMap5 = new HashMap<>();
		plMap5.put("id","005");
		plMap5.put("price",new BigDecimal(-0.15906));
		yourPLList.add(plMap5);

		Map<String,Object> plMap6 = new HashMap<>();
		plMap6.put("id","006");
		plMap6.put("price",new BigDecimal(-0.11695));
		yourPLList.add(plMap6);

		Map<String,Object> plMap7 = new HashMap<>();
		plMap7.put("id","007");
		plMap7.put("price",new BigDecimal(0.68179));
		yourPLList.add(plMap7);

		Map<String,Object> plMap8 = new HashMap<>();
		plMap8.put("id","008");
		plMap8.put("price",new BigDecimal(-0.5794));
		yourPLList.add(plMap8);

		Map<String,Object> plMap9 = new HashMap<>();
		plMap9.put("id","009");
		plMap9.put("price",new BigDecimal(-0.38868));
		yourPLList.add(plMap9);

		Map<String,Object> plMap10 = new HashMap<>();
		plMap10.put("id","010");
		plMap10.put("price",new BigDecimal(-0.49546));
		yourPLList.add(plMap10);

		Map<String,Object> plMap11 = new HashMap<>();
		plMap11.put("id","011");
		plMap11.put("price",new BigDecimal(-0.53756));
		yourPLList.add(plMap11);

		env.put("DR", yourPLList); // 替换为您的 DR 列表
		env.put("condition", "N>=-10 && N<=0,-1.2,N>=-20 && N<-10,1.21,N>=-30 && N<-20,1.32,N>=-40 && N<-30,1.43,N>=-50 && N<-40,1.54,N>=-60 && N<-50,1.65,N>=-70 && N<-60,1.76,N>=-80 && N<-70,1.87,N>=-90 && N<-80,1.91,N<-90,1.98,N>0 && N<=10,-1.3,N>10 && N<=20,1.1,N>20 && N<=30,1.2,N>30 && N<=40,1.3,N>40 && N<=50,1.4,N>50 && N<=60,1.5,N>60 && N<=70,1.6,N>70 && N<=80,1.7,N>80 && N<=90,1.88,N>90,1.99"); // 替换为您的 isFilter 值
		env.put("score", 100);


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