/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 */
public class QPL3 {
	public static void main(String[] args) {
		int n = 12;
		int maxPermutations = 5040;
		String filename = "QPL" + n + ".txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = i + 1;
			}

			int count = 0;
			while (count < maxPermutations) {
				String permutationStr = Arrays.stream(nums)
						.mapToObj((num -> String.valueOf(intToChar(num))))
						.collect(Collectors.joining());
				writer.print(permutationStr + ",");
				System.out.print(permutationStr + ",");
				count++;
				if (count % 100 == 0) {
					writer.flush();
					System.out.println();
				}
				if (!nextPermutation(nums)) {
					break;
				}
			}
			System.out.println();
			System.out.println("共有 " + count + " 个排列");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i < 0) {
			return false;
		}

		int j = nums.length - 1;
		while (j >= 0 && nums[j] <= nums[i]) {
			j--;
		}
		swap(nums, i, j);

		reverse(nums, i + 1, nums.length - 1);
		return true;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static char intToChar(int num) {
		return (char) ('a' + num - 1);
	}
}