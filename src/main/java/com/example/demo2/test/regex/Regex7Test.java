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
public class Regex7Test {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String oldRegex = "^(?!.*((?:9[5-8](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:9[5-8](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:9[5-8](?:\\.[0-9]{1,2})?)%))*$";
//		String newRegex = "^(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.\\d{1,2})?|98(?:\\.0{1,2})?)%(?:,(?!.*\\b\\1\\b)(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.\\d{1,2})?|98(?:\\.0{1,2})?)%)*$";
		String newRegex = "^(?!.*((?:9[5-7](?:\\.[0-9]{1,2})?|98(?:\\.0{1,2})?)%)(?=.*\\1))(?:(?:9[5-7](?:\\.[0-9]{1,2})?|98(?:\\.0{1,2})?)%)(?:,(?:(?:9[5-7](?:\\.[0-9]{1,2})?|98(?:\\.0{1,2})?)%))+$";
//		String value = "98.01%";
//		String value = "98.00%";
//		String value = "95.00%";
//		String value = "95.00%,96.03%";
		String value = "95.00%,96.03%,98.00%,98.00%";
		boolean b = validateWithRegex(oldRegex, value);
		if(b){
			System.out.println("老正则校验通过");
		}else {
			System.out.println("老正则失败");
		}

		b = validateWithRegex(newRegex, value);
		if(b){
			System.out.println("新正则校验通过");
		}else {
			System.out.println("新正则失败");
		}
	}
}