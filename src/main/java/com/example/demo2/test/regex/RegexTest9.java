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
public class RegexTest9 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
		String oldRegex = "^(?!.*((?:,[3-7]|,[3-6]\\.5)%)(?=.*1))(?:(?:[3-7]|[3-6]\\.5)%)((?:,(?:(?:[3-7]|[3-6]\\.5)%)){3,6})*$";
		String newRegex = "^(?!.*((?:,[3-7]|,[3-6]\\.5)%)(?=.*1))+(?:(?:[3-7]|[3-6]\\.5)%)((?:,(?:(?:[3-7]|[3-6]\\.5)%)){3,8})$";

//		String value = "7.5%";
//		String value = "6.5%";
//		String value = "6.5%,4%,3.5%";
//		String value = "6.5%,4%,3.5%,5.5%";
		String value = "3%,3.5%,4%,4.5%,5%,5.5%,6%,6.5%,7%";

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