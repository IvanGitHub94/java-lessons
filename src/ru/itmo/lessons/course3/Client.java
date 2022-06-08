package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
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
            sendAndPrintMessage(SimpleMessage.getMessage(name, messageText));
            if (messageText.equals("/exit")) System.exit(0);
        }
    }

    private synchronized void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket()) ){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);

            SimpleMessage formServer = connection.readMessage();
            System.out.println("ответ от сервера: " + formServer);
        }
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    public static void main(String[] args) {
        int port = 8290;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
