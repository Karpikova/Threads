package com.company;


import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {

        Message msg = new Message("обработать");

        EverySecond everySecond = new EverySecond(msg);
        Thread everySecondThread = new Thread(everySecond);
        everySecondThread.run();

        MessageFiveSec messageFiveSec = new MessageFiveSec(msg);
        Thread messageFiveSecThread = new Thread(messageFiveSec);
        messageFiveSecThread.run();
    }
}
