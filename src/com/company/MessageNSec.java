package com.company;/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 06.04.2017
 * 
 * Karpikova
 */


public class MessageNSec implements Runnable {

    private Message messageFromAnotherThread;
    private int countSec;
    private String  messageToTell;

    public MessageNSec(Message m, int countSec, String messageToTell){
        this.messageFromAnotherThread = m;
        this.countSec = countSec;
        this.messageToTell = messageToTell;
    }

    @Override
    public void run() {
        while (true)
        {
            synchronized (messageFromAnotherThread) {
                try {
                    messageFromAnotherThread.wait();
                    if (messageFromAnotherThread.getMessage()%countSec == countSec-1)
                    //if (messageFromAnotherThread.getMessage()==countSec)
                    {
                        System.out.println(messageToTell);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
