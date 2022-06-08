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
            connection = new Connection(getSocket());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String messageText;
        while (true){
            // exit
            // ping
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            sendAndPrintMessage(this.connection, SimpleMessage.getMessage(name, messageText));
            if (messageText.equals("/exit")) System.exit(0);
        }
    }

    private synchronized void sendAndPrintMessage(Connection connection, SimpleMessage message) throws Exception {

        //try (Connection connection = new Connection(getSocket()) ){ нормально работает только с этим блоком,
        // но как я понимаю из-за AutoCloseable соединение закрывается и создается новое при каждом вызове данного метода

        connection.sendMessage(message);

        SimpleMessage formServer = connection.readMessage();
        System.out.println("ответ от сервера: " + formServer);
        //}
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    public static void main(String[] args) {
        int port = 8290;
        String ip = "127.0.0.1";

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Client(port, ip).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadOne.start();

        /*try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
