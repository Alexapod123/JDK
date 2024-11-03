package org.example.client.view;

import org.example.client.underTheHood.Client;

public interface ClientView {
    void showMessage(String text);

    void disconnectFromServer();

    void setClient(Client client);
}
