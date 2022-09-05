package com.huawei.classroom.student.h58;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.*;

public class VoteRecord {
    /**
     * fileName是一个投票的明细记录，里面逐行存放了 投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
     * 存放按时间递增（但是可能出现同一秒出现若干条记录的情况）
     * 现在需要完成投票统计的过程，具体要求如下：
     * 1个微信ID 1分钟内 最多投1票 多余的票数无效
     * 1个微信ID 10分钟内 最多只能投5票 多余的票无效
     * 其中微信ID不固定，候选人姓名不固定
     * 测试的时候要求10万行记录处理时间不超过3秒
     *
     * @param fileName
     * @return 返回一个map，其中key是候选人名字，value的票数
     */
    public String readFromText(String filename) {
        Reader reader = null;
        StringBuffer buf = new StringBuffer();//要返回的buffer
        char[] content = new char[1000];//用于接收读取的数据
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            reader = new InputStreamReader(fileInputStream, "UTF-8");//编码格式为UTF-8
            int readed = 0;//每次读取的长度
            while ((readed = reader.read(content)) != -1) {
                buf.append(content, 0, readed);//每次读取的内容加入字符串
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buf.toString();
    }

    public Map<String, Integer> calcRecording(String fileName) {
        Map<String, Integer> result = new HashMap<>();
        Map<String, List<Date>> vote = new HashMap<>();
        String content = readFromText(fileName);
        String[] lines = content.split("\r\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            for (int i = 0; i < lines.length; i++) {
                String[] info = lines[i].split("\t");
                if (!vote.containsKey(info[1])) {
                    List<Date> date = new ArrayList();
                    date.add(sdf.parse(info[0]));
                    vote.put(info[1], date);
                    result.put(info[2], result.getOrDefault(info[2], 0) + 1);
                } else {
                    List<Date> tmp = vote.get(info[1]);
                    if (sdf.parse(info[0]).getTime() - tmp.get(tmp.size() - 1).getTime() >= 60000) {
                        if (sdf.parse(info[0]).getTime() - tmp.get(0).getTime() >= 600000) {
                            vote.get(info[1]).remove(0);
                            vote.get(info[1]).add(sdf.parse(info[0]));
                            result.put(info[2], result.getOrDefault(info[2], 0) + 1);
                        }
                        else if (tmp.size() < 5) {
                            vote.get(info[1]).add(sdf.parse(info[0]));
                            result.put(info[2], result.getOrDefault(info[2], 0) + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
