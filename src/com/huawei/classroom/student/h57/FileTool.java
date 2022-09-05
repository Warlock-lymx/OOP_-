package com.huawei.classroom.student.h57;

import java.io.*;

public class FileTool {

    /*
     * 统计一个目录下所有文件大小的加和
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

    public long recursiveCalcFileSize(String homeDir) {
        File folder = new File(homeDir);
        File[] files = folder.listFiles();
		long length = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                length += recursiveCalcFileSize(files[i].getAbsolutePath());
            } else {
                length += files[i].length();
            }
        }
        return length;
    }
}
