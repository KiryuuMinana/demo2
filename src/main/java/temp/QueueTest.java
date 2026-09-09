/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.LinkedList;

/**
 *
 */
public class QueueTest {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("Element 1");
		list.add("Element 2");
		list.add("Element 3");
		int n = 3; // 第 N 个元素的索引从 1 开始

		// 弹出第 1 个元素
		String removedElement = list.pollFirst();
		System.out.println("弹出的第 " + 1 + " 个元素: " + removedElement);
		System.out.println("剩余的列表: " + list);

		// 拿出第 N 个元素
		String getElement = list.get(n - 1);
		System.out.println("拿出的第 " + n + " 个元素: " + getElement);
		System.out.println("剩余的列表: " + list);
	}
}