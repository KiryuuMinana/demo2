/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import com.alibaba.fastjson.JSONObject;

/**
 *
 */
public class JsonTest {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("aaa",1);
		System.out.println(jsonObject.get("aaa")+"");
		System.out.println(jsonObject.get("bbb"));
	}
}