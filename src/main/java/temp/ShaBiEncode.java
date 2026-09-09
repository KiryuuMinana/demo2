/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.io.UnsupportedEncodingException;

/**
 *
 */
public class ShaBiEncode {
	public static String encrypt(String input) {
		StringBuilder binaryStringBuilder = new StringBuilder();

		try {
			byte[] bytes = input.getBytes("UTF-8");
			for (byte b : bytes) {
				// 转换每个字节为8位二进制字符串，并添加到结果中
				String binaryStr = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
				for (char bit : binaryStr.toCharArray()) {
					if (bit == '0') {
						binaryStringBuilder.append("傻");
					} else {
						binaryStringBuilder.append("比");
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error encoding string to UTF-8", e);
		}

		return binaryStringBuilder.toString();
	}

	public static String decrypt(String encodedStr) {
		StringBuilder binaryBuilder = new StringBuilder();

		for (char c : encodedStr.toCharArray()) {
			if (c == '傻') {
				binaryBuilder.append('0');
			} else if (c == '比') {
				binaryBuilder.append('1');
			}
		}

		byte[] bytes = new byte[binaryBuilder.length() / 8];
		for (int i = 0; i < bytes.length; i++) {
			String binaryByte = binaryBuilder.substring(i * 8, (i + 1) * 8);
			bytes[i] = (byte) Integer.parseInt(binaryByte, 2);
		}

		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error decoding string from UTF-8", e);
		}
	}

	public static void main(String[] args) {
		String original = "郭伟，来喝酒！";
		String encrypted = encrypt(original);
		System.out.println("加密后的字符串:");
		printWithLineBreaks(encrypted, 50);

		String decrypted = decrypt("比比比傻比傻傻比比傻傻傻傻傻比比比傻比傻比比傻比比比比傻傻比傻傻比傻比比比比傻傻比傻傻比比比比比比比\n" +
				"比傻比比比比比傻比比比比傻傻比傻傻傻比比傻傻比比比傻傻比比傻比傻傻比比比傻比比傻比傻傻比傻比比比比傻\n" +
				"傻比傻比比傻傻比傻比比傻比傻傻比比比傻比比比比傻比傻傻比比傻傻傻傻比傻比比傻傻比傻傻比傻比比比傻比比\n" +
				"比比比傻比比比比傻傻比傻傻傻傻傻傻比");
		System.out.println("解密后的字符串: " + decrypted);
	}

	// 辅助方法：每50个字符换一行
	private static void printWithLineBreaks(String str, int lineLength) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if ((i + 1) % lineLength == 0 && i + 1 < str.length()) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}