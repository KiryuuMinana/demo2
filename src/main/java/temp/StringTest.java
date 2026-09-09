/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

/**
 *
 */
public class StringTest {
	public static void main(String[] args) {
		System.out.println("招标文件.pdf".endsWith("招标文件.pdf"));
		System.out.println("招标文件.pdf".endsWith("哈哈招标文件.pdf"));
		System.out.println("哈哈招标文件.pdf".endsWith("招标文件.pdf"));

		String str = "ABCD,4,";
		String[] split = str.split(",");
		System.out.println("-------------------------------------------");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println("-------------------------------------------");

		System.out.println(split.length);
//		System.out.println(split[2]);
//		System.out.println(split[3]);
		Boolean s = false;
		System.out.println(String.valueOf(s));

		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		String magicCode = "BidPriceScoreCoef2SumParam1";
		System.out.println(magicCode.charAt(magicCode.length() - 1));
		int c = magicCode.charAt(magicCode.length() - 1);
		System.out.println(c);
		System.out.println("-------------------------------------------");
		switch (c){
			case 49:
				System.out.println("勘察");
				break;
			case 50:
				System.out.println("设计");
				break;
			default:
				System.out.println("error");
		}

	}
}