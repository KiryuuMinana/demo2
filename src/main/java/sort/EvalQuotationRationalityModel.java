/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package sort;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-09-21 10:33:31
 */

public class EvalQuotationRationalityModel {
	// 固定列
	private Integer indexNo;
	private String bidderName;
	// 动态列
	private String colName;
	private String totalScore;

	// 不返回报表的列，用于排序前业务处理
	private String bidderId;


	public Integer getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getBidderId() {
		return bidderId;
	}

	public void setBidderId(String bidderId) {
		this.bidderId = bidderId;
	}
}