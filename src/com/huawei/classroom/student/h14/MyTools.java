package com.huawei.classroom.student.h14;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在本包下增加合适的类和方法， 本程序不但要测试通过，还需要写适当的注释
 * <p>
 * 不要引用jdk1.8以外第三方的包
 *
 * @author cjy
 */
public class MyTools {

    /**
     * @param studentListFile 存放学生名单的文件名
     * @param picDir          图片存放的目录（不会包含子目录）
     */
    public MyTools() {
        // TODO Auto-generated constructor stub
    }

    //读取文件内容
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

    public Set<String> copyToTargetDirAndReturnNoExist(String studentListFile, String srcDir, String target) throws Exception {
        String[] stuInfo = readFromText(studentListFile).split("[\n\t]");//把所有信息拆分
        Map<String, String> stuName = new HashMap<String, String>();//存储所有学号对应姓名
        Map<String, String> stuClass = new HashMap<String, String>();//存储所有学号对应班级
        Set<String> handedNum = new HashSet<>();//已经正确提交的学生学号

        for (int i = 0; i < stuInfo.length; i += 3) {
            stuName.put(stuInfo[i], stuInfo[i + 1]);
            stuClass.put(stuInfo[i], stuInfo[i + 2].replace("\r", ""));
        }
        File dir = new File(srcDir);
        String[] filename = dir.list();
        for (int i = 0; i < filename.length; i++) {
            //学生上传的文件格式错误
            if (!(filename[i].substring(filename[i].length() - 4, filename[i].length()).equals(".jpg")))
                continue;
                //学生上传的文件格式正确
            else {
                String stuNum = filename[i].replace(".jpg", "");
                if (stuName.containsKey(stuNum)) {//上传了的文件以正确学号命名
                    handedNum.add(stuNum);
                    File classFile = new File(target, stuClass.get(stuNum));
                    if (!classFile.exists()) {
                        classFile.mkdirs();//创建班级目录
                    }
                    File destFile = new File(classFile, stuNum + "_" + stuName.get(stuNum) + ".jpg");
                    if (!destFile.exists()) {
                        destFile.createNewFile();//创建目标文件
                    }
                    try {
                        FileInputStream fileInputStream = new FileInputStream(srcDir + "\\" + stuNum + ".jpg");
                        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                        byte[] content = new byte[1000];
                        int readed = 0;
                        //把已上传正确文件拷贝到目标文件
                        while ((readed = fileInputStream.read(content)) != -1) {
                            fileOutputStream.write(content, 0, readed);
                        }
                        //释放资源
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else continue;
            }
        }
        //判断哪些学生没有提交或提交错误
        Set<String> allNum = stuName.keySet();
        Set<String> unhandedNum = new HashSet<>();
        for (String num : allNum) {
            if (handedNum.contains(num)) {
                continue;
            } else {
                unhandedNum.add(num);
            }
        }
        return unhandedNum;
    }
}
