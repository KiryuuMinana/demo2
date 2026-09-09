/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.util.HashMap;

/**
 *
 */
public class MapNullTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("1","1111");
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
		System.out.println(map.get(null));
	}
}