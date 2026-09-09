/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 */
public class ListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.stream().collect(Collectors.toList());
	}
}