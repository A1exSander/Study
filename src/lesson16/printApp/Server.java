package lesson16.printApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {

    private int port;

    private final Set<IOConnection> connections = new CopyOnWriteArraySet<>();

    private final BlockingDeque<Message> messagesBlockingDeque = new LinkedBlockingDeque<>();

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        Server server = new Server(8080);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        new Thread (new Writer()).start();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on: " + serverSocket);

            IOConnection ioConnection;

            while (true) {
                Socket socket = serverSocket.accept();

                ioConnection = new IOConnection(socket);
                connections.add(ioConnection);

                new Thread(new Reader(ioConnection)).start();
            }

        }
    }

    private class Writer implements Runnable{
        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    Message message = messagesBlockingDeque.take();
                    for (IOConnection connection: connections) {
                        connection.send(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Reader implements Runnable {
        private IOConnection connection;

        public Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                messagesBlockingDeque.add(message);
                System.out.println(message);
            }

        }
    }

//
//    public static void main(String[] args) {
//        int port = Integer.parseInt(args[0]);
//        Server server = new Server(port);
//        server.start();
//
//    }
//
//
//    private void printMessage (Message message) {
//        System.out.println(message);
//    }
//
//    public void start() {
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Server started on:" + serverSocket);
//
//            while (true) {
//                Socket socket = serverSocket.accept();
//                IOConnection ioConnection = new IOConnection(socket);
//                Message message = ioConnection.receive();
//                printMessage(message);
//                Date date = new Date();
//                ioConnection.send(new Message("Сообщение получено", message.getMessage(), date));
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
