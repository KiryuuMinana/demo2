/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.math.BigDecimal;

/**
 *
 */
public class BigdecimalTest2 {
	public static void main(String[] args) {
		// 测试Bigdecimal 两位数相乘的时候，小数位怎么取？
		BigDecimal a = new BigDecimal("0.8000"); // a是两位小数
		BigDecimal b = new BigDecimal("100"); // b是三位小数
		BigDecimal c = a.multiply(b); // c=a*b
		System.out.println(c); // 输出c的值
		System.out.println(c.scale()); // 输出c的小数位数
		// 结论 c的小数位 = a的小数位 + b的小数位
	}
}

// 编标页面80 --> 招标文件0.8 --> 乘一百以后是80.0 -->去掉两位小数 80
// 编标页面80.1 --> 招标文件0.801 --> 乘一百以后是80.100 -->去掉两位小数 80.1
// 编标页面80.00 --> 招标文件0.8000 --> 乘一百以后是80.0000 -->去掉两位小数 80.00