package com.huawei.classroom.student.h51;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class HongBao {

    /**
     * @param total       红包总金额，以元为单位，精确到分，系统测试的时候保证总金额至少够每人分得1分钱
     * @param personCount 分红包的总人数>0
     * @return 每个人分得的钱数
     * 规则遵循微信分红包规则 例如：
     * 要求 每人分得的钱数总和=total
     * 每个人分得钱数必须是正数，且不能少于1分
     */
    public double[] getHongbao(double total, int personCount) {
        double money = total - personCount * 0.01;
        double[] result = new double[personCount];
        Arrays.fill(result, 0.01);
        for (int i = 0; i < personCount; i++) {
            if (i == personCount - 1) {
                result[i] += money;
            } else {
                double rand = Math.random() * money;
                BigDecimal bd = new BigDecimal(rand);
                double rand_2 = bd.setScale(2, RoundingMode.DOWN).doubleValue();
                result[i] += rand_2;
                money -= rand_2;
            }
        }
        return result;
    }
}
