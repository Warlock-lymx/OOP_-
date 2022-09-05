package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread{
    public StringBuffer buffer;

    public ThreadUtil(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        buffer.delete(0,buffer.length());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            buffer.append("ok");
        }
    }
}
