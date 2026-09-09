/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * av脚本直接就是字符串
 *
 * @author 沈航冉
 * @date 2023-11-09 13:49:26
 */
public class AviatorDemo2 {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本
		String aviatorScript = getAvScript();

		// 准备输入参数
		Map<String, Object> env = new HashMap<>();
		getParam(env);

		// 编译并执行 Aviator 脚本
		Object result = AviatorEvaluator.getInstance().compile(aviatorScript, true).execute(env);

		// 打印处理脚本执行结果
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

	public static String getAvScript(){
		String aviatorScript = "## examples/filterEPn.av\n" +
				"fn filterEPn(PL, isFilter, EPn, MBPL) {\n" +
				"    if (isFilter == false) {\n" +
				"        return EPn;\n" +
				"    }\n" +
				"    let SEPn = seq.list();\n" +
				"    let isEpn = false;\n" +
				"    let epnMap = seq.map();\n" +
				"\n" +
				"    for key in EPn{\n" +
				"        seq.put(epnMap,key.bidderId,key);\n" +
				"    }\n" +
				"\n" +
				"    for key in PL{\n" +
				"        let epn = seq.get(epnMap,key.bidderId);\n" +
				"        if (key.price == nil){\n" +
				"            isEpn = true;\n" +
				"            if (epn != nil && epn.price <= MBPL){\n" +
				"                        seq.add(SEPn,epn);\n" +
				"            }\n" +
				"        }\n" +
				"    }\n" +
				"    if (isEpn == false){\n" +
				"        for key in PL{\n" +
				"            if (key.price <= MBPL){\n" +
				"                let epn = seq.get(epnMap,key.bidderId);\n" +
				"                if(epn != nil){\n" +
				"                    seq.add(SEPn,epn)\n" +
				"                }\n" +
				"            }\n" +
				"        }\n" +
				"    }\n" +
				"\n" +
				"    return SEPn;\n" +
				"}\n" +
				"return filterEPn(PL, isFilter, EPn, MBPL);\n";
		return aviatorScript;
	}

	public static void getParam(Map<String, Object> env){
		// 组装参数
		List<Map<String, Object>> yourPLList = new ArrayList<>();
		Boolean yourIsFilterValue = true;
		List<Map<String, Object>> yourEPnList = new ArrayList<>();
		BigDecimal yourMBPLValue = new BigDecimal("1000");

		// 定义数组内容
		Map<String,Object> plMap1 = new HashMap<>();
		plMap1.put("bidderId","001");
		plMap1.put("price",new BigDecimal(500));
		yourPLList.add(plMap1);
		Map<String,Object> epnMap1 = new HashMap<>();
		epnMap1.put("bidderId","001");
		epnMap1.put("price",new BigDecimal(800));
		yourEPnList.add(epnMap1);

		Map<String,Object> plMap2 = new HashMap<>();
		plMap2.put("bidderId","002");
		plMap2.put("price",new BigDecimal(900));
		yourPLList.add(plMap2);
		Map<String,Object> epnMap2 = new HashMap<>();
		epnMap2.put("bidderId","002");
		epnMap2.put("price",new BigDecimal(2000));
		yourEPnList.add(epnMap2);

		Map<String,Object> plMap3 = new HashMap<>();
		plMap3.put("bidderId","003");
		plMap3.put("price",new BigDecimal(1200));
		yourPLList.add(plMap3);
		Map<String,Object> epnMap3 = new HashMap<>();
		epnMap3.put("bidderId","003");
		epnMap3.put("price",new BigDecimal(10800));
		yourEPnList.add(epnMap3);

		env.put("PL", yourPLList); // 替换为您的 PL 列表
		env.put("isFilter", yourIsFilterValue); // 替换为您的 isFilter 值
		env.put("EPn", yourEPnList); // 替换为您的 EPn 列表
		env.put("MBPL", yourMBPLValue); // 替换为您的 MBPL 值
	}
}