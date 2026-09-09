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
 * @date 2023-12-08 16:38:38
 */
public class AvaitorDemo3 {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\billfilterHL12.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourPLList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> plMap1 = new HashMap<>();
		plMap1.put("id","bidder001");
		plMap1.put("billId","001");
		plMap1.put("price",new BigDecimal(739.7));
		yourPLList.add(plMap1);

		Map<String,Object> plMap2 = new HashMap<>();
		plMap2.put("id","bidder002");
		plMap2.put("billId","001");
		plMap2.put("price",new BigDecimal(709.7));
		yourPLList.add(plMap2);

		Map<String,Object> plMap3 = new HashMap<>();
		plMap3.put("id","bidder003");
		plMap3.put("billId","001");
		plMap3.put("price",new BigDecimal(679.7));
		yourPLList.add(plMap3);

		Map<String,Object> plMap4 = new HashMap<>();
		plMap4.put("id","bidder004");
		plMap4.put("billId","001");
		plMap4.put("price",new BigDecimal(659.7));
		yourPLList.add(plMap4);

		Map<String,Object> plMap5 = new HashMap<>();
		plMap5.put("id","bidder005");
		plMap5.put("billId","001");
		plMap5.put("price",new BigDecimal(659.7));
		yourPLList.add(plMap5);

		Map<String,Object> plMap6 = new HashMap<>();
		plMap6.put("id","bidder006");
		plMap6.put("billId","001");
		plMap6.put("price",new BigDecimal(709.7));
		yourPLList.add(plMap6);

		env.put("arr", yourPLList); // 替换为您的 arr 列表
		env.put("x", 1); // 替换为您的 x 值
		env.put("y", 1); // 替换为您的 y 值

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