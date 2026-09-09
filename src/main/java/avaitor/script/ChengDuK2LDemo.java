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

public class ChengDuK2LDemo {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

//		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\e1e2plus.av";
//		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\CD-J002-01-K2L.av";
		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\CD-J002-01-K2R.av";

		// 编译 Aviator 脚本
		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
		// 准备输入参数
		Map<String, Object> env = new HashMap<>();
//		env.put("K2R",0.6);
		env.put("K2L",0.3);

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