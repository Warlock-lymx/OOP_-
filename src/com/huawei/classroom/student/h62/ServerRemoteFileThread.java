package com.huawei.classroom.student.h62;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;

public class ServerRemoteFileThread extends Thread{
    private Socket client;
    private File file;

    public ServerRemoteFileThread(Socket client, File file){
        this.client = client;
        this.file = file;
    }

    @Override
    public void run() {
        try(DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream())
        ){
            while (true){
                switch (in.readUTF()){
                    case  "dirByNameAsc":
                        File[] files = file.listFiles();
                        out.writeInt(files.length);
                        out.flush();
                        Arrays.sort(files, ((o1, o2) -> {
                            if(o1.isDirectory() && o2.isFile())
                                return -1;
                            else if(o1.isFile() && o2.isDirectory())
                                return 1;
                            else
                                return o1.getName().compareTo(o2.getName());
                        }));
                        for(File f : files){
                            if(f.isDirectory()){
                                out.writeUTF(f.getName() + "/");
                                out.flush();
                            }
                            else{
                                out.writeUTF(f.getName());
                                out.flush();
                            }
                        }
                        break;

                    case "writeByBytes" :
                        if(!file.exists()){
                            if(!file.getParentFile().exists()){
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                        }
                        byte[] bytes = new byte[in.readInt()];
                        in.read(bytes);
                        FileOutputStream fout = new FileOutputStream(file);
                        fout.write(bytes);
                        fout.flush();
                        fout.close();
                        break;

                    case "isDirectory" :
                        out.writeBoolean(file.isDirectory());
                        out.flush();
                        break;
                    case "length" :
                        out.writeLong(file.length());
                        out.flush();
                        break;
                    case "exists" :
                        out.writeBoolean(file.exists());
                        out.flush();
                        break;
                    case "delete" :
                        out.writeBoolean(file.delete());
                        out.flush();
                        break;

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
