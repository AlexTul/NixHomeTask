package com.nixsolutions.alextuleninov.threadsconcurrency;

public class DiningPhilosophers {

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        synchronized (this) {
            pickLeftFork.run();
            synchronized (this) {
                pickRightFork.run();
                eat.run();
                putRightFork.run();
            }
            putLeftFork.run();
        }
    }

}
