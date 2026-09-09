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
public class Regex5Test {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
//		String regex = "^(?!.*((?:9[5-7]|9[5-7]\\.5|98)%)(?=.*\\1))(?:(?:9[5-7]|9[5-7]\\.5|98)%)(?:,(?:(?:9[5-7]|9[5-7]\\.5|98)%))*$";
		String regex = "^(?!.*((?:9[5-7]|9[5-7]\\.5|98)%)(?=.*\\1))(?:(?:9[5-7]|9[5-7]\\.5|98)%)(?:,(?:(?:9[5-7]|9[5-7]\\.5|98)%))+$";
		String value = "96%";
		value = "95%";
		value = "95%,98%";
		value = "95%,98%,98.5%";
		value = "95%,98%,95%";
		value = "95%,98%,95.5%";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}