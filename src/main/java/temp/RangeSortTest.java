/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class RangeSortTest {
	public static void main(String[] args) {
		List<Integer> collect = IntStream.range(0, 10)
				.boxed()
				.collect(Collectors.toList());
		System.out.println(collect);
	}
}