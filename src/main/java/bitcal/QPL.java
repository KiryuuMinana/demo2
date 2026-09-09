/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成全排列
 */
public class QPL {
	public static void main(String[] args) {
//		int n = 6;
//		List<Integer> result = new ArrayList<>();
//		List<String> permutations = generatePermutations(n);
//		int count = 0;
//		for (String permutation : permutations) {
//			System.out.print(permutation + ",");
//			result.add(Integer.valueOf(permutation));
//			count++;
//			if(count > 5040) break;
//		}
//		System.out.println();
//		System.out.println("共有" + count + "个");
//		String filename = "QPL" + n +".txt";
//		GenScript.writeNumbersToFileDouHao(result,filename);
	}

	public static List<String> generatePermutations(int n) {
		List<String> result = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		boolean[] used = new boolean[n + 1];
		generatePermutationsHelper(n, current, used, result);
		return result;
	}

	private static void generatePermutationsHelper(int n, StringBuilder current, boolean[] used, List<String> result) {
		if (current.length() == n) {
			result.add(current.toString());
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!used[i]) {
				used[i] = true;
				current.append(i);
				generatePermutationsHelper(n, current, used, result);
				current.deleteCharAt(current.length() - 1);
				used[i] = false;
			}
		}
	}
}