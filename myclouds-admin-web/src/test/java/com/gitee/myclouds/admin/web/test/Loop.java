package com.gitee.myclouds.admin.web.test;

import java.net.ServerSocket;

public class Loop {
    public static void main(String[] a) throws Exception {
        Loop l = new Loop();
        l.setN(0);
        ServerSocket s = new ServerSocket();
        s.accept();
        while (l.getN()<=10){
            l.setN(l.getN()+1);
            System.out.print(l.getN());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }
    }
    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
