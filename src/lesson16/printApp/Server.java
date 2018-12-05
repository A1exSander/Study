package lesson16.printApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.start();

    }


    private void printMessage (Message message) {
        System.out.println(message);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on:" + serverSocket);

            while (true) {
                Socket socket = serverSocket.accept();
                IOConnection ioConnection = new IOConnection(socket);
                Message message = ioConnection.receive();
                printMessage(message);
                Date date = new Date();
                ioConnection.send(new Message("Сообщение получено", message.getMessage(), date));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
