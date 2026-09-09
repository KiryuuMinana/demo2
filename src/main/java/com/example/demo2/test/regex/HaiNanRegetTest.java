/**
 * Copyright (C) 2026, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HaiNanRegetTest {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String regex = "^(15|16|17|18|19|20)$";
		String value = "0";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}