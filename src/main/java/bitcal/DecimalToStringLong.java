/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

import cn.hutool.core.date.StopWatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */
public class DecimalToStringLong {
	// 字符串库，共有36个字符，按题目要求的顺序排列
	private static final String str = "0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()<>?/;:'0123456789";

	public static String decimalToString(long num, int m) {
		// 初始化结果字符串
		StringBuilder result = new StringBuilder();

		// 从右到左检查每一位
		for (int i = 0; i < 64; i++) {
//			System.out.printf("Checking i = %d: (num & (1 << %d)) = (%d & %d) = %d\n",
//					i, i, num, (1L << i), (num & (1L << i)));
			// 检查num的第i位是否为1
			if ((num & (1L << i)) != 0) {
				// 如果第i位为1，则对应字符加入结果
				result.append(str.charAt(m - i)); // 35-i对应的是从右到左的字符
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("Task 1");
//		for(int i = (int)(Math.pow(2,36))-1 ; i > (int)(Math.pow(2,36))-1-50000; i--){
//			System.out.println(decimalToString(i));
//		}
//		String filePath = "长度为4，二进制长度为36以下时，58905个.txt"; // 200ms
//		String filePath = "长度为5，二进制长度为36以下时，376992个.txt"; // 1360ms
//		String filePath = "长度为6，二进制长度为36以下时，1947792个.txt"; // 接近两百万个，用时5556ms 读文件+实时生成+打印
		String filePath = "plus_63_length_long12.txt"; // 两百万个，用时369ms 读文件+实时生成，不打印


		try {
			long[] numbers = readNumbers(filePath);
			for (long number : numbers) {
				System.out.println(decimalToString(number, 63 - 1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		stopWatch.stop();
		System.out.println("任务 'Task 1' 执行时间: " + stopWatch.getTotalTimeMillis() + " ms");
		System.out.println("任务 'Task 1' 执行时间: " + stopWatch.getLastTaskTimeMillis() + " ms");
	}


	// 将文件读入到内存中
	public static long[] readNumbers(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		StringBuilder contentBuilder = new StringBuilder();

		// 读取文件内容
		while ((line = reader.readLine()) != null) {
			contentBuilder.append(line);
		}
		reader.close();

		// 将字符串分割成数字数组
		String[] stringNumbers = contentBuilder.toString().split(",");
		long[] numbers = new long[stringNumbers.length];

		// 转换为int数组
		for (int i = 0; i < stringNumbers.length; i++) {
			numbers[i] = Long.parseLong(stringNumbers[i].trim());
		}

		return numbers;
	}
}