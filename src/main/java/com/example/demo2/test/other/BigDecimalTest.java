/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.math.BigDecimal;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-10-17 15:55:24
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		// 测试Bigdecimal的构造函数，允许接受几位小数？
//		BigDecimal bigDecimal1 = new BigDecimal("123456.1");
//		BigDecimal bigDecimal2 = new BigDecimal("123456.12");
//		BigDecimal bigDecimal3 = new BigDecimal("123456.123");
//		BigDecimal bigDecimal4 = new BigDecimal("123456.1234");
//		BigDecimal bigDecimal5 = new BigDecimal("123456.12345");
//		BigDecimal bigDecimal6 = new BigDecimal("123456.123456");
//
//		System.out.println(bigDecimal6);
//		System.out.println(bigDecimal6.scale());
//		System.out.println(bigDecimal6.toPlainString());
//
//		System.out.println(bigDecimal3);
//		System.out.println(bigDecimal3.scale());
//		System.out.println(bigDecimal3.toPlainString());


//		BigDecimal basePrice = new BigDecimal("90.485500");
//		String basePriceShow = basePrice.setScale(3, BigDecimal.ROUND_HALF_DOWN).toPlainString();
//		System.out.println(basePriceShow);

		// 测试Bigdecimal 两位数相乘的时候，小数位怎么取？
		BigDecimal a = new BigDecimal("5.28000"); // a是两位小数
		BigDecimal b = new BigDecimal("4.215"); // b是三位小数
		BigDecimal c = a.multiply(b); // c=a*b
		System.out.println(c); // 输出c的值
		System.out.println(c.scale()); // 输出c的小数位数
		// 结论 c的小数位 = a的小数位 + b的小数位

	}
}