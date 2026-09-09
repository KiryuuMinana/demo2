/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请输入(0,30]之间的数字，最多2位小数
 */
public class RegexTest12 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		// ^(?!0(\.0{1,2})?$)([0-9]?(\.\d{1,2})?|[1-2][0-9](\.\d{1,2})?|30(\.0{1,2})?)$
		String regex = "^(?!0(\\.0{1,2})?$)([0-9]?(\\.\\d{1,2})?|[1-2][0-9](\\.\\d{1,2})?|30(\\.0{1,2})?)$";
		String value = "9.00";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}