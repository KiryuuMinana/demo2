/**
 * Copyright (C) 2026, 雾生三柒.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test;

/**
 *
 */
public class StringTTTTTest {
	public static void main(String[] args) {
		// 上一步:1234
		// 这一步:5678
		String stepId = "1234|5678";
		String realCheckStepId = stepId.substring(stepId.indexOf("|") + 1); // 这一步
		stepId = stepId.substring(0 , stepId.indexOf("|")); // 上一步
		System.out.println(realCheckStepId);
		System.out.println(stepId);
	}

}