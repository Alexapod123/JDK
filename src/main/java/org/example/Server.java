package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final String PATHFORLOG = "src/main/java/org/example/chat.txt";

    List<Client> clients;

    JButton btnStart, btnStop;
    JTextArea log;
    boolean isWork;

    public Server() throws HeadlessException {
        clients = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("SERVER");
        setLocationRelativeTo(null);

        createPanel();
        setVisible(true);
    }

    public boolean connectUser(Client client) {
        if (!isWork) {
            return false;
        }
        clients.add(client);
        appendLog(client.tfLogin.getText() + " присоединился к беседе");
        return true;
    }

    public String getLog() {
        return readLog();
    }

    public void disconnectUser(Client client) {
        clients.remove(client);
        if (client != null) {
            client.disconnectServer();
        }
    }

    public void message(String text) {
        if (!isWork) {
            return;
        }
        text += " ";
        appendLog(text);
        answerAll(text);
        logging(text);

    }

    private void answerAll(String text) {
        for (Client client : clients) {
            client.answer(text);
        }
    }

    private void logging(String text) {
        try (FileWriter writer = new FileWriter(PATHFORLOG, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(PATHFORLOG)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            sb.delete(sb.length() - 1, sb.length());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text) {
        log.append(text + "\n");
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
                if (isWork) {
                    appendLog("Сервер уже запущен!");
                } else {
                    isWork = true;
                    appendLog("Сервер запущен");
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isWork) {
                    isWork = false;
                    while (!clients.isEmpty()) {
                        disconnectUser(clients.get(clients.size() - 1));
                    }
                    appendLog("Сервер остановлен");
                } else appendLog("Сервер уже остановлен");
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

}
