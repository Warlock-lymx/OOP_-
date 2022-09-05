package com.huawei.classroom.student.h12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Home12 {
    public Home12() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
     * 请找出   哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回
     *
     * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
     * @param n
     * @return 哪n个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回
     * 不会出现并列的情况
     */

    //实现一个字符串数组中n个字符串的全排列
    public void combination(Map<String, Integer> map, String comb, String[] goods, int n, int cur) {
        if (cur >= goods.length) return;
        //记录还未添加新物品之前的状态
        String flag = comb;
        //添加新字符串
        if (comb.equals(""))
            comb += goods[cur];
        else
            comb = comb + "," + goods[cur];
        //已添加物品个数
        int count = comb.split(",").length;

        if (count < n) {
            combination(map, comb, goods, n, cur + 1);  //不到指定物品个数，继续添加
            combination(map, flag, goods, n, cur + 1);  //跳过当前物品添加下一个
        } else if (count == n) {
            map.put(comb, map.getOrDefault(comb, 0) + 1);   //已经达到指定物品个数，把这组放入map
            combination(map, flag, goods, n, cur + 1);  //跳过当前物品添加下一个
        } else
            return;
    }

    public Set<String> getFrequentItem(String content, int n) {
        Map<String, Integer> map = new HashMap<>();
        String[] shopping = content.split(";");

        for (int i = 0; i < shopping.length; i++) {
            String[] goods = shopping[i].split(",");
            String comb = "";
            //调用全排列方法
            combination(map, comb, goods, n, 0);
        }

        Set<String> resSet = new HashSet<>();
        Set<String> keys = map.keySet();
        int max = 0;
        String res = "";
        for (String comb : keys) {
            //得到同时购买次数最多的n个商品
            if (map.get(comb) > max) {
                max = map.get(comb);
                res = comb;
            }
        }
        String[] tmp = res.split(",");
        for (String str : tmp) {
            resSet.add(str);
        }
        return resSet;
    }


}
