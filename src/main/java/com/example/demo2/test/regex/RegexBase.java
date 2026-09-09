/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.regex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * （0,100]
 */
public class RegexBase {
	public static boolean validateWithRegex(String regex, String value) {
		// 使用Pattern类编译正则表达式
		Pattern pattern = Pattern.compile(regex);

		// 使用Matcher对象对给定的值进行匹配
		Matcher matcher = pattern.matcher(value);

		// 判断是否找到匹配项
		return matcher.matches();
	}
	public static void main(String[] args) {
//		String regex = "(?!0(\\.0{1,2})?$)([0-9]?(\\.\\d{1,2})?|10(\\.0{1,2})?)";
//		String regex = "(?!0(\\.0{1,2})?$)(\\d{0,2}?(\\.\\d{1,2})?|100(\\.0{1,2})?)";
		String regex = "^(?!0(\\.0{1,2})?$)(0(\\.0[0-1]?)?)$";

		float E1 = 0.02F;
		DecimalFormat df = new DecimalFormat("0.00");

		BigDecimal step = new BigDecimal("0.01");
		BigDecimal start = BigDecimal.ZERO;
		BigDecimal end = new BigDecimal("200");
		Boolean lastB = null;
		for (BigDecimal i = start; i.compareTo(end) <= 0; i = i.add(step)){
			String formattedValue = df.format(i);
			boolean b = validateWithRegex(regex, formattedValue);
			if (lastB != null && lastB != b){
				System.out.println("=============================本次将和上次校验结果不同===========注意变化============================");
			}
			if (!b){
				System.out.println("当前校验不通过，此时E1的值为：" + E1 + ",此时正在校验的值为：" + i);
			}else {
				System.out.println("当前校验通过,此时正在校验的值为：" + i);
			}
			if (i.compareTo(new BigDecimal(0)) != 0){
				lastB = b;
			}
		}

	}
}