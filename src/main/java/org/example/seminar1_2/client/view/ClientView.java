package org.example.seminar1_2.client.view;

import org.example.seminar1_2.client.Client;

public interface ClientView {
    void showMessage(String text);

    void disconnectFromServer();

    void setClient(Client client);
}
