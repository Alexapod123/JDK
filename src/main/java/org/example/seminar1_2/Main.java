package org.example.seminar1_2;

import org.example.seminar1_2.client.Client;
import org.example.seminar1_2.client.view.ClintGUI;
import org.example.seminar1_2.server.logging.FileStorage;
import org.example.seminar1_2.server.underTheHood.Server;
import org.example.seminar1_2.server.view.ServerWindow;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(new ServerWindow(), new FileStorage());
        new Client(server, new ClintGUI());
        new Client(server, new ClintGUI());
    }
}