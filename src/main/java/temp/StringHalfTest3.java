/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class StringHalfTest3 {
	public static void main(String[] args) {
		int size = 2999;
		System.out.println(size % 1000 == 0 ? size / 1000 : size / 1000 + 1);

		int stepLength = (int) Math.ceil((double) 900 / 8);
		System.out.println(stepLength);

		Date date = new Date();
		int turn = 10; // 假设循环次数为10次

		for (int i = 1; i < turn; i++) {
			// 使用Calendar来增加一秒
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.SECOND, i);
			Date time = calendar.getTime();

			// 打印当前日期
			System.out.println("Iteration " + i + ": " + time);
		}
		System.out.println("查看变化");
		System.out.println(date);
	}
}