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
import java.util.stream.Collectors;

/**
 * 从大到小
 */
public class GenScirptPlus {


	public static void writeNumbersToFileDouHaoLong(List<Long> numbers, String filename) {

		String numbersString = numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write(numbersString);
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
	public static List<Long> findNumbersWithNOnesLong(int m, int n) {
		List<Long> result = new ArrayList<>();
		generateCombinations(0, m, n, 0, result);
		return result;
	}

	/**
	 * 组合生成算法：
	 * generateCombinations 方法递归地生成具有 n 个 1 的二进制数。
	 * 通过选择或不选择当前位，递归地构建所有可能的组合。
	 * 这种方法避免了遍历所有可能的数，从而显著提高了效率。
	 * 剪枝：
	 * 如果 n 为 0，表示已经找到一个符合条件的数，将其添加到结果集中。
	 * 如果 index 超过了 m，表示没有更多的位可以选择，直接返回。
	 */
	private static void generateCombinations(long current, int m, int n, int index, List<Long> result) {
		if (result.size() >= 2000000){
			return;
		}
		if (n == 0) {
			result.add(current);
			return;
		}
		if (index >= m) {
			return;
		}
		// 选择当前位
		generateCombinations(current | (1L << index), m, n - 1, index + 1, result);
		// 不选择当前位
		generateCombinations(current, m, n, index + 1, result);
	}

	public static void main(String[] args) throws InterruptedException {
		int m = 63; // 示例：63位二进制数
		int n = 4; // 示例：恰好有6个1

		List<Long> numbers = findNumbersWithNOnesLong(m, n);

//		Collections.shuffle(numbers); // 打乱顺序

		System.out.println("暗标可用随机字符种类为" + m + "个字符时，恰好有 " + n + " 个1的十进制数字集合，生成了: " + numbers.size() + "个，具体为：" + numbers);
		// 将结果写入本地文件
		String filename2 = "plus_"+ m +"_length_long" + n + ".txt";
//		writeNumbersToFileDouHaoLong(numbers, filename2);

		System.out.println("暗标可用随机字符种类为" + m + "个字符时，恰好有 " + n + " 个1的十进制数字集合，生成了: " + numbers.size() + "个" );
	}
}