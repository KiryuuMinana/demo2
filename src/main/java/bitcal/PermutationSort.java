/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

/**
 *
 */
public class PermutationSort {
	public static void main(String[] args) {
		String input = "QW5K";
		String order = "4321";
		String result = reorderString(input, order);
		System.out.println("Original String: " + input);
		System.out.println("Reordered String: " + result);
	}

	public static String reorderString(String input, String order) {
		if (input == null || order == null || input.length() != order.length()) {
			throw new IllegalArgumentException("Input and order strings must be non-null and of the same length");
		}

		char[] result = new char[input.length()];
		char[] inputChars = input.toCharArray();
		char[] orderChars = order.toCharArray();

		for (int i = 0; i < orderChars.length; i++) {
			int position = orderChars[i] - '1'; // 将字符 '1' 映射到索引 0
			result[position] = inputChars[i];
		}

		return new String(result);
	}
}