package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;
    private Connection connection;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
        try {
            connection = new Connection(new Socket(ip, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        SimpleMessage formServer = connection.readMessage(connection.getID());
                        System.out.println("ответ от сервера: " + formServer);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        reader.start();

        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                String messageText;
                while (true){
                    System.out.println("Введите сообщение");
                    messageText = scanner.nextLine();
                    try {
                        SimpleMessage s = SimpleMessage.getMessage(name, messageText, connection.getID());
                        connection.sendMessage(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        sender.start();
    }

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
