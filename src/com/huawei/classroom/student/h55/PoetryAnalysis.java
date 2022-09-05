package com.huawei.classroom.student.h55;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class PoetryAnalysis {

    /**
     * @param pathFilename 包含诗歌内容的源文件
     * @param chars        需要统计的字 以半角分号分割
     *                     统计
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

    public void analysis(String pathFilename, String chars) {
        String[] keyword = chars.split(";");
        Map<String, Integer> res = new HashMap<>();
        Set<String> keyword_set = new HashSet();
        keyword_set.addAll(Arrays.asList(keyword));
        try {
            String[] sentences = readFromText(pathFilename).split("，|。");
            for (int i = 0; i < sentences.length; i++) {
                for (int j = 0; j < sentences[i].length() - 1; j++) {
                    String word = sentences[i].substring(j, j + 2);
                    if (keyword_set.contains(word.substring(0, 1)) || keyword_set.contains(word.substring(1, 2))) {
                        res.put(word, res.getOrDefault(word, 0) + 1);
                    }
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>();
            list.addAll(res.entrySet());
            Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            };
            Collections.sort(list, comparator);

            if(pathFilename.equals("D:\\homework\\src\\com\\huawei\\classroom\\student\\h55\\libai.txt"))
                System.out.println("李白：");
            else if (pathFilename.equals("D:\\homework\\src\\com\\huawei\\classroom\\student\\h55\\dufu.txt"))
                System.out.println("杜甫：");
            for (int i=0;i<10;i++) {
                System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
            }
            System.out.println("--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
