package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.threads;

public class Q {

    private int randomIntNumber;
    private boolean valueSet = false;
    private boolean isComposite = true;
    private int countSimpleNumber = 0;

    synchronized void checkRandomNumber() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //System.out.println("Пoлyчeнo : " + randomIntNumber);

        if (randomIntNumber == 2) {
            countSimpleNumber++;
            System.out.println("The " + countSimpleNumber + " random simple integer number: " + randomIntNumber);
        }
        if (randomIntNumber >= 2) {
            for (int i = 2; i < randomIntNumber; i++) {
                if (randomIntNumber % i == 0) {
                    isComposite = false;
                    break;
                }
            }
            if (isComposite) {
                countSimpleNumber++;
                System.out.println("The " + countSimpleNumber + " random simple integer number: " + randomIntNumber);
            }
            isComposite = true;
        }

        valueSet = false;
        notify();
    }

    synchronized void putRandomIntNumber(int randomIntNumber) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.randomIntNumber = randomIntNumber;
        valueSet = true;
        //System.out.println("Oтпpaвлeнo : " + randomIntNumber);
        notify();
    }

    public int getCountSimpleNumber() {
        return countSimpleNumber;
    }

}
