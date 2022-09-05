package com.huawei.classroom.student.h83.q05;

import java.io.*;
import java.util.*;

//TODO Auto-generated constructor stub //{9a171f3bf58f0f9c713f4e6700528b6c}
public class MyApplicationUtil {


    /**
     * 按成绩优先的原则 对学生进行录取
     *
     * @param scoreFile       存放所有学生成绩的文件，具体格式见scores.txt文件
     * @param applicationFile 存放所有学生志愿的文件，具体格式见applications.txt文件
     * @param enrollment      每个大学最大招生人数
     * @return 以学生ID-录取的大学名称方式 返回所有学生录取情况，如果某个学生没有考上任何大学则对应的大学名字为 null
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

    public Map<String, String> getApplicationResult(String scoreFile, String applicationFile, int enrollment) {
        //
        // TODO Auto-generated constructor stub //{9c28aff8a140d40f8702c6e60d483ada}
        Map<String, String> result = new HashMap();
        String score_content = readFromText(scoreFile);
        String app_content = readFromText(applicationFile);
        Map<String, Integer> id_score = new HashMap<>();
        Map<String, List<String>> id_app = new HashMap<>();
        String[] score_lines = score_content.split("\r\n");
        for (int i = 0; i < score_lines.length; i++) {
            if (score_lines[i].startsWith("#") || score_lines[i] == null) continue;
            String[] tmp = score_lines[i].split("\\s");
            id_score.put(tmp[0], Integer.valueOf(tmp[1]));
        }
        String[] app_lines = app_content.split("\r\n");
        for (int i = 0; i < app_lines.length; i++) {
            if (app_lines[i].startsWith("#") || app_lines[i] == null) continue;
            String[] tmp = app_lines[i].split("\t");
            if (!(id_app.containsKey(tmp[0]))) {
                List<String> app = new ArrayList<>();
                app.add(tmp[1]);
                id_app.put(tmp[0], app);
            } else {
                id_app.get(tmp[0]).add(tmp[1]);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(id_score.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Map<String, Integer> num = new HashMap<>();
        num.put("u1", 2);
        num.put("u2", 2);
        num.put("u3", 2);
        num.put("u4", 2);
        Collections.sort(list, comparator);
        for (Map.Entry<String, Integer> stu : list) {
            List<String> app = id_app.get(stu.getKey());
            for (String school : app) {
                if (num.get(school) > 0) {
                    result.put(stu.getKey(), school);
                    num.put(school, num.get(school) - 1);
                    break;
                }
            }
        }
        Set<String> students = id_score.keySet();
        for (String stu : students) {
            if (!(result.containsKey(stu))) result.put(stu, null);
        }
        return result;
    }

    //
}
//TODO Auto-generated constructor stub //{9f7dda476a4f9952cca6e2057a1abd2f}