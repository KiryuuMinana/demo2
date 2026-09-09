/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请输入[0,10]之间的数字，最多2位小数,
 * 且E1应大于 E2(通过动态正则实现)
 * 本类只看开闭区间
 */
public class RegexE1E2 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
//		String regex = "^([0-9]?(\\.\\d{1,2})?|10(\\.0{1,2})?)$";
//		String regex = "^((10(\\.0{0,2})?|10\\.([1-9]\\d?|0[1-9])))$";
		String regex = "^(|(100(\\.0{1,2})?))$";
		String value = "";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}