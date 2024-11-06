package org.example.seminar1_2.client.view;

import org.example.seminar1_2.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClintGUI extends JFrame implements ClientView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private JTextArea log;
    private JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    private JPasswordField password;
    private JButton btnLogin, btnSend;
    private JPanel headerPanel;
    private Client client;

    public ClintGUI(){
        setting();
        createPanel();
        setVisible(true);
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }
    private void setting(){
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public void showMessage(String text) {
        log.append(text);
    }

    @Override
    public void disconnectFromServer() {
        hideHeaderPanel(true);
    }
    public void disconnectServer(){
        client.disconnectServer();
    }
    public void hideHeaderPanel(boolean visible){
        headerPanel.setVisible(visible);
    }
    public void login(){
        if(client.connectToServer(tfLogin.getText())){
            headerPanel.setVisible(false);

        }
    }
    private void message(){
        client.message(tfMessage.getText());
        tfMessage.setText("");
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
                login();
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
