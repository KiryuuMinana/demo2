/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.util.*;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-06-16 09:27:42
 */
public class Test {
	public static void main(String[] args) {
		String sameBidderInfo = "id1,id2,id3@*!投标人1,投标人2,投标人3";
		System.out.println(sameBidderInfo.substring(0,sameBidderInfo.indexOf("@*!")));
		System.out.println(sameBidderInfo.substring(sameBidderInfo.indexOf("@*!")+3));
		System.out.println((UUID.randomUUID().toString().toLowerCase().replace("-", "")));
		System.out.println((UUID.randomUUID().toString().toLowerCase().replace("-", "")));


		Map<String,String> map = new HashMap<>();
//		map.put("111","222");
		System.out.println(map.get("2333"));
	}
//	public static void main(String[] args) {
//		List<HardwareNameValueBO> nameList1 = new ArrayList<>();
//		nameList1.add(HardwareNameValueBO.builder()
//				.name("IP地址")
//				.value("10.0.108.8")
//				.build());
//		nameList1.add(HardwareNameValueBO.builder()
//				.name("MAC地址")
//				.value("124564215484412423")
//				.build());
//		List<HardwareNameValueBO> nameList2 = new ArrayList<>();
//		nameList2.add(HardwareNameValueBO.builder()
//				.name("IP地址")
//				.value("10.0.108.8")
//				.build());
//		nameList2.add(HardwareNameValueBO.builder()
//				.name("MAC地址")
//				.value("124564215484412423")
//				.build());
//		System.out.println(nameList1.hashCode());
//		System.out.println(nameList2.hashCode());
//		System.out.println(nameList1.hashCode() == nameList2.hashCode());
//		Set<Integer> set = new HashSet<>();
//		if(set.contains(nameList1.hashCode())){
//			System.out.println("nameList1 hash is repeat");
//		}else{
//			set.add(nameList1.hashCode());
//		}
//		if(set.contains(nameList2.hashCode())){
//			System.out.println("nameList2 hash is repeat");
//		}else{
//			set.add(nameList2.hashCode());
//		}
//		System.out.println(set.size());
//	}
}