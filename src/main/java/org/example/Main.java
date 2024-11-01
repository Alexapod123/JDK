package org.example;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int distanceBetweenWind = 150;
        int Width = 800;
        int Height = 600;

        Server server = new Server();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Client client1 = new Client(server);
        client1.setLocation((screenSize.width / 2 - Server.WIDTH - (distanceBetweenWind+distanceBetweenWind/2)), (Height - Server.HEIGHT) / 2);

        Client client2 = new Client(server);
        client2.setLocation(2 * (Server.WIDTH + distanceBetweenWind), (Height - Server.HEIGHT) / 2);


    }
}