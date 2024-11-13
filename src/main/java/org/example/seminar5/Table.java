package org.example.seminar5;

public class Table extends Thread {
    private final int groupPhilosophers = 5;
    private final Philosopher[] philosophers;
    private final Fork[] forks;

    public Table() {
        philosophers = new Philosopher[groupPhilosophers];
        forks = new Fork[groupPhilosophers];
        createTable();
    }

    @Override
    public void run() {
        think();
        System.out.println("Философы собрались");
    }

    private void think() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    public void putFork(int leftFork, int rightFork) {
        forks[leftFork].setAtHand(false);
        forks[rightFork].setAtHand(false);
    }

    public boolean takeFork(int leftFork, int rightFork) {
        if (!forks[leftFork].isAtHand() && !forks[rightFork].isAtHand()) {
            forks[leftFork].setAtHand(true);
            forks[rightFork].setAtHand(true);
            return true;
        }
        return false;
    }

    private void createTable() {
        for (int i = 0; i < groupPhilosophers; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < groupPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, i, (i + 1) % 5, this);
        }
    }
}
