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
public class Regex4Test {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String regex1 = "^(?!.*((?:[6-9](?:\\.[0-9]{1,2})?|2[0-6](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-6](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-6](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%))*$";
//		String regex2 = "^(?!.*((?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)|26(?:\\.0{1,2})?%)(?=.*\\1))(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)|26(?:\\.0{1,2})?%)(?:,(?:(?:[6-9](?:\\.[0-9]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)|26(?:\\.0{1,2})?%))*$";
		String regex3 = "^(?!.*((?:[6-9](?:\\.[0-9]{1,2})?|26(?:\\.[0]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:[6-9](?:\\.[0-9]{1,2})?|26(?:\\.[0]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:[6-9](?:\\.[0-9]{1,2})?|26(?:\\.[0]{1,2})?|2[0-5](?:\\.[0-9]{1,2})?|1[0-9](?:\\.[0-9]{1,2})?)%))+$";
//		String regex95_97 = "^(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.0{1,2})?)%(?:,(?!.*\\b\\1\\b)(95(?:\\.\\d{1,2})?|96(?:\\.\\d{1,2})?|97(?:\\.0{1,2})?)%)*$\n";
//		String value = "26%,27%";
		String value = "25%,22%";
//		String value = "25.2%,22.3%";
//		String value = "26.00%";
//		String value = "22.00%";
//		String value = "22.01%";
//		String value = "26.01%";

		boolean b = validateWithRegex(regex1, value);
		if(b){
			System.out.println("老正则校验通过");
		}else {
			System.out.println("老正则失败");
		}

		b = validateWithRegex(regex3, value);
		if(b){
			System.out.println("新正则校验通过");
		}else {
			System.out.println("新正则失败");
		}
	}

}