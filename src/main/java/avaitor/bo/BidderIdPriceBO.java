/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package avaitor.bo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-11-08 20:38:40
 */
@Data
@Builder
public class BidderIdPriceBO {
	String bidderId;
	BigDecimal price;
}