package com.huawei.classroom.student.h62;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MyDaemon {
    private String root;
    private int port;
    private Map<String, String> passwordData = new HashMap<>();

    public MyDaemon(MyDeamonConfigVo config){
        this.port = config.getPort();
        this.root = config.getRoot();
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(config.getPasswordFile())))
        ){
            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("#"))
                    continue;
                String[] datas = line.split("\t");
                passwordData.put(datas[0],datas[1]);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        ServerThread t = new ServerThread(port,root,passwordData);
        t.setDaemon(true);
        t.start();
    }
}
