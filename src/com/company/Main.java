package com.company;

public class Main {

    public static void main(String[] args) {

        Message msg = new Message(0);

        EverySecond everySecond = new EverySecond(msg);
        Thread everySecondThread = new Thread(everySecond);
        everySecondThread.start();

        MessageNSec messageFiveSec = new MessageNSec(msg, 5, "Долгожданный message");
        Thread messageFiveSecThread = new Thread(messageFiveSec);
        messageFiveSecThread.start();

        MessageNSec messageSevenSec = new MessageNSec(msg, 7, "Не столь долгожданный message");
        Thread messageSevenSecThread = new Thread(messageSevenSec);
        messageSevenSecThread.start();
    }
}
