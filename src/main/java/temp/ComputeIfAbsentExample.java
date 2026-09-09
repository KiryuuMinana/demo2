/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class ComputeIfAbsentExample {
	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap<String, long[]> map = new ConcurrentHashMap<>();
		String key = "someKey";
		String key2 = "someKey2";

		// 第一个线程，执行计算并插入值
		new Thread(() -> {
			map.computeIfAbsent(key, k -> {
				try {
					System.out.println("Thread " + Thread.currentThread().getName() + " is inserting value...");
					Thread.sleep(3000);  // 模拟10秒钟的计算
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return new long[]{1, 2, 3};  // 计算的值
			});
		}).start();

		// 等待第一线程的计算完成
//		Thread.sleep(1000);  // 模拟主线程等待

		// 第二个线程，发现值已存在，直接获取
		new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName() + " is accessing value: "
					+ Arrays.toString(map.computeIfAbsent(key2, k -> new long[]{4, 5, 6})));  // 此时直接获取已有的值
		}).start();

		// 第三个线程，发现值已存在，直接获取
		new Thread(() -> {
			System.out.println("Thread " + Thread.currentThread().getName() + " is accessing value: "
					+ Arrays.toString(map.computeIfAbsent(key, k -> new long[]{7, 8, 9})));  // 此时直接获取已有的值
		}).start();

		Thread.sleep(5000);
		for (Map.Entry<String, long[]> stringEntry : map.entrySet()) {
			System.out.println("key->" + stringEntry.getKey() + ",value->" + Arrays.toString(stringEntry.getValue()));
		}
	}
}