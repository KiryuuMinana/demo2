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
public class AviatorTopRank {
	public static void main(String[] args) throws IOException {

		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\topRank.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> rankList = new ArrayList<>();
		List<Map<String, Object>> epnList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> rankMap1 = new HashMap<>();
		rankMap1.put("id","bidder001");
		rankMap1.put("rank",1);
		rankList.add(rankMap1);

		Map<String,Object> rankMap2 = new HashMap<>();
		rankMap2.put("id","bidder002");
		rankMap2.put("rank",2);
		rankList.add(rankMap2);

		Map<String,Object> rankMap3 = new HashMap<>();
		rankMap3.put("id","bidder003");
		rankMap3.put("rank",4);
		rankList.add(rankMap3);

		Map<String,Object> rankMap4 = new HashMap<>();
		rankMap4.put("id","bidder004");
		rankMap4.put("rank",3);
		rankList.add(rankMap4);

		Map<String,Object> rankMap5 = new HashMap<>();
		rankMap5.put("id","bidder005");
		rankMap5.put("rank",5);
		rankList.add(rankMap5);

		Map<String,Object> epnMap1 = new HashMap<>();
		epnMap1.put("id","bidder001");
		epnMap1.put("price",new BigDecimal(1709.7));
		epnList.add(epnMap1);

		Map<String,Object> epnMap2 = new HashMap<>();
		epnMap2.put("id","bidder002");
		epnMap2.put("price",new BigDecimal(3709.7));
		epnList.add(epnMap2);

		Map<String,Object> epnMap3 = new HashMap<>();
		epnMap3.put("id","bidder003");
		epnMap3.put("price",new BigDecimal(4709.7));
		epnList.add(epnMap3);

		Map<String,Object> epnMap4 = new HashMap<>();
		epnMap4.put("id","bidder004");
		epnMap4.put("price",new BigDecimal(4709.7));
		epnList.add(epnMap4);

		Map<String,Object> epnMap5 = new HashMap<>();
		epnMap5.put("id","bidder005");
		epnMap5.put("price",new BigDecimal(5709.7));
		epnList.add(epnMap5);

		env.put("rankList", rankList); // 替换为您的 arr 列表
		env.put("n", 4); // 替换为您的 x 值
		env.put("EPn", epnList); // 替换为您的 y 值

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