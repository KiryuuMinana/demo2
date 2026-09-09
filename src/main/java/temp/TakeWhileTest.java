/**
 * Copyright (C) 2020-2025, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.List;

/**
 *
 */
public class TakeWhileTest {
	public static void main(String[] args) {
//		List<Integer> numbers = List.of(10,9,8,7,6,5,4,3,2,1);
		List<Integer> numbers = List.of(3,10,2,7,6,5,4,9,8,1);
//		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

		numbers.stream()
				.takeWhile(n -> n < 5)
				.forEach(System.out::println);
	}
}