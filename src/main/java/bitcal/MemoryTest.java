/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package bitcal;

/**
 *
 */
public class MemoryTest {
	/**
	 * 估算int类型数组占用的内存空间（以字节为单位）。
	 *
	 * @param array 需要估算的int类型数组
	 * @return 数组占用的内存空间（字节）
	 */
	public static long estimateIntArrayMemoryUsage(int[] array) {
		// 对象头大小（通常为12字节，取决于JVM实现）
		long objectHeaderSize = 12;

		// 数组长度字段大小（通常为4字节，取决于JVM实现）
		long arrayLengthFieldSize = 4;

		// 数组元素的大小（每个int占4字节）
		long elementSize = array.length * 4;

		// 总内存大小
		long totalSize = objectHeaderSize + arrayLengthFieldSize + elementSize;

		return totalSize;
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		long memoryUsage = estimateIntArrayMemoryUsage(array);
		System.out.println("int类型数组 " + java.util.Arrays.toString(array) + " 占用的内存空间为: " + memoryUsage + " 字节,换算后为：" + (memoryUsage/1048576) +"MB");
	}
}