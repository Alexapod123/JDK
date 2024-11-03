package org.example.client.underTheHood;

import org.example.client.view.ClientView;
import org.example.server.underTheHood.Server;

public class Client {

    private final Server server;
    private boolean isConnected;
    private String name;
    private ClientView clientView;

    public Client(Server server, ClientView clientView) {
        this.server = server;
        this.clientView = clientView;
        clientView.setClient(this);
    }

    public void answer(String text) {
        appendLog(text);
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            appendLog("Успешное подключение\n");
            isConnected = true;
            String log = server.getLog();
            if (!log.isEmpty()) {
                appendLog(log);
            }
            return true;
        } else{
            appendLog("При подключении произошла ошибка");
            return false;
        }
    }

    public void disconnectFromServer() {
        if (isConnected) {
            isConnected = false;
           clientView.disconnectFromServer();
            appendLog("Успешное отключение. До новых встреч!");
        }
    }
    public void disconnectServer(){
        server.disconnectUser(this);
    }

    public void message(String text) {
        if (isConnected) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else appendLog("Отсутствует подключение");
    }

    private void appendLog(String text) {
        clientView.showMessage(text + "\n");
    }

    public String getName() {
        return name;
    }

}
