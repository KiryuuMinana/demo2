/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * fn regRule(){return "^[1-2|,]+$";} return regRule();
 * |
 * fn regRule(){return "^(?:(?!,)(?:[1-2],){1,}[1-2](?=,|$)|)$";} return regRule();
 */

/**
 * 1. 空字符串可以被校验通过
 * 2. 数字1到9可以被校验通过，但前提是至少有两个数字，并且每个数字之间有逗号相隔
 */
public class Regex12Test {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
//		String regex = "^[1-2|,]+$";
//		String regex = "^(?:(?!,)(?:[1-9],){1,}[1-9](?=,|$)|)$";
		// 只有1和2允许通过
//		String regex = "^(?:(?!,)(?:[1-2],){1,}[1-2](?=,|$)|)$";
		String regex = "^(?:(?!,)(?:[1-6],){1,}[1-6](?=,|$)|)$";
		String value = "4,5,4,6";
		boolean b = validateWithRegex(regex, value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
}

//fn regRule(){ return "^([1-4],?){2,4}$";} return regRule();
//fn regRule(){ return "^(?:(?!,)(?:[1-4],){1,}[1-4](?=,|$)|)$";} return regRule();
