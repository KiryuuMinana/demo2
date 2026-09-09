/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;

/**
 *
 */
public class AvaitorBase {
	public static void main(String[] args) throws IOException {
		// 定义 Aviator 脚本

//		String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\e1e2.av";
//
//		// 编译 Aviator 脚本
//		Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
//
//		// 执行 Aviator 脚本
//		Object result = expression.execute();


		AviatorEvaluator.validate("fn rangeE1E2(param1,param2) { if(param2 == nil) { return \"^(?!0(\\\\.0{1,2})?$)([0-9]?(\\\\.\\\\d{1,2})?|10(\\\\.0{1,2})?)$\";} if(param1>param2) {return \"^(?!0(\\\\.0{1,2})?$)([0-9]?(\\\\.\\\\d{1,2})?|10(\\\\.0{1,2})?)$\";} else {return \"^999999999999998888999$\";} } return rangeE1E2(E1,E2);");
	}
}