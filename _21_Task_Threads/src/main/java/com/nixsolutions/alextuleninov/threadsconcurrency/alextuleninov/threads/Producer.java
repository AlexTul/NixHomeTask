package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.threads;

import java.util.Random;

public class Producer implements Runnable{
    Q q;
    private static final int NUMBER_OF_TIMES = 10;
    private int countSimpleNumber;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int randomIntNumber;
        while (countSimpleNumber < NUMBER_OF_TIMES) {
            randomIntNumber = new Random().nextInt(60);
            q.putRandomIntNumber(randomIntNumber);
            this.countSimpleNumber = q.getCountSimpleNumber();
        }
    }

}
