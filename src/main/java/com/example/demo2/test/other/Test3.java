/**
 * Copyright (C) 2025, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

/**
 *
 */
public class Test3 {
	public static void main(String[] args) {
		String paramValue = "0.7,0.6,0.5,0.4";
		StringBuilder result = new StringBuilder();
		int i = 1;
		for (String sp : paramValue.split(",")) {
			result.append(i++);
			result.append("【K2：");
			float k3 = Float.parseFloat(sp);
			float k2 = 1 - k3;
			result.append(String.format("%.1f", k2));
			result.append("&K3：");
			result.append(sp);
			result.append("】,");
		}
		String substring = result.substring(0, result.length() - 1);
		System.out.println(substring);
	}

}