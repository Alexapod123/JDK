package org.example.server.view;

import org.example.server.underTheHood.Server;

public interface ServerView {
    void showMessage(String text);
    void setServer(Server server);
}
