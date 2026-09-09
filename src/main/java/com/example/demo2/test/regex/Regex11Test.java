/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 帮我实现一个正则表达式，要求校验填写的数值为处于范围[0,100)内，支持最多一位小数，例如9.5、0、63.2可以通过，而1.88、100不可以通过
 */
public class Regex11Test {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String regex = "^(?!0(\\.0{1,2})?$)(\\d{0,2}?(\\.\\d{1,2})?|100(\\.0{1,2})?)$";
		String value = "100.00";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}