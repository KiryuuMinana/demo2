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
public class ZhengZeTest {
	public static void main(String[] args) {
		String oldRegex    = "^(?:(?!.*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b.*\\b\\1\\b)(?:(?:0(?:\\.00)?|100(?:\\.00)?|(?:(?!0|100)\\d{1,2}(?:\\.\\d{1,2})?))%)(?:,(?!$)|$))+$";
		String newRegex    = "^(?:(?!.*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b.*\\b\\1\\b)(?:(?:0(?:\\.00)?|100(?:\\.00)?|(?:(?!100)\\d{1,2}(?:\\.\\d{1,2})?))%)(?:,(?!$)|$)){2,}$";
		String LingMaRegex = "";
//		String gptRegex = "^(?:.*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b(?!.*\\b\\1\\b).*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b(?!.*\\b\\2\\b)|.*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b(?!.*\\b\\1\\b))(?:(?:0(?:\\.00)?|100(?:\\.00)?|(?:(?!100)\\d{1,2}(?:\\.\\d{1,2})?))%(?:,(?!$)|$)){2,}$";
//		String regex = "^(?=.*,).*(?:(?!.*\\b(\\d{1,2}(?:\\.\\d{1,2})?)%\\b.*\\b\\1\\b)(?:(?:0(?:\\.00)?|100(?:\\.00)?|(?:(?!0|100)\\d{1,2}(?:\\.\\d{1,2})?))%)(?:,(?!$)|$))+$";
//		String value = "0.00%";
//		String value = "1.00%";
//		String value = "0.01%";   // 不通过
//		String value = "1.01%";
//		String value = "10.01%";
//		String value = "10.01%,99.99%";
//		String value = "10.01%,0.00%";
//		String value = "1.01%,1.00%,99.00%,99.99%,0.99%";
//		String value = "0.99%,0.99%";
//		String value = "100.01%,0.00%";
		String value = "0.01%,0.02%";
//		String value = "10.01%,";
//		String value = ",10.01%";  // 通过判断逗号的形式，这样是可以通过的，因此第三个regex不能采用
//		boolean b = validateWithRegex(LingMaRegex, value);
		boolean b = validateWithRegex(newRegex, value);
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

