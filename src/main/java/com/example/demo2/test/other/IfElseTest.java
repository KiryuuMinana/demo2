/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

/**
 *
 */
public class IfElseTest {
	public static void main(String[] args) {
		boolean a = true;
		boolean c = true;
		boolean b = false;

		if(b){
			System.out.println("进来了1");
		}else if (a || b){
			System.out.println("进来了2");
		}else if (a || c){
			System.out.println("进来了3");
		}else{
			System.out.println("进来了4");
		}
	}
}