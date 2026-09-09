/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package com.example.demo2.test.other;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-09-25 20:10:04
 */
public class Test2 {
	public static void main(String[] args) {
		// 有9个投标单位没显示出来，有9个投标单位显示了两次
		String notXianShi[] = new String[]{
				"9727c13e54b14e629caa2cfcaf48fc46","c9ece19db6a0434aacb2368f10e39797","ceca9b3306cd4fd0afea5c1de48140c1","d51adb93c85d488ba5fe7a645824b93d","d992e11713894ed6a0a3bee55576fbf0",
				"dd6118c2d1a24f98905f48e86d589b8a","e502e7b4e717427e8061e2fabd05fb1b","ed1c662c3d344af9a2fc4c1965e96fdc","f0cb3eb1e85946e89109e66ee6bff78d"
		};

		String str[] = new String[]{
				"bbe1e73eacd74cad82f735e73bd90ba1","c26a0fd4cc4f494791cbc24a3bc8bb03","bfcedf1589744f898bf3909effcae531","bf60a54856f146c4bd2e3ef2de63efc1","be72eb8a9f50441b94963bd89da417e9","bd4085c05d39429f99a67ff2eab422f7","a1dc00c2fba746beb22c07e6bfca1b7a","9a6a5d0f76d84f8da6bbdef538ce4b8a","9c9e264f713346e19486a85bb5d21250","c5a09a6149534ea0aef71ccd47d7ca7a",
				"c5a09a6149534ea0aef71ccd47d7ca7a","bfcedf1589744f898bf3909effcae531","bf60a54856f146c4bd2e3ef2de63efc1","be72eb8a9f50441b94963bd89da417e9","bd4085c05d39429f99a67ff2eab422f7","bbe1e73eacd74cad82f735e73bd90ba1","a8a587bbf8d74012bdce3d9a859dc2b1","a1dc00c2fba746beb22c07e6bfca1b7a","9c9e264f713346e19486a85bb5d21250","9a6a5d0f76d84f8da6bbdef538ce4b8a",
				"f9466049d9624c4098b944bb129c8ff7","5053cff16a6c497fbab47202c9a9aa32","070d5d3694674adc9573d6b382726212","0d3f1ae0d847416f813228a09f584f9a","248c53b3adc7415e8b8a0faeb9e9fab2","2d346b74e5c44d3a9eda8135bcb8630a","2e4eb2df814141eab1edbc420904425a","35ef1f9a96e14653899d33c665d61bf2","36c37805229042d2a6f743352ad2d95c","376bc491c29a483abc47da4496367ff6",
				"3a1c28f73e37470b89949e787d4460d2","3c244e6f52624f60820d2181d88f2b06","01c0ca45bb9441219bcaf17c8fe004f7","6b3c2bf65d8e40638edd59883163cb93","6de4e70de6704728bfb9794b4f061ec8","72952aa07e3f47ca9d74000c0951ec7e","74a7988e427c404691a074a65b8485ab","76039aa602f549cb9059f21c9976efc5","7894274cdac84355a47c67da4aa2ba7c","7b09a6a86b41453db9ea495254f94bc2",
				"8fa88eb0ff6f4cf495b7cf3ad865d528","919afc377dfd48a59881554e16e2d70b"
		};
		System.out.println(str.length);
		List<String> list = List.of(str);
		System.out.println("list.size---->" + list.size());
		Set<String> set = new HashSet<>(list);
		System.out.println("set.size---->" + set.size());

		// 查找哪些重复
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0 ; i < list.size() ; i++) {
			String curStr = list.get(i);
			if (map.containsKey(curStr)){
				map.replace(curStr,map.get(curStr) + 1);
			}else{
				map.put(curStr,1);
			}
		}

		List<String> repeatList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1){
				repeatList.add(entry.getKey());
			}
		}
		System.out.println(repeatList.size());
		System.out.println("==================");
		for (String s : repeatList) {
			System.out.println("bidderId = " + s + "  count:" + map.get(s) + "次");
		}

		List<String> collect = list.stream().distinct().collect(Collectors.toList());
		System.out.println(collect.size());
	}
}