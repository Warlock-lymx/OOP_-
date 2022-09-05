package com.huawei.classroom.student.h62;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MyRemoteFile {
    private Socket client;
    private String path;
    private MyHost host;

    public MyRemoteFile(MyHost host, String path){
        try{
            client = new Socket(host.getIp(),host.getPort());
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            this.host = host;
            this.path = path;
            out.writeUTF(host.getUsername());
            out.flush();
            out.writeUTF(host.getPassword());
            out.flush();
            if(in.readBoolean()){
                out.writeUTF(path);
                out.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MyRemoteFile[] dirByNameAsc() throws Exception{
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeUTF("dirByNameAsc");
        out.flush();
        MyRemoteFile[] result = new MyRemoteFile[in.readInt()];
        for(int i = 0; i < result.length; i ++){
            result[i] = new MyRemoteFile(host, path + in.readUTF());
        }
        return result;
    }

    public void writeByBytes(byte[] bytes) throws Exception {
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeUTF("writeByBytes");
        out.flush();
        out.writeInt(bytes.length);
        out.flush();
        out.write(bytes);
        out.flush();
    }

    public boolean isDirectory() throws Exception {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            out.writeUTF("isDirectory");
            out.flush();
            return in.readBoolean();

    }

    public boolean isFile() throws Exception {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            out.writeUTF("isDirectory");
            return !in.readBoolean();
    }

    public String getPathFileName() {
        return path;
    }

    public long length() throws Exception {
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeUTF("length");
        out.flush();
        return in.readLong();
    }

    public void delete() throws Exception {
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeUTF("delete");
        out.flush();
        in.readBoolean();
    }

    public boolean exists() throws Exception {
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());
        out.writeUTF("exists");
        out.flush();
        return in.readBoolean();
    }


}
