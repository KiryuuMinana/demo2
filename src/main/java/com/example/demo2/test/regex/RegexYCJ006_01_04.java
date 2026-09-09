/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A1 支持填写[0-1]之间，最多2位小数
 * AF 支持填写[0-1]之间，最多2位小数，以逗号分割，至少2个数值
 * A2 请从招标文件规定的范围值里填写
 * HNb LNb 支持填写[0-100]之间的整数
 * HPc LPc 支持填写[0-100]之间，最多2位小数
 * PF 支持填写(0-10000]之间整数  ------> 改为[0-10000]
 */
public class RegexYCJ006_01_04 {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
//		String regex = "0\\.([6-9]\\d?)(,0\\.([6-9]\\d?)){2}";
//		String value = "0.82,0.87,0.65";
		String a1Regex = getA1Regex();
		String afRegex = getAFRegex();
		String hNbRegex = getHNbRegex();
		String hPcRegex = getHPcRegex();
		String pfRegex = getPFRegex();
		String pf2Regex = getPF2Regex();

		String a1Value = "0.5";
		String afValue = "0.88";
//		String afValue = "0.5,1,0,0.88";
		String hNbValue = "17";
		String hPcValue = "8.88";
		String pfValue = "0";
		String pf2Value = "10";

		boolean b;
//		b = validateWithRegex(a1Regex, a1Value);
//		b = validateWithRegex(afRegex, afValue);
//		b = validateWithRegex(hNbRegex, hNbValue);
//		b = validateWithRegex(hPcRegex, hPcValue);
//		b = validateWithRegex(pfRegex, pfValue);
		b = validateWithRegex(pf2Regex, pf2Value);
		if(b){
			System.out.println("正则校验通过");
		}else {
			System.out.println("失败");
		}
	}

	/**
	 * A1 支持填写[0-1]之间，最多2位小数
	 */
	private static String getA1Regex(){
		return "^(0(\\.\\d{1,2})?|1(\\.0{1,2})?|0(\\.0{1,2})?)$";
	}

	/**
	 * AF 支持填写[0-1]之间，最多2位小数，以逗号分割，至少2个数值
	 */
	private static String getAFRegex(){
		return "^(0(\\.\\d{1,2})?|1(\\.0{1,2})?|0(\\.0{1,2})?)(,(0(\\.\\d{1,2})?|1(\\.0{1,2})?|0(\\.0{1,2})?))+$";
	}

	/**
	 * HNb 支持填写[0-100]之间的整数
	 */
	private static String getHNbRegex(){
		return "^(100|[1-9]?[0-9])$";
	}

	/**
	 * HPc 支持填写[0-100]之间，最多2位小数
	 */
	private static String getHPcRegex(){
		return "^(100(\\.0{1,2})?|0(\\.\\d{1,2})?|[1-9]\\d?(\\.\\d{1,2})?)$";
	}

	/**
	 * PF 支持填写(0-10000]之间整数
	 */
	private static String getPFRegex(){
		return "^(?!0?$)(0|[1-9]\\d{0,3}|10000)$";
	}

	/**
	 * PF 支持填写[0-10000]之间整数
	 */
	private static String getPF2Regex(){
		return "^(0|[1-9]\\d{0,3}|10000)$";
	}
}