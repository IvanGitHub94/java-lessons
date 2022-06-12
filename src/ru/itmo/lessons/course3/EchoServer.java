package ru.itmo.lessons.course3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServer {
    private int port;
    private ArrayBlockingQueue<SimpleMessage> queue = new ArrayBlockingQueue<SimpleMessage>(10, true);
    private CopyOnWriteArrayList<Connection> connectionsList = new CopyOnWriteArrayList<Connection>();

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");

            /*queue = new ArrayBlockingQueue<SimpleMessage>(10, true);
            connectionsList = new CopyOnWriteArrayList<Connection>();*/

            Thread send = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            SimpleMessage tempMsg = queue.take();
                            for (Connection c : connectionsList) {
                                if (c.getID() != tempMsg.getIDConnection()) { ////////////////////////////////////// ???
                                    c.sendMessage(tempMsg);
                                }
                            }
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            send.start();

            while (true) {
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);

                connectionsList.add(connection);
                System.out.println("---------------- " + connection.getID());

                Thread arrival = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                SimpleMessage t = connection.readMessage(connection.getID());
                                queue.put(t);
                                printMessage(t);
                            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                arrival.start();
            }
        }
    }

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
