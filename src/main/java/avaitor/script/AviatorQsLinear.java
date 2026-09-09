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
public class AviatorQsLinear {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\custom_qs_nj_linear.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 定义数组内容
//        yourPLList.add(BidderIdPriceBO.builder().bidderId("00001").price(new BigDecimal(500)).build());
		List<Map<String, Object>> yourBLQList = new ArrayList<>();

		Map<String,Object> epnMap1 = new HashMap<>();
		epnMap1.put("id","001");
		epnMap1.put("price",new BigDecimal(50000));
		yourBLQList.add(epnMap1);


		Map<String,Object> epnMap2 = new HashMap<>();
		epnMap2.put("id","002");
		epnMap2.put("price",new BigDecimal(40000));
		yourBLQList.add(epnMap2);

		Map<String,Object> epnMap3 = new HashMap<>();
		epnMap3.put("id","003");
		epnMap3.put("price",new BigDecimal(6000));
		yourBLQList.add(epnMap3);

		env.put("BLQ", yourBLQList); // 替换为您的 EPn 列表
		env.put("MBPL", new BigDecimal(50000)); // 替换为您的 MBPL 值
		env.put("score", new BigDecimal(100)); // 替换为您的 MBPL 值
		env.put("M", new BigDecimal(10)); // 替换为您的 MBPL 值
		env.put("N", new BigDecimal(10000)); // 替换为您的 MBPL 值

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