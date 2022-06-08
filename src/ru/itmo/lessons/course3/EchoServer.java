package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private int port;
    private Connection connection;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            int connectionCount = 0;
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                connectionCount++;

                SimpleMessage temp = connection.readMessage();
                long a = System.currentTimeMillis();
                printMessage(temp);
                if (temp.getText().equals("/help")) {
                    connection.sendMessage(SimpleMessage.getMessage("server", "\n Список доступных команд:" +
                            "\n /help - вывод списка команд;" +
                            "\n /count - отображение количества подключений;" +
                            "\n /ping - время, за которое сообщение доходит до сервера и возвращается обратно, мс;" +
                            "\n /exit - завершение программы. \n"));
                }
                else if (temp.getText().equals("/count")) {
                    connection.sendMessage(SimpleMessage.getMessage("server", String.valueOf(connectionCount)));
                }
                else if (temp.getText().equals("/ping")) {
                    connection.sendMessage( SimpleMessage.getMessage("server", "ping: "
                            + (System.currentTimeMillis() - a)
                            + " ms") );
                }
                else if (temp.getText().equals("/exit")) {
                    connection.sendMessage( SimpleMessage.getMessage("server", "Соединение разорвано." ));
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else connection.sendMessage(SimpleMessage.getMessage("server", "сообщение получено"));
            }
        }
    }

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8290;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
