/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;


import com.google.common.math.LongMath;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class GenScript {
	/**
	 * 将结果写入本地文件。
	 *
	 * @param numbers 要写入的数字集合
	 * @param filename 文件名
	 */
	public static void writeNumbersToFileDouHao(List<Integer> numbers, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			for (int i = 0 ; i < numbers.size() - 1 ; i++) {
				Integer number = numbers.get(i);
				writer.write(number + ",");
			}
			writer.write(numbers.get(numbers.size() - 1) + "");
		} catch (IOException e) {
			System.err.println("写入文件时发生错误: " + e.getMessage());
		}
	}

	public static void writeNumbersToFileDouHaoLong(List<Long> numbers, String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			for (int i = 0 ; i < numbers.size() - 1 ; i++) {
				Long number = numbers.get(i);
				writer.write(number + ",");
			}
			writer.write(numbers.get(numbers.size() - 1) + "");
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
	public static List<Integer> findNumbersWithNOnesInt(int m, int n) {
		List<Integer> result = new ArrayList<>();
		// 最多生成x个
		int x = (int)(Math.min(2000000, LongMath.binomial(m, n)));
		// 从0到2^m-1遍历
//		for (int i = 0; i < (1L << m); i++) {
		for (int i = 0; i < (((1L << m) - 1)); i++) {
			if(i == Integer.MAX_VALUE){
				System.out.println("int最大了，下一个是：" + (i+1));
			}
			if (countOnes(i) == n) {
				result.add(i);
			}
			if(result.size() >= x){
				System.out.println("此时的i值：" + i);
				break;
			}
		}


		return result;
	}

	public static List<Long> findNumbersWithNOnesLong(int m, int n) {
		List<Long> result = new ArrayList<>();
		// 最多生成x个
		int x = (int)(Math.min(2000000, LongMath.binomial(m, n)));
		// 从0到2^m-1遍历
		for (long i = 0; i < (((1L << m) - 1)); i++) {

			if (countOnesLong(i ,n) == n) {
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

	private static int countOnesLong(long number, int n) {
		int count = 0;
		while (number > 0) {
			count += (int) (number & 1);
			number >>= 1;
			if(count > n){
				break;
			}
		}
		return count;
	}
	public static void main(String[] args) {
//		int m = 36; // 示例：36位二进制数 long 64
		int m = 63; // 示例：36位二进制数 long 64
		int n = 6; // 示例：恰好有4个1
//		List<Integer> numbers = findNumbersWithNOnesInt(m, n);
		List<Long> numbers = findNumbersWithNOnesLong(m, n);

		System.out.println("暗标可用随机字符种类为"+ m + "个字符时，恰好有 " + n + " 个1的十进制数字集合，生成了: "+ numbers.size() + "个，具体为：" + numbers);
		// 将结果写入本地文件
//		String filename2 = "长度为" + n +"，二进制长度为36以下时，58905个.txt";
//		String filename2 = "length" + n +".txt";
		String filename2 = "36_length_long" + n +".txt";
//		writeNumbersToFileDouHao(numbers, filename2);
		writeNumbersToFileDouHaoLong(numbers, filename2);
		System.out.println("暗标可用随机字符种类为"+ m + "个字符时，恰好有 " + n + " 个1的十进制数字集合，生成了: "+ numbers.size() + "个，具体为：" + numbers);
	}
	/**
	 * 数字+字母 36的情况
	 * 步骤数*评委数*评审因素数*投标单位数
	 * 10*10*20*3000=600w 极值
	 * 60w
	 *  n=4 ,理论最多可用58905个组合，*24=共1413720个  所以58905个数全量生成 大小581k
	 *  n=5 ,理论最多可用376992个组合，*120=共45239040个  所以理论生成83334个就够用  实际生成376992个 大小3.64M
	 *  ------------------------------------------------------
	 *  变种：n =5   376992 * 20
	 *  ------------------------------------------------------
	 *
	 *  n=6 ,理论最多可用1947792个组合，*720=共1402410240个  所以理论生成个就够用13889个就够用  大小17.5M
	 *  ------------------------------------------------------
	 *  n=6 开始变种 稳定20M文件持久化到数据库
	 *  ------------------------------------------------------
	 *  n=7 ，理论最多可用8347680个组合，
	 *
	 * 因此得出结论：不论如何生成，最多生成200万个组合就可以了，满足极值情况，绝对够用，到时候内存里一次性最多读22MB内容
	 */
}