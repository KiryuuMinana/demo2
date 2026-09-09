/**
 * Copyright (C) 2025, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 成都算法自测校验正则表达式脚本
 */
public class ChengDuRegex {
	public static void main(String[] args) {


		String e1 = getDyanamicE2();
		String e1Value = "5.00";

		boolean b;

		b = validateWithRegex(e1, e1Value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}

	private static String getN1(){
		return "^(5\\d(\\.\\d{1,2})?|6\\d(\\.\\d{1,2})?|70(\\.0{1,2})?)$";
	}

	private static String getN3(){
		return "^(9\\d(\\.\\d{1,2})?|100(\\.0{1,2})?)$";
	}

	/**
	 * 请输入不小于0.5的扣分值，最多支持小数点两位，每低1%所扣分值不得高于每高1%所扣分值
	 */
	private static String getE1(){
		return "^([1-9](\\.\\d{1,2})?|[1-9]\\d(\\.\\d{1,2})?|(100(\\.0{1,2})?|0\\.([5-9]\\d?)))$";
	}

	private static String getDynamicE1() {
		return "";
	}

	private static String getDyanamicE2() {
		return "^([6-9](\\.\\d{1,2})?|[1-9]\\d(\\.\\d{1,2})?|(100(\\.0{1,2})?|5\\.([1-9]\\d?|0[0-9])))$";
	}
}