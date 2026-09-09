/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package temp;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class ArrayTest {
	public static void main(String[] args) {
		Object[] arr = new Object[5];
		Object[] sub = new Object[2];
		sub[0] = 3;
		arr[0] = 1;
		arr[1] = sub;
		sub[1] = null;
		System.out.println(((Object[]) (arr[1]))[1]);
		List<EvalSealedBid> evalSealedBidList = new ArrayList<>();
		List<String> unencrypedIdList = evalSealedBidList.stream().map(EvalSealedBid::getUnencryptedId).collect(Collectors.toList());
		System.out.println(unencrypedIdList);
	}

	@Data
	class EvalSealedBid {
		private String sealedBidId;
		private String bidderId;
		private String unencryptedId;
		private String projectId;
		private String bidSectionId;
		private String evbidId;
		private String sealedCode;
		private String nodeId;
		private String clauseId;
		private String createId;
		private Date createTime;


	}
}