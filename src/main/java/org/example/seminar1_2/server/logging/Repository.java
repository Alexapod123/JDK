package org.example.seminar1_2.server.logging;

public interface Repository<T> {
    void logging(T text);
    T readLog();
}
