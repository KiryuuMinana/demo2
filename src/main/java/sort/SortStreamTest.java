/**
 * Copyright (C) 2020-2024, Glodon 公共资源交易产线.
 * <p>
 * All Rights Reserved.
 */
package sort;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class SortStreamTest {
	public static void main(String[] args) {
		List<EvalPdf> list = new ArrayList<>();
		list.add(EvalPdf.builder()
				.fileName("111")
				.fileType(1).
				build());
		list.add(EvalPdf.builder()
				.fileName("222")
				.fileType(17).
				build());
		list.add(EvalPdf.builder()
				.fileName("333")
				.fileType(3).
				build());
		list.add(EvalPdf.builder()
				.fileName("444")
				.fileType(4).
				build());
		list.add(EvalPdf.builder()
				.fileName("555")
				.fileType(17).
				build());
		list.add(EvalPdf.builder()
				.fileName("666")
				.fileType(16).
				build());
		list.add(EvalPdf.builder()
				.fileName("777")
				.fileType(14).
				build());
		List<Integer> customOrder = Arrays.asList(1, 3, 17, 14, 16);
		list = list.stream().filter(e -> customOrder.contains(e.getFileType()))
				.sorted(Comparator.comparingInt(e -> customOrder.indexOf(e.getFileType())))
				.collect(Collectors.toList());
		for (EvalPdf file : list) {
			System.out.println(file);
		}
	}

	@Builder
	@Getter
	static class EvalPdf {
		@Override
		public String toString() {
			return "FileElement{" +
					"filetype=" + fileType +
					", filename='" + fileName + '\'' +
					'}';
		}

		/**
		 * PDF文件ID
		 */
		private String pdfId;

		/**
		 * 项目ID
		 */
		private String projectId;

		/**
		 * 标段ID
		 */
		private String bidSectionId;

		/**
		 * 投标单位ID
		 */
		private String bidderId;

		/**
		 * 开标/评标阶段 阶段状态：0： 无阶段（标段阶段数量为1时使用，其他为阶段数量大于1是使用），1：第一阶段，2：第二阶段
		 */
		private Integer stage;

		/**
		 * 文件类型：1-招标文件，2-补遗文件，3-图纸文件，4-商务标文件，5-技术标文件，6-资信标文件，7-经济标文件，8-资格申请文件，9-资格预审文件，10-投标函文件，11-设计标文件，99-其他文件
		 */
		private Integer fileType;

		/**
		 * 文件类型字符串： 包括中文
		 */
		private String fileTypeStr;

		/**
		 * 文件类型名称
		 */
		private String typeName;

		/**
		 * 对应文件系统的文件ID
		 */
		private String fileId;

		/**
		 * 显示顺序
		 */
		private Integer displayOrder;

		/**
		 * 带后缀的文件名
		 */
		private String fileName;

		/**
		 * 是否暗标，0-否，1-是
		 */
		private Integer isSealed;

		/**
		 * 操作时间
		 */
		private Date operTime;

		/**
		 * 备注
		 */
		private String remark;

		/**
		 * 日期，仅用于分库分表，格式：2019-01-01
		 */
		private Date createTime;


	}

}