/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StringHalfTest {
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
			// 计算当前剩余部分的最大字符数
			int maxChars = getMaxChars(input, index, MAX_BYTES);

			// 截取子字符串
			String substring = input.substring(index, index + maxChars);
			result.add(substring);

			// 更新索引
			index += maxChars;
		}

		return result;
	}

	private static int getMaxChars(String input, int startIndex, int maxBytes) {
		int currentBytes = 0;
		int index = startIndex;
		int length = input.length();

		while (index < length && currentBytes < maxBytes) {
			char c = input.charAt(index);
			// UTF-16编码中，每个字符占用2个字节
			currentBytes += 2;
			index++;
		}

		// 如果超出了最大字节数，回退一个字符
		if (currentBytes > maxBytes) {
			index--;
		}

		return index - startIndex;
	}

	public static void main(String[] args) {
		// 示例超大字符串
		String filePath = "F:\\工作\\产品线正式工作\\2024\\sprint43\\ccc.txt";
		StringBuilder contentBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				contentBuilder.append(line).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String largeStringBuilder = contentBuilder.toString();

		String largeString = largeStringBuilder.toString();

		List<String> splitStrings = splitString(largeString);
		System.out.println("Number of lines: " + splitStrings.size());

		// 打印每个拆分后的字符串长度
		for (int i = 0; i < splitStrings.size(); i++) {
			System.out.println("Line " + (i + 1) + " length: " + splitStrings.get(i).length() + " characters:" + splitStrings.get(i));
		}

	}
}