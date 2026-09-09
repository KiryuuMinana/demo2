package avaitor.script;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AviatorDemo {
    public static void main(String[] args) throws IOException {
        // 定义 Aviator 脚本

//        String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\aaa.av";
        String scriptPath = "D:\\Glodon-work\\idea-workspace\\demo2\\src\\main\\java\\avaitor\\av\\ttt.av";

        // 编译 Aviator 脚本
        Expression expression = AviatorEvaluator.getInstance().compileScript(scriptPath,true);
        // 准备输入参数
        Map<String, Object> env = new HashMap<>();

        // 组装参数
        List<Map<String, Object>> yourPLList = new ArrayList<>();
        Boolean yourIsFilterValue = true;
        List<Map<String, Object>> yourEPnList = new ArrayList<>();
        BigDecimal yourMBPLValue = new BigDecimal("70000");

        // 定义数组内容
//        yourPLList.add(BidderIdPriceBO.builder().bidderId("00001").price(new BigDecimal(500)).build());
        Map<String,Object> plMap1 = new HashMap<>();
        plMap1.put("bidderId","001");
        plMap1.put("price",new BigDecimal(100000));
        yourPLList.add(plMap1);
        Map<String,Object> epnMap1 = new HashMap<>();
        epnMap1.put("bidderId","001");
        epnMap1.put("price",new BigDecimal(90000));
        yourEPnList.add(epnMap1);

        Map<String,Object> plMap2 = new HashMap<>();
        plMap2.put("bidderId","002");
        plMap2.put("price",new BigDecimal(50000));
        yourPLList.add(plMap2);
        Map<String,Object> epnMap2 = new HashMap<>();
        epnMap2.put("bidderId","002");
        epnMap2.put("price",new BigDecimal(50000));
        yourEPnList.add(epnMap2);

        Map<String,Object> plMap3 = new HashMap<>();
        plMap3.put("bidderId","003");
        plMap3.put("price",new BigDecimal(7000));
        yourPLList.add(plMap3);
        Map<String,Object> epnMap3 = new HashMap<>();
        epnMap3.put("bidderId","003");
        epnMap3.put("price",new BigDecimal(7000));
        yourEPnList.add(epnMap3);

        env.put("PL", yourPLList); // 替换为您的 PL 列表
        env.put("isFilter", yourIsFilterValue); // 替换为您的 isFilter 值
        env.put("EPn", yourEPnList); // 替换为您的 EPn 列表
        env.put("MBPL", yourMBPLValue); // 替换为您的 MBPL 值

        // 执行 Aviator 脚本
        Object result = expression.execute(env);

        // 处理脚本执行结果
        if (result != null) {
            if (result instanceof List) {
                List<Map<String, Object>> sepnList = (List<Map<String, Object>>) result;
                // 对 sepnList 进行后续处理 （打印）
                for (Map<String, Object> sepn : sepnList) {
                    System.out.println(sepn);
                }
            }
        }
    }
}
