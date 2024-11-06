package org.example.seminar1_2.server.underTheHood;

import org.example.seminar1_2.client.Client;
import org.example.seminar1_2.server.logging.Repository;
import org.example.seminar1_2.server.view.ServerView;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerView serverView;
    private Repository<String> repository;
    List<Client> clients;
    boolean isWork;

    public Server(ServerView serverView, Repository<String> repository) {
        this.serverView = serverView;
        clients = new ArrayList<>();
        this.repository = repository;
        serverView.setServer(this);
    }
    public void start(){
        if (isWork) {
            appendLog("Сервер уже запущен!");
        } else {
            isWork = true;
            appendLog("Сервер запущен");
        }
    }
    public void stop(){
        if (isWork) {
            isWork = false;
            while (!clients.isEmpty()) {
                disconnectUser(clients.get(clients.size() - 1));
            }
            appendLog("Сервер остановлен");
        } else appendLog("Сервер уже остановлен");
    }

    public boolean connectUser(Client client) {
        if (!isWork) {
            return false;
        }
        clients.add(client);
        appendLog(client.getName() + " присоединился к беседе");
        return true;
    }


    public void disconnectUser(Client client) {
        clients.remove(client);
        if (client != null) {
            client.disconnectFromServer();
            appendLog(client.getName() + " покинул чат");
        }
    }

    public void message(String text) {
        if (!isWork) {
            return;
        }
        appendLog(text);
        answerAll(text);
        logging(text);

    }

    private void answerAll(String text) {
        for (Client client : clients) {
            client.answer(text);
        }
    }
    public String getLog(){
        return repository.readLog();
    }


    private void appendLog(String text) {
        serverView.showMessage(text + "\n");
    }

  private void logging(String text){
        repository.logging(text);
  }




}
