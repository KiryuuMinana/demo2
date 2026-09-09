/**
 * Copyright (C) 2025, 雾生三柒.
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
 * universal_list_id_calc.av
 * <p>
 * 两个列表按 id 对齐后通用运算，operate：1加 2减 3乘 4除 5取余
 */
public class AvaitorDemoUniversalListIdCalc {
	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\universal_list_id_calc.av";
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath, true);

		List<Map<String, Object>> list1 = buildList(
				item("a", "10"),
				item("b", "20"),
				item("c", "30")
		);
		List<Map<String, Object>> list2 = buildList(
				item("b", "5"),
				item("c", "15"),
				item("d", "40")
		);

		// ========== 用例1：加法 operate=1 ==========
		// a=10, b=25, c=45, d=40
		runCase(expression, "用例1(加)", list1, list2, 1);

		// ========== 用例2：减法 operate=2 ==========
		// a=10, b=15, c=15, d=40
		runCase(expression, "用例2(减)", list1, list2, 2);

		// ========== 用例3：乘法 operate=3 ==========
		// a=10, b=100, c=450, d=40
		runCase(expression, "用例3(乘)", list1, list2, 3);

		// ========== 用例4：实际项目 JLDY + ZXDY（加） ==========
		// 0aa828ce=34, 95d922ca=33, b7b08c8e=35
		runCase(expression, "用例4(实际JLDY+ZXDY加)", buildRealJldy(), buildRealZxdy(), 1);
	}

	private static void runCase(Expression expression, String title,
								List<Map<String, Object>> list1,
								List<Map<String, Object>> list2,
								int operate) {
		Map<String, Object> env = new HashMap<>();
		env.put("list1", list1);
		env.put("list2", list2);
		env.put("operate", operate);
		System.out.println(title + " operate=" + operate);
		printResult(expression.execute(env));
	}

	private static List<Map<String, Object>> buildRealJldy() {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(item("95d922ca410e4edfabf09dd65e1274a3", "18.00"));
		list.add(item("45e9446d398848e7bd4b9e7b3c21c538", "18.00"));
		list.add(item("0aa828ce8f5c4efbb01a366cb913c995", "20.00"));
		list.add(item("4e63b74c497b4ef78e7446abed8d7bcf", "18.00"));
		list.add(item("37cc3d40adc64688ac9a8f176e5a15cd", "20.00"));
		list.add(item("dc20fda420644749b6f6212df56696c7", "18.00"));
		list.add(item("b7b08c8e49c14ac8acd612dc860ec98b", "20.00"));
		list.add(item("dab6df2ce36845f5a6ab4bbbbfa122b1", "18.00"));
		list.add(item("f42a9099977b4b98997085fe61124c0f", "18.00"));
		list.add(item("d8df7fbc33424185bb5861fc40b6221c", "18.00"));
		list.add(item("93de6aec264d4f57835ccc5c94121f60", "18.00"));
		return list;
	}

	private static List<Map<String, Object>> buildRealZxdy() {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(item("95d922ca410e4edfabf09dd65e1274a3", "15.00"));
		list.add(item("45e9446d398848e7bd4b9e7b3c21c538", "15.00"));
		list.add(item("0aa828ce8f5c4efbb01a366cb913c995", "14.00"));
		list.add(item("4e63b74c497b4ef78e7446abed8d7bcf", "14.00"));
		list.add(item("37cc3d40adc64688ac9a8f176e5a15cd", "14.00"));
		list.add(item("dc20fda420644749b6f6212df56696c7", "14.00"));
		list.add(item("b7b08c8e49c14ac8acd612dc860ec98b", "15.00"));
		list.add(item("dab6df2ce36845f5a6ab4bbbbfa122b1", "14.00"));
		list.add(item("f42a9099977b4b98997085fe61124c0f", "14.00"));
		list.add(item("d8df7fbc33424185bb5861fc40b6221c", "14.00"));
		list.add(item("93de6aec264d4f57835ccc5c94121f60", "14.00"));
		return list;
	}

	@SafeVarargs
	private static List<Map<String, Object>> buildList(Map<String, Object>... items) {
		List<Map<String, Object>> list = new ArrayList<>();
		for (Map<String, Object> item : items) {
			list.add(item);
		}
		return list;
	}

	private static Map<String, Object> item(String id, String price) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("price", new BigDecimal(price));
		return map;
	}

	@SuppressWarnings("unchecked")
	private static void printResult(Object result) {
		if (result instanceof List) {
			for (Map<String, Object> row : (List<Map<String, Object>>) result) {
				System.out.println(row);
			}
		} else {
			System.out.println(result);
		}
		System.out.println("----------");
	}
}
