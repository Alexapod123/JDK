package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private final Server server;
    private boolean isConnected;
    private String name;

    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;

    public Client(Server server) throws HeadlessException {
        this.server = server;
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat");
        setLocation(server.getX() - 500, server.getY());
        createPanel();
        setVisible(true);
    }


    public void answer(String text) {
        appendLog(text);
    }

    private void connectServer() {
        if (server.connectUser(this)) {
            appendLog("Успешное подключение\n");
            headerPanel.setVisible(false);
            isConnected = true;
            name = tfLogin.getText();
            String log = server.getLog();
            if (!log.isEmpty()) {
                appendLog(log);
            }
        } else appendLog("При подключении произошла ошибка");
    }

    public void disconnectServer() {
        if (isConnected) {
            headerPanel.setVisible(true);
            isConnected = false;
            server.disconnectUser(this);
            appendLog("Успешное отключение. До новых встреч!");
        }
    }

    public void message() {
        if (isConnected) {
            String text = tfMessage.getText();
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
                tfMessage.setText("");
            }
        } else appendLog("Отсутствует подключение");
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(creteFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel() {
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("name");
        password = new JPasswordField("password");
        btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectServer();
            }
        });
        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);
        return headerPanel;
    }

    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component creteFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    message();
                }
            }
        });
        btnSend = new JButton("Отправить");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend,BorderLayout.EAST);
        return panel;
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectServer();
        }
        super.processWindowEvent(e);
    }
}
