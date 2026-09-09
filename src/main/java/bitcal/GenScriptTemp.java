/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GenScriptTemp {

	public static void writeNumbersToFileDouHao(List<Integer> numbers, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			for (int number : numbers) {
				writer.write(number + ",");
			}
		} catch (IOException e) {
			System.err.println("写入文件时发生错误: " + e.getMessage());
		}
	}
	/**
	 * 找到从0到2的m次方之间的所有十进制数字中，恰好有n个二进制位是1的十进制数字集合。
	 *
	 * @param m 二进制位数
	 * @param n 恰好有n个二进制位是1
	 * @return 恰好有n个二进制位是1的十进制数字集合
	 */
	public static List<Integer> findNumbersWithNOnes(int m, int n) {
		List<Integer> result = new ArrayList<>();
		// 最多生成x个
		int x = 15;
		// 从0到2^m-1遍历
		for (int i = 0; i < (1L << m); i++) {
			if (countOnes(i) == n) {
				result.add(i);
			}
			if(result.size() >= x){
				break;
			}
		}


		return result;
	}
	/**
	 * 计算一个整数的二进制表示中有多少个1。
	 *
	 * @param number 需要计算的整数
	 * @return 二进制表示中1的数量
	 */
	private static int countOnes(int number) {
		int count = 0;
		while (number > 0) {
			count += number & 1;
			number >>= 1;
		}
		return count;
	}
	public static void main(String[] args) {
		int m = 6; // 示例：36位二进制数 long 64
		int n = 2; // 示例：恰好有4个1
		List<Integer> numbers = findNumbersWithNOnes(m, n);
		System.out.println("暗标可用随机字符种类为"+ m + "个字符时，恰好有 " + n + " 个1的十进制数字集合，生成了: "+ numbers.size() + "个，具体为：" + numbers);
		// 将结果写入本地文件
		String filename2 = "长度为" + n +"，二进制长度为" + m +"以下时.txt";
		writeNumbersToFileDouHao(numbers, filename2);

	}
}