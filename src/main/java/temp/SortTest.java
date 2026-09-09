/**
 * Copyright (C) 2020-2025, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class SortTest {
	public static void main(String[] args) {
		int[] arr = new int[]{127,191,319,223,351,415,239,367,431,463,247,375,439,471,487,251,379,443,475,491,499,253,381,445,477,493,501,505,254,382,446,478,494,502,506,508};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		System.out.println(list);
	}
}