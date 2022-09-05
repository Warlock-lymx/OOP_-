package com.huawei.classroom.student.h60;


import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ServerThread extends Thread {
    private final Socket socket;
    private final Map<String, String> passwd;

    public ServerThread(Socket socket, Map<String, String> passwd) {
        this.socket = socket;
        this.passwd = passwd;
    }

    private String pass(String passwdStr) {
        String[] userPasswd = passwdStr.split("\t");
        if (userPasswd.length != 2) {
            return "0";
        }
        String username = userPasswd[0];
        String password = userPasswd[1];
        Set<Map.Entry<String, String>> passwdEntry = passwd.entrySet();
        for (Map.Entry<String, String> entry : passwdEntry) {
            if (username.equals(entry.getKey())) {
                if (password.equals(entry.getValue())) {
                    return "1";
                } else {
                    return "0";
                }
            }
        }
        return "0";
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = in.readLine();
            String passwdStr = line;
            String isLoggedIn = pass(passwdStr);
            out.write(isLoggedIn + "\r\n");
            out.flush();
            if ("0".equals(isLoggedIn)) {
                return;
            }
            while (true) {
                line = in.readLine();
                if (line == null) {
                    break;
                }
                for (Socket socket : ChatServer.clients) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bufferedWriter.write(line + "\r\n");
                    bufferedWriter.flush();
                }
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
