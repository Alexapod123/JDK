package org.example;

import org.example.client.underTheHood.Client;
import org.example.client.view.ClintGUI;
import org.example.server.logging.FileStorage;
import org.example.server.underTheHood.Server;
import org.example.server.view.ServerWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(new ServerWindow(), new FileStorage());
        new Client(server, new ClintGUI());
        new Client(server, new ClintGUI());
    }
}