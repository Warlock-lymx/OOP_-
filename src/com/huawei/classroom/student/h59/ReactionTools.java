package com.huawei.classroom.student.h59;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class ReactionTools {

    /**
     * 根据reactionFile给出的一系列反应， 判断一个体系中根据init物质，判断出最后可能都存在什么物质
     *
     * @param reactionFile   体系中初始反应物
     * @param initComponents 体系中初始反应物
     * @return 最后体系中存在的全部物质
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

    public Set<String> findAllComponents(String reactionFile, Set<String> initComponents) {
        Set<String> result = new HashSet<>(initComponents);
        String content = readFromText(reactionFile);
        String[] lines = content.split("\r\n");
        List<Reaction> reactions = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("#")) continue;
            String[] reaction = line.split("=");
            String[] left = reaction[0].split(" \\+ ");
            Set<String> reactant = new HashSet<>();
            for (String s : left) {
                reactant.add(s.trim());
            }
            String[] right = reaction[1].split(" \\+ ");
            Set<String> resultant = new HashSet<>();
            for (String s : right) {
                resultant.add(s.trim());
            }
            reactions.add(new Reaction(reactant, resultant));
        }
        int flag =1;
        while (flag != 0) {
            flag = 0;
            for (Reaction reaction : reactions) {
                if (result.containsAll(reaction.reactant) && !result.containsAll(reaction.resultant)) {
                    result.addAll(reaction.resultant);
                    flag++;
                } else if (result.containsAll(reaction.resultant) && !result.containsAll(reaction.reactant)) {
                    result.addAll(reaction.reactant);
                    flag++;
                }
            }
        }
        return result;
    }
}

