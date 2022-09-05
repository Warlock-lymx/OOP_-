package com.huawei.classroom.student.h11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Home11 {

    public Home11() {
        // TODO Auto-generated constructor stub
    }


    /**
     * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
     * 请找出   哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
     * 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
     *
     * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
     * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
     */
    public String getFrequentItem(String content) {
        Map<String, Integer> map = new HashMap<>();
        String[] shopping = content.split(";"); //用;把每次购物的商品分开放在一个数组里
        for (String s : shopping) {
            String[] goods = s.split(",");  //用,把每次购物的商品中的每个商品分开放在一个数组里
            for (int j = 0; j < goods.length - 1; j++) {
                for (int k = j + 1; k < goods.length; k++) {
                    //取出一次购物中的两个商品
                    String comb1 = goods[j] + "," + goods[k];
                    String comb2 = goods[k] + "," + goods[j];
                    map.put(comb1, map.getOrDefault(comb1, 0) + 1);
                    map.put(comb2, map.getOrDefault(comb2, 0) + 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> entryset = map.entrySet();
        int max = 0;
        String res = "";
        //找出最大值
        for (Map.Entry entry : entryset) {
            if ((int) entry.getValue() > max) {
                max = (int) entry.getValue();
                res = (String) entry.getKey();
            }
        }
        return res;
    }


}
