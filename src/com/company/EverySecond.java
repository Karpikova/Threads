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

    private Message messageToAnotherThread;

    public EverySecond(Message msg) {
        this.messageToAnotherThread = msg;
    }

    @Override
    public void run() {
        int difftime;
        Date startDate = new Date();
        while (true){
            Date currDate = new Date();
            difftime = (int)(currDate.getTime() - startDate.getTime())/1000;
            System.out.println(difftime);
            synchronized (messageToAnotherThread) {
                messageToAnotherThread.setMessage(difftime);
                messageToAnotherThread.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
