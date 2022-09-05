package com.huawei.classroom.student.h04;

public class MyStack {
    int maxsize;
    int top;
    int[] stack;

    public MyStack(int size) {
        this.maxsize = size;
        this.top = 0;
        this.stack = new int[size];
    }

    public boolean isEmpty() {
        if(top == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public  boolean isFull() {
        if(top == maxsize){
            return true;
        }
        else{
            return false;
        }
    }

    public void push(int n) {
        if(isFull()){
            return;
        }
        else{
            stack[top] = n;
            top++;
        }
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        else{
            int result = stack[top - 1];
            top--;
            return result;
        }
    }
}
