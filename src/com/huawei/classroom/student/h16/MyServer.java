package com.huawei.classroom.student.h16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread{
    int port;

    public void startListen(int port) {
        this.port = port;
        this.start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);){
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String info = "";
            while ((info = bufferedReader.readLine()) != null) {
                if(info.equals("bye\r\n")){
                    socket.close();
                    bufferedReader.close();
                    bufferedWriter.close();
                    break;
                }
                bufferedWriter.write(info);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
