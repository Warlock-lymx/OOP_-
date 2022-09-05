
package com.huawei.classroom.student.h13;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过
 * <p>
 * 不要引用jdk1.8以外第三方的包
 *
 * @author cjy
 */
public class Analysis {
    private String[] chapters = null;

    /**
     * @throws Exception
     */
    public Analysis(String filename) throws Exception {//构造函数
        String content = readFromTxt(filename);
        chapters = splitContentToChapter(content);  //chapters里存储每个章节的内容
    }

    /**
     * 提示 ：将一个文本文件读取到一个字符串中返回
     *
     * @param filename 红楼梦文本文件的全路径名
     * @return 文本的内容
     */
    private String readFromTxt(String filename) throws Exception {
        Reader reader = null;
        try {
            StringBuffer buf = new StringBuffer();
            char[] chars = new char[1024];
            // InputStream in=new FileInputStream(filename);

            reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
            int readed = reader.read(chars);
            while (readed != -1) {
                buf.append(chars, 0, readed);
                readed = reader.read(chars);
            }
            return buf.toString();
        } finally {
            close(reader);
        }
    }

    /**
     * 返回红楼梦中出现频率最高的N个次，频率从高到低排列（所谓词就是两个相邻的汉字）
     *
     * @param n
     * @return
     */
    public List<String> getTopNWords(int n) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 1; i < chapters.length; i++) {
            //避免标点符号、空格等对结果造成影响
            chapters[i] = chapters[i].replaceAll(" ", "");
            chapters[i] = chapters[i].replaceAll("\\p{P}", "");
            chapters[i] = chapters[i].replaceAll("\n", "");
        }
        for (int i = 1; i < chapters.length; i++) {
            //把每个章节的每个词都存入map
            String str = chapters[i];
            for (int j = 0; j < str.length() - 1; j++) {
                String word = str.substring(j, j + 2);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        //按照value值对map中的每个词排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
        list.addAll(map.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Collections.sort(list, comparator);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    /**
     * 关闭输入输入流
     *
     * @param inout
     */
    private void close(Closeable inout) {
        if (inout != null) {
            try {
                inout.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 提示 将红楼梦文本文件拆分为120个章节的方法
     *
     * @param content
     * @return 返回120个元素的字符串数组
     */
    private String[] splitContentToChapter(String content) {
        // 提示 使用 content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");正则表达拆分
        // 百度一下正则表达式
        String[] contents = content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");
        return contents;
    }


    /**
     * 统计红楼梦章节字符串str出现的频率
     *
     * @param str
     * @return
     * @throws Exception
     */
    public int[] getStringFrequent(String str) throws Exception {
        int[] res = new int[chapters.length - 1];
        for (int i = 0; i < chapters.length - 1; i++) {
            String content = chapters[i + 1];
            int count = 0;
            //把每章节每个和str相同长度的词与str进行比较
            for (int j = 0; j < content.length() - str.length()+1; j++) {
                String tmp = content.substring(j, j + str.length());
                if (tmp.equals(str)) count++;
            }
            res[i] = count;
        }
        return res;
    }

}
