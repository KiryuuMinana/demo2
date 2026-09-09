/**
 * Copyright (C) 2025, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 成都算法 E1 系数验证专用
 */
public class ChengDuE1Demo {

	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

//		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\e1e2plus.av";
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\cd_b001_e1.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();
		env.put("E2",5);

		// 执行 Aviator 脚本
		Object result = expression.execute(env);

		// 处理脚本执行结果
		if (result != null) {
			if (result instanceof String) {
				System.out.println((String)result);
			}
		}
	}
}