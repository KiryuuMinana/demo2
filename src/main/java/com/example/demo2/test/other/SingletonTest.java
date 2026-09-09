/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SingletonTest {
	public static void main(String[] args) {
		String userIds = "111、222,333";
		List<String> strings = Collections.singletonList(userIds);
		System.out.println(strings);

	}
}