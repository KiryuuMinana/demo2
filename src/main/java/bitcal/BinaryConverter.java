/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

/**
 *
 */
public class BinaryConverter {

	/**
	 * 将 int 类型的十进制数字转换为二进制字符串。
	 *
	 * @param number 十进制数字
	 * @return 二进制字符串
	 */
	public static String toBinaryString(int number) {
		return Integer.toBinaryString(number);
	}

	/**
	 * 将 long 类型的十进制数字转换为二进制字符串。
	 *
	 * @param number 十进制数字
	 * @return 二进制字符串
	 */
	public static String toBinaryString(long number) {
		return Long.toBinaryString(number);
	}

	public static void main(String[] args) {
		long longNumber = 381;

		System.out.println("long 数字 " + longNumber + " 的二进制表示: " + toBinaryString(longNumber) + "二进制字符串长度" + toBinaryString(longNumber).length());
	}
}