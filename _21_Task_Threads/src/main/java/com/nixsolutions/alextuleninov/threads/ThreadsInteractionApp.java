package com.nixsolutions.alextuleninov.threads;

/**
 * The class implements the Producer - Consumer patterns through a common queue
 * by Shildt, page 308.
 * Threads interaction.
 * */
public class ThreadsInteractionApp {

    public static void main(String[] args) throws InterruptedException {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }

}
