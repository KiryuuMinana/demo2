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
public class RegexTest2 {
	public static void main(String[] args) {
		String value = "95%,98%,98.1%";
		String regex = "^(?!.*((?:9[5-8](?:\\.[0-9]{1,2})?)%)(?=.*\\1))(?:(?:9[5-8](?:\\.[0-9]{1,2})?)%)(?:,(?:(?:9[5-8](?:\\.[0-9]{1,2})?)%))*$";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}


	/**
	 * 正则表达式校验方法
	 *
	 * @param regex 正则表达式字符串，用于定义匹配规则
	 * @param value 待校验的字符串值
	 * @return 如果给定的字符串值与提供的正则表达式匹配，则返回 `true`；否则返回 `false`
	 */
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
}