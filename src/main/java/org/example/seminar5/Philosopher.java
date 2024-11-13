package org.example.seminar5;

public class Philosopher extends Thread {
    private final int id;
    private final int leftFork;
    private final int rightFork;
    private int philEater;
    private final Table table;

    public Philosopher(int id, int leftFork, int rightFork, Table table) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        philEater = 0;
        this.table = table;

    }

    @Override
    public void run() {
        while (philEater < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }

    private void eating() throws InterruptedException {
        if (table.takeFork(leftFork, rightFork)) {
            System.out.println("Философ " + (id + 1) + " ест");
            sleep(1000);
            table.putFork(leftFork, rightFork);
            System.out.println("Философ " + (id + 1) + " положил приборы");
            thinking();
            philEater++;
        }
    }

    private void thinking() throws InterruptedException {
        System.out.println("Философ " + (id + 1) + " задумался");
        sleep(5000);
    }
}
