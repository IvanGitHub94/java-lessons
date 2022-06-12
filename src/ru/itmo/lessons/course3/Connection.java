package ru.itmo.lessons.course3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class Connection implements AutoCloseable {

    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private double ID;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
        ID = Math.random() * 1000;
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage(double id) throws IOException, ClassNotFoundException {
        SimpleMessage sm = (SimpleMessage) input.readObject();
        sm.setIDConnection(id);
        return sm;
    }


    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }

    public double getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Double.compare(that.ID, ID) == 0 && Objects.equals(socket, that.socket) && Objects.equals(input, that.input) && Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socket, input, output, ID);
    }

    @Override
    public String toString() {
        return "Connection{" +
                "socket=" + socket +
                ", input=" + input +
                ", output=" + output +
                ", ID=" + ID +
                '}';
    }
}
