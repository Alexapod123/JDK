package org.example.server.view;

import org.example.server.underTheHood.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    JButton btnStart, btnStop;
    JTextArea log;
    private Server server;

    public ServerWindow() {
        setting();
        createPanel();
        setVisible(true);
    }

    @Override
    public void setServer(Server server) {
        this.server = server;
    }

    private void setting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("SERVER");
        setLocationRelativeTo(null);
    }

    public Server getConnection() {
        return server;
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButton(), BorderLayout.SOUTH);
    }

    private Component createButton() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Начать");
        btnStop = new JButton("Закончить");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    @Override
    public void showMessage(String text) {
        log.append(text);
    }
}
