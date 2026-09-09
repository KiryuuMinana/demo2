/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
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
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-12-12 11:26:59
 */
public class AvaitorDemo4 {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\removeOne.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> yourMap1 = new HashMap<>();
		yourMap1.put("id","bidder001");
		yourMap1.put("price",new BigDecimal(100));
		yourList.add(yourMap1);

		Map<String,Object> yourMap2 = new HashMap<>();
		yourMap2.put("id","bidder002");
		yourMap2.put("price",new BigDecimal(200));
		yourList.add(yourMap2);

		Map<String,Object> yourMap3 = new HashMap<>();
		yourMap3.put("id","bidder003");
		yourMap3.put("price",new BigDecimal(300));
		yourList.add(yourMap3);

		Map<String,Object> yourMap4 = new HashMap<>();
		yourMap4.put("id","bidder004");
		yourMap4.put("price",new BigDecimal(100));
		yourList.add(yourMap4);

		env.put("arr", yourList); // 替换为您的 arr 列表
		env.put("x", 100); // 替换为您的 x 值

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