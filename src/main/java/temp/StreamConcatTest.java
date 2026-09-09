/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package temp;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-12-08 17:20:14
 */
public class StreamConcatTest {
	public static void main(String[] args) {
//		List<Integer> list1 = Arrays.asList(1, 2, 3);
//		List<Integer> list2 = Arrays.asList(4, 5, 6);
//
//		List<Integer> combinedList = Stream.concat(list1.stream(), list2.stream())
//				.collect(Collectors.toList());
//
		List<Map<String,Object>> list1 = new ArrayList<>();
		List<Map<String,Object>> list2 = new ArrayList<>();

		Map<String, Object> map1 = new HashMap<>();
		map1.put("id", "001");
		map1.put("billId", "billid001");
		map1.put("price", new BigDecimal(2850));
		list1.add(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("id", "001");
		map2.put("billId", "noBillId001");
		map2.put("price", null);
		list1.add(map2);

		List<Map<String,Object>> combinedList = Stream.concat(list1.stream(), list2.stream())
				.collect(Collectors.toList());

		combinedList.forEach(map->{
			map.entrySet().forEach(entry ->{
				String key = entry.getKey();
				Object value = entry.getValue();
				System.out.println(key + ":" + value);
			});
		});
	}
}