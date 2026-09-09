/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StringHalfTest2 {
	// 定义最大字节数为31KB
	private static final int MAX_BYTES = 31 * 1024;

	public static List<String> splitString(String input) {
		List<String> result = new ArrayList<>();
		// 如果输入字符串为空或长度为0，直接返回空列表
		if (input == null || input.isEmpty()) {
			return result;
		}
		// 如果输入字符串长度小于等于最大字节数，直接返回包含该字符串的列表
		if (input.length() * 2 <= MAX_BYTES) {
			result.add(input);
			return result;
		}

		int index = 0;
		int length = input.length();

		while (index < length) {
			int start = index;
			int end = index;

			// 找到当前部分的最大字符数
			while (end < length) {
				// 计算当前部分的字节数
				int currentBytes = (end - start) * 2;
				if (currentBytes >= MAX_BYTES) {
					break;
				}
				end++;
			}

			// 如果超出了最大字节数，回退一个字符
			if ((end - start) * 2 > MAX_BYTES) {
				end--;
			}

			// 截取子字符串并添加到结果列表
			String substring = input.substring(start, end);
			result.add(substring);

			// 更新索引
			index = end;
		}

		return result;
	}
}