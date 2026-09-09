/**
 * Copyright (C) 2020-2025, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.nio.charset.StandardCharsets;

/**
 *
 */
public class BinaryTest {
	public static void main(String[] args) {
		// 示例二进制字符串，表示“你好”
		String binaryString = "11100100 11010000 11100100 11001000";

		// 调用方法进行转换
		String result = binaryToChinese(binaryString);
		System.out.println("转换结果: " + result);
	}

	/**
	 * 将二进制字符串转换为中文字符
	 * @param binaryString 二进制字符串，每个字符用空格分隔
	 * @return 转换后的中文字符串
	 */
	public static String binaryToChinese(String binaryString) {
		// 将二进制字符串拆分为字节单位（每8位为一组）
		String[] binaryBytes = binaryString.split(" ");
		byte[] bytes = new byte[binaryBytes.length];

		// 将每个二进制字符串转换为字节
		for (int i = 0; i < binaryBytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(binaryBytes[i], 2);
		}

		// 使用UTF-8字符集解码字节数组
		return new String(bytes, StandardCharsets.UTF_8);
	}
}