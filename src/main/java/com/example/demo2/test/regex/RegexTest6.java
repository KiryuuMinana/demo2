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
public class RegexTest6 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String oldRegex = "^(?!.*((?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%))*$";
		String newRegex = "^(?!.*((?:[6-9](?:\\.[0-9]{1,2})?|25(?:\\.[0]{1,2})?|2[0-4](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:[6-9](?:\\.[0-9]{1,2})?|25(?:\\.[0]{1,2})?|2[0-4](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:[6-9](?:\\.[0-9]{1,2})?|25(?:\\.[0]{1,2})?|2[0-4](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%))+$";
//		String value = "6.00%";
//		String value = "6.0%";
//		String value = "6%";
//		String value = "6.01%";
//		String value = "25.00%";
//		String value = "25.01%";
//		String value = "25.99%";
//		String value = "26.00%";
//		String value = "26.01%";
//		String value = ",24.01%";
//		String value = "23.99%,24.01%";
//		String value = "23.99%,";
//		String value = "23.99%,6.01%";
		String value = "23.99%,6.01%,25.0%";
//		String value = "23.99%,6.01%,25%,25.02%";
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