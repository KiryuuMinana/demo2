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
 * bill_score_sum_2.av
 */
public class BillScoreSumTest {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\bill_score_sum_2.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();

		// 组装参数
		List<Map<String, Object>> yourList = new ArrayList<>();
		List<Map<String, Object>> BillCPMap = new ArrayList<>();

		// 定义数组内容
		Map<String,Object> yourMap1 = new HashMap<>();
		yourMap1.put("id","bidder001");
		yourMap1.put("billId","zhucai001");
		yourMap1.put("price","149.77");
		yourList.add(yourMap1);

//		Map<String,Object> yourMap11 = new HashMap<>();
//		yourMap11.put("id","bidder001");
//		yourMap11.put("billId","zhucai002");
//		yourMap11.put("price","200");
//		yourList.add(yourMap11);



		Map<String,Object> yourMap2 = new HashMap<>();
		yourMap2.put("id","bidder002");
		yourMap2.put("billId","zhucai001");
		yourMap2.put("price","152.59");
		yourList.add(yourMap2);

//		Map<String,Object> yourMap21 = new HashMap<>();
//		yourMap21.put("id","bidder002");
//		yourMap21.put("billId","zhucai002");
//		yourMap21.put("price","400");
//		yourList.add(yourMap21);

		Map<String,Object> yourMap3 = new HashMap<>();
		yourMap3.put("id","bidder003");
		yourMap3.put("billId","zhucai001");
		yourMap3.put("price","143.59");
		yourList.add(yourMap3);

		Map<String,Object> yourMap4 = new HashMap<>();
		yourMap4.put("id","bidder004");
		yourMap4.put("billId","zhucai001");
		yourMap4.put("price","160.23");
		yourList.add(yourMap4);

		Map<String,Object> yourMap5 = new HashMap<>();
		yourMap5.put("id","bidder005");
		yourMap5.put("billId","zhucai001");
		yourMap5.put("price","161.32");
		yourList.add(yourMap5);

		Map<String,Object> yourMap6 = new HashMap<>();
		yourMap6.put("id","bidder006");
		yourMap6.put("billId","zhucai001");
		yourMap6.put("price","156.12");
		yourList.add(yourMap6);

		Map<String,Object> yourMap7 = new HashMap<>();
		yourMap7.put("id","bidder007");
		yourMap7.put("billId","zhucai001");
		yourMap7.put("price","155.12");
		yourList.add(yourMap7);

		Map<String,Object> yourMap8 = new HashMap<>();
		yourMap8.put("id","bidder008");
		yourMap8.put("billId","zhucai001");
		yourMap8.put("price","154.23");
		yourList.add(yourMap8);

//		Map<String,Object> yourMap9 = new HashMap<>();
//		yourMap9.put("id","bidder009");
//		yourMap9.put("billId","zhucai001");
//		yourMap9.put("price","4500");
//		yourList.add(yourMap9);

		/// ////////////////////////////////////////

		Map<String,Object> BillCPMapItem1 = new HashMap<>();
		BillCPMapItem1.put("id","zhucai001");
		BillCPMapItem1.put("price","158.6");
		BillCPMap.add(BillCPMapItem1);

//		Map<String,Object> BillCPMapItem2 = new HashMap<>();
//		BillCPMapItem2.put("id","zhucai002");
//		BillCPMapItem2.put("price","1000");
//		BillCPMap.add(BillCPMapItem2);



		env.put("SPEP", yourList); // 替换为您的 arr 列表
		env.put("BillCP", BillCPMap); // 替换为您的 arr 列表


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