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
public class AvaitorTopH {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\topH.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> oESList = new ArrayList<>();
		List<Map<String, Object>> sEPnList = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> oesMap1 = new HashMap<>();
		oesMap1.put("id","05efa22984824716a78ce1a79164b768");
		oesMap1.put("price",new BigDecimal(20.0));
		oESList.add(oesMap1);

		Map<String,Object> oesMap2 = new HashMap<>();
		oesMap2.put("id","56b2a5b7846c46bfa6f95e30633e9fa8");
		oesMap2.put("price",new BigDecimal(20.0));
		oESList.add(oesMap2);

		Map<String,Object> oesMap3 = new HashMap<>();
		oesMap3.put("id","bbc676d369654dd7b38429c2b5746271");
		oesMap3.put("price",new BigDecimal(30.0));
		oESList.add(oesMap3);

		Map<String,Object> oesMap4 = new HashMap<>();
		oesMap4.put("id","b8b2ed2542c841b79c3834f4727af30b");
		oesMap4.put("price",new BigDecimal(20.0));
		oESList.add(oesMap4);

		Map<String,Object> oesMap5 = new HashMap<>();
		oesMap5.put("id","5a0c64e73af3483ca22f6e231281b320");
		oesMap5.put("price",new BigDecimal(30.0));
		oESList.add(oesMap5);

		Map<String,Object> oesMap6 = new HashMap<>();
		oesMap6.put("id","221405224a1c41b9a2266070814f7504");
		oesMap6.put("price",new BigDecimal(25.0));
		oESList.add(oesMap6);

		Map<String,Object> oesMap7 = new HashMap<>();
		oesMap7.put("id","f28b7b23faa640ba8efb5b4e373152af");
		oesMap7.put("price",new BigDecimal(30.0));
		oESList.add(oesMap7);


		Map<String,Object> sEPnMap1 = new HashMap<>();
		sEPnMap1.put("id","05efa22984824716a78ce1a79164b768");
		sEPnMap1.put("price",new BigDecimal(5500.00));
		sEPnList.add(sEPnMap1);

		Map<String,Object> sEPnMap2 = new HashMap<>();
		sEPnMap2.put("id","b8b2ed2542c841b79c3834f4727af30b");
		sEPnMap2.put("price",new BigDecimal(4900.00));
		sEPnList.add(sEPnMap2);

		Map<String,Object> sEPnMap3 = new HashMap<>();
		sEPnMap3.put("id","56b2a5b7846c46bfa6f95e30633e9fa8");
		sEPnMap3.put("price",new BigDecimal(3900.25));
		sEPnList.add(sEPnMap3);

		Map<String,Object> sEPnMap4 = new HashMap<>();
		sEPnMap4.put("id","221405224a1c41b9a2266070814f7504");
		sEPnMap4.put("price",new BigDecimal(2500.00));
		sEPnList.add(sEPnMap4);

		Map<String,Object> sEPnMap5 = new HashMap<>();
		sEPnMap5.put("id","f28b7b23faa640ba8efb5b4e373152af");
		sEPnMap5.put("price",new BigDecimal(2200.00));
		sEPnList.add(sEPnMap5);

		Map<String,Object> sEPnMap6 = new HashMap<>();
		sEPnMap6.put("id","5a0c64e73af3483ca22f6e231281b320");
		sEPnMap6.put("price",new BigDecimal(2000.00));
		sEPnList.add(sEPnMap6);


		env.put("args", oESList); // 替换为您的 OES 列表
		env.put("EPn", sEPnList); // 替换为您的 OES 列表
		env.put("n", 3);


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