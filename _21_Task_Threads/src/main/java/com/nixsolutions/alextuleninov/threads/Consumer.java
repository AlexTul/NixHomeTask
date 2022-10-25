package com.nixsolutions.alextuleninov.threads;

public class Consumer implements Runnable{

    Q q;
    private static final int NUMBER_OF_TIMES = 10;
    private int countSimpleNumber;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (countSimpleNumber < NUMBER_OF_TIMES) {
            q.checkRandomNumber();
            this.countSimpleNumber = q.getCountSimpleNumber();
        }
    }
}
