/**
 * Copyright (C) 2020-2023, Glodon Digital Supplier & Purchaser BU.
 * <p>
 * All Rights Reserved.
 */
package temp;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述
 *
 * @author 沈航冉
 * @date 2023-11-09 18:01:53
 */
public class MapTest {
	public static void main(String[] args) {
		String extJsonStr = "{\"复核结果\":{\"expertResult\":[{\"reason\":\"1\",\"expertName\":\"广联达性能测试专家1\",\"isPass\":1,\"userCode\":\"1d771ed4c1eb4587bf80c01bb607a44e\"},{\"reason\":\"\",\"expertName\":\"广联达性能测试专家2\",\"isPass\":1,\"userCode\":\"d2fcc55ac9c843cfb3e80a5e8e921452\"},{\"reason\":\"\",\"expertName\":\"广联达性能测试专家3\",\"isPass\":1,\"userCode\":\"f559911017f148979d83a84ac483020a\"},{\"reason\":\"\",\"expertName\":\"广联达性能测试专家4\",\"isPass\":1,\"userCode\":\"3b3d51218e7b4d49ad37862d241cffc0\"},{\"reason\":\"\",\"expertName\":\"广联达性能测试专家5\",\"isPass\":1,\"userCode\":\"fced737a9b2c4c3e8bb50fae6cc55fa1\"}],\"hzPass\":\"1\"},\"zzCommit\":1}";
		JSONObject extJson = JSONObject.parseObject(extJsonStr);
		extJson.put("zzCommit", 0);
		System.out.println(extJson);
	}
}