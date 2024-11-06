package org.example.seminar1_2.server.view;

import org.example.seminar1_2.server.underTheHood.Server;

public interface ServerView {
    void showMessage(String text);
    void setServer(Server server);
}
