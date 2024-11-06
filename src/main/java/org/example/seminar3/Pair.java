package org.example.seminar3;

public class Pair<T, V> {
    T t;
    V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString() {
        return t + " " + v.toString();
    }
}
