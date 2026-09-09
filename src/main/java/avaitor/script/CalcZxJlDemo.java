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
 * calc_zx_jl.av
 * <p>
 * 用例设计要点：list 中故意放入不在 arr（BPS）中的高分单位，
 * 若不做过滤会误取该单位；过滤后应只在 BPS 交集内取最高分再算均价。
 */
public class CalcZxJlDemo {
	public static void main(String[] args) throws IOException {
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\calc_zx_jl.av";
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath, true);

		// ========== 用例1：过滤掉 list 中不在 arr 的更高分单位 ==========
		// arr(BPS): b1=100, b2=200, b3=300
		// list得分: bOut=99(不在arr，应被过滤), b2=95, b1=90, b3=80
		// 期望: 过滤后最高分为 b2=95，均价 = 200
		Map<String, Object> env1 = new HashMap<>();
		env1.put("arr", buildBps());
		env1.put("list", buildScoreListForFilter());
		Object result1 = expression.execute(env1);
		System.out.println("用例1(体现过滤)-期望200, 实际=" + result1);

		// ========== 用例2：过滤后存在多个最高分并列 ==========
		// arr 同上
		// list得分: bOut=100(不在arr), b1=95, b2=95, b3=80
		// 期望: 过滤后最高分为 b1、b2，均价 = (100+200)/2 = 150
		Map<String, Object> env2 = new HashMap<>();
		env2.put("arr", buildBps());
		env2.put("list", buildScoreListForTie());
		Object result2 = expression.execute(env2);
		System.out.println("用例2(过滤后同分)-期望150, 实际=" + result2);

		// ========== 用例3：实际项目流转数据 ==========
		// BPS 共7家；JLDY/ZXDY 中另有不在 BPS 的高分单位，用于验证过滤
		// 项目侧参考 AVG=3744166.1886（BPS全量均价，非本脚本单次入参期望）
		//
		// JLDY：过滤后最高分20仅剩 0aa828ce...（37cc3d40、b7b08c8e 同为20但不在BPS）
		//       期望均价 = 3985654.5000
		// ZXDY：过滤后最高分15为 95d922ca...、45e9446d...（b7b08c8e 同为15但不在BPS）
		//       期望均价 = (3778000.8300+3778000.8300)/2 = 3778000.8300
		List<Map<String, Object>> realBps = buildRealBps();

		Map<String, Object> envJldy = new HashMap<>();
		envJldy.put("arr", realBps);
		envJldy.put("list", buildRealJldy());
		Object resultJldy = expression.execute(envJldy);
		System.out.println("用例3-JLDY(实际项目)-期望3985654.5000, 实际=" + resultJldy);

		Map<String, Object> envZxdy = new HashMap<>();
		envZxdy.put("arr", realBps);
		envZxdy.put("list", buildRealZxdy());
		Object resultZxdy = expression.execute(envZxdy);
		System.out.println("用例3-ZXDY(实际项目)-期望3778000.8300, 实际=" + resultZxdy);
		System.out.println("用例3-项目侧参考AVG(BPS全量均价)=" + new BigDecimal("3744166.1886"));
	}

	/** BPS：有效投标单位报价 */
	private static List<Map<String, Object>> buildBps() {
		List<Map<String, Object>> arr = new ArrayList<>();
		arr.add(item("b1", "100"));
		arr.add(item("b2", "200"));
		arr.add(item("b3", "300"));
		return arr;
	}

	/**
	 * 得分列表：bOut 分数最高但不在 BPS 中，用于验证过滤。
	 * 不过滤会误取 bOut；过滤后最高应为 b2。
	 */
	private static List<Map<String, Object>> buildScoreListForFilter() {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(item("bOut", "99"));
		list.add(item("b2", "95"));
		list.add(item("b1", "90"));
		list.add(item("b3", "80"));
		return list;
	}

	/**
	 * 得分列表：bOut 更高但不在 BPS；过滤后 b1、b2 并列最高分。
	 */
	private static List<Map<String, Object>> buildScoreListForTie() {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(item("bOut", "100"));
		list.add(item("b1", "95"));
		list.add(item("b2", "95"));
		list.add(item("b3", "80"));
		return list;
	}

	/** 实际项目 BPS */
	private static List<Map<String, Object>> buildRealBps() {
		List<Map<String, Object>> arr = new ArrayList<>();
		arr.add(item("0aa828ce8f5c4efbb01a366cb913c995", "3985654.5000"));
		arr.add(item("45e9446d398848e7bd4b9e7b3c21c538", "3778000.8300"));
		arr.add(item("95d922ca410e4edfabf09dd65e1274a3", "3778000.8300"));
		arr.add(item("93de6aec264d4f57835ccc5c94121f60", "3778000.8300"));
		arr.add(item("d8df7fbc33424185bb5861fc40b6221c", "3750000.0000"));
		arr.add(item("dab6df2ce36845f5a6ab4bbbbfa122b1", "3750000.0000"));
		arr.add(item("dc20fda420644749b6f6212df56696c7", "3389506.3300"));
		return arr;
	}

	/**
	 * 实际项目 JLDY。
	 * 其中 4e63b74c、37cc3d40、b7b08c8e、f42a9099 不在 BPS，应被过滤；
	 * 37cc3d40、b7b08c8e 得分同为20，不过滤会干扰最高分选取。
	 */
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

	/**
	 * 实际项目 ZXDY。
	 * 其中 4e63b74c、37cc3d40、b7b08c8e、f42a9099 不在 BPS，应被过滤；
	 * b7b08c8e 得分同为15，不过滤会多算一家。
	 */
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

	private static Map<String, Object> item(String id, String price) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("price", new BigDecimal(price));
		return map;
	}
}

