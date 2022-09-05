/**
 *
 */
package com.huawei.classroom.student.h56;

import java.io.*;

/**
 * @author Administrator
 *
 */
public class FileTool {

    /**
     * 将homeDir 目录下（包括子目录）所有的文本文件（扩展名为.txt，扩展名不是.txt的文件不要动，扩展名区分大小写) 文件中，orgStr替换为 targetStr
     * 所有文本文件均为UTF-8编码
     * 例如将某个目录中所有文本文件中的 南开大学 替换为 天津大学
     * @param homeDir
     * @param orgStr
     * @param targetStr
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

    public void replaceTxtFileContent(String homeDir, String orgStr, String targetStr) {
        File folder = new File(homeDir);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                replaceTxtFileContent(files[i].getAbsolutePath(), orgStr, targetStr);
            } else {
                if (files[i].getName().endsWith(".txt")) {
                    FileWriter fileWriter = null;
                    try {
                        String content = readFromText(files[i].getAbsolutePath());
                        content = content.replace(orgStr, targetStr);
                        fileWriter = new FileWriter(files[i].getAbsolutePath());
                        fileWriter.write(content);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

}
