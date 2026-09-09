/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

/**
 *
 */
public class IJZYHenka {
	public static void main(String[] args) {
		int j = 0;
		int iMax = 58905;
		int z = 0;
		int yMax = 24;
		int curExpertCodeLinkedListSize = 1413720+58904*2; // 示例值，实际使用时应根据实际情况赋值

		updateJAndZ(j, iMax, z, yMax, curExpertCodeLinkedListSize);

		System.out.println("Updated j: " + j);
		System.out.println("Updated z: " + z);
	}

	public static void updateJAndZ(int j, int iMax, int z, int yMax, int curExpertCodeLinkedListSize) {
		// 计算新的 j 值
		j += curExpertCodeLinkedListSize;

		// 检查 j 是否超过 iMax
		while (j >= iMax) {
			j -= iMax; // 回退到 [1, iMax] 范围内
			z++; // z 加 1

			// 检查 z 是否超过 yMax
			if (z == yMax) {
				z = 0; // 重置 z
			}
		}

		// 输出更新后的 j 和 z
		System.out.println("Updated j: " + j);
		System.out.println("Updated z: " + z);
	}

}