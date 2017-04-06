package com.company;/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 06.04.2017
 * 
 * Karpikova
 */


public class MessageFiveSec implements Runnable {

    private Message msg;
    private static int count = 0;

    public MessageFiveSec(Message m){
        this.msg = m;
    }

    @Override
    public void run() {
        while (true)
        {
            synchronized (msg) {
                try {
                    msg.wait();
                    count++;
                    if (msg.getMsg().equals("2"))
                    {
                        System.out.println("Долгожданный message");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
