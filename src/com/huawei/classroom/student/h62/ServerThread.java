package com.huawei.classroom.student.h62;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServerThread extends Thread{
    private int port;
    private String root;
    private Map<String, String> passwordData;

    public ServerThread(int port, String root, Map<String, String> passwordData){
        this.port = port;
        this.root = root;
        this.passwordData = passwordData;
    }

    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket client = serverSocket.accept();
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                String name = in.readUTF();
                String password = in.readUTF();
                if(!password.equals(passwordData.get(name))){
                    out.writeBoolean(false);
                    out.flush();
                    continue;
                }
                else{
                    out.writeBoolean(true);
                    out.flush();
                    ServerRemoteFileThread t = new ServerRemoteFileThread(client, new File(root + in.readUTF()));
                    t.setDaemon(true);
                    t.start();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
