package org.example.server.logging;

public interface Repository<T> {
    void logging(T text);
    T readLog();
}
