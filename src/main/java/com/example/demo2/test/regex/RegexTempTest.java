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
public class RegexTempTest {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String regex = "^(?!.*((?:9[3-6](?:\\.[0-9]{1,2})?|97(?:\\.0{1,2})?)%)(?=.*\\1))(?:(?:9[3-6](?:\\.[0-9]{1,2})?|97(?:\\.0{1,2})?)%)(?:,(?:(?:9[3-6](?:\\.[0-9]{1,2})?|97(?:\\.0{1,2})?)%))+$";

		boolean b = validateWithRegex(regex, "94%,97%,96.9%,95%");
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}