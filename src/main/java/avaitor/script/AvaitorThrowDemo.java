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
public class AvaitorThrowDemo {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\throw_test.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> yourMap1 = new HashMap<>();
		yourMap1.put("id","bidder001");
		yourMap1.put("price",new BigDecimal("1000"));
		yourList.add(yourMap1);

		Map<String,Object> yourMap2 = new HashMap<>();
		yourMap2.put("id","bidder002");
		yourMap2.put("price",new BigDecimal("1000"));
		yourList.add(yourMap2);

		Map<String,Object> yourMap3 = new HashMap<>();
		yourMap3.put("id","bidder003");
		yourMap3.put("price",new BigDecimal("1000"));
		yourList.add(yourMap3);

		env.put("arr", yourList); // 替换为您的 arr 列表


		Object result = null;
		// 执行 Aviator 脚本
		try {
			result = expression.execute(env);
		}catch (IllegalArgumentException e){
			if(e.getMessage().contains("捕获到异常了")) {
				System.out.println("正在处理相关业务...");
			}
		}

		// 处理脚本执行结果
		if (result != null) {
			if (result instanceof List) {
				List<Map<String, Object>> sepnList = (List<Map<String, Object>>) result;
				// 对 sepnList 进行后续处理 （打印）
				for (Map<String, Object> sepn : sepnList) {
					System.out.println(sepn);
				}
			} else {
				System.out.println(result);
			}
		}
	}
}