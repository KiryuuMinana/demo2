/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Temp1 {
	public static void main(String[] args) {
		List<String> params = new ArrayList<>();
		params.add("太原1");
		String value = "太原";
		System.out.printf(String.valueOf(params.contains(value)));
	}
}