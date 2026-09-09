/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import cn.hutool.core.date.StopWatch;

import java.security.SecureRandom;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 *
 */
public class ZhuanLiDuiBiTest1 {
	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("Task 1:全部时间");
		int threadCount = 10;
		int codesPerThread = 200001;
		int targetCount = 2000000;
		SecureRandom random = new SecureRandom();
		char[] charset = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".toCharArray(); // 自定义字符集
		int length = 8; // 编码长度
		Set<String> codes = ConcurrentHashMap.newKeySet(); // 用于存储唯一编码

		IntStream.range(0, threadCount).parallel().forEach(thread -> {
			for (int i = 0; i < codesPerThread; i++) {
				StringBuilder code = new StringBuilder(length);
				for (int j = 0; j < length; j++) {
					code.append(charset[random.nextInt(charset.length)]);
				}
				codes.add(code.toString());
			}
		});

		if (codes.size() < targetCount) {
			throw new RuntimeException("生成数量不足，请调整参数！");
		}

//		System.out.println(codes);
		System.out.println("codes.size = " + codes.size());
		stopWatch.stop();
		System.out.println("任务 'Task 1全部时间' 执行时间: " + stopWatch.getTotalTimeMillis() + " ms");
	}
}