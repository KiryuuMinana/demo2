/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.math.BigDecimal;

/**
 *
 */
public class BigDecimalTest {
	public static void main(String[] args) {
		boolean equals = new BigDecimal("1").equals(new BigDecimal("1"));
		System.out.println(equals);
		equals = new BigDecimal("1.0").equals(new BigDecimal("1"));
		System.out.println(equals);

		equals = new BigDecimal("1").compareTo(new BigDecimal("1")) == 0;
		System.out.println(equals);

		equals = new BigDecimal("1.0").compareTo(new BigDecimal("1")) == 0;
		System.out.println(equals);

		BigDecimal bigDecimal = new BigDecimal("0.00");
		System.out.println(bigDecimal);

		System.out.println("===============================");

		String roundUp = String.valueOf(new BigDecimal(new BigDecimal("123456.000000").
				setScale(2, BigDecimal.ROUND_UP).stripTrailingZeros().toPlainString()));

		String roundHalfUp = new BigDecimal("123456.000000").setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();

		System.out.println(roundUp);
		System.out.println(roundHalfUp);

	}
}