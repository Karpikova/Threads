package com.company;/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 06.04.2017
 * 
 * Karpikova
 */

import java.util.Date;

public class EverySecond implements Runnable {

    private Message msg;

    public EverySecond(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String difftime;
        Date startDate = new Date();
        while (true){
            Date currDate = new Date();
            difftime = String.valueOf((int)(currDate.getTime() - startDate.getTime())/1000);
            System.out.println(difftime);
            synchronized (msg) {//хотябы просто чтобы уходило хоть что-то
                msg.setMsg("2");
                msg.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
