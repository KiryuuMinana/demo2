/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class RegexTest3 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String regex = "^(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.0{1,2})?)%(?:,(?!.*\\b\\1\\b)(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.0{1,2})?)%)+$";
//		String value = "97.00%,96.96%";
//		String value = "97.00%,94.99%";
//		String value = "96.00%,97.0%";
		String value = "96.00%";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}

}