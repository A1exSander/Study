package lesson16.printApp;

import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private IOConnection ioConnection;
    private Scanner in = new Scanner(System.in);

    public Client(IOConnection ioConnection) {
        this.ioConnection = ioConnection;
    }

    public static void main(String[] args) {
        try {
            Client client = new Client(new IOConnection(new Socket("127.0.0.1", 8080)));
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void start() {
        System.out.println("Enter your name");
        String name = in.nextLine();

        Thread reader = new Thread(new Reader(ioConnection));
        reader.start();

        System.out.println("Enter message");
        while (true) {
            String msg = in.nextLine();

            // реализовать возможность выхода (/exit)
            // реализовать возможность сменить имя пользователя (/nick)

            if (msg != null && !msg.isEmpty()) {
                Date date = new Date();
                Message message = new Message(name, msg, date);
                ioConnection.send(message);
            }
        }
    }

    private class Reader implements Runnable {
        private final IOConnection connection;

        public Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                System.out.println(message);
            }
        }
    }
//    private  IOConnection connection;
//
//    private SocketAddress socketAddress;
//    private Scanner scanner;
//
//    public Client(SocketAddress socketAddress, Scanner scanner) {
//        this.socketAddress = socketAddress;
//        this.scanner = scanner;
//    }
//
//    private static SocketAddress parseAddress(String address) {
//        String[] strings = address.split(":");
//        return new InetSocketAddress(strings[0], Integer.parseInt(strings[1]));
//    }
//
//    public static void main(String[] args) {
//
//        String address = null;
//        if (args != null && args.length > 0) {
//            address = args[0];
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        if (address == null) {
//            System.out.println("Enter server IP and port");
//            address = scanner.nextLine();
//        }
//        Client client = new Client(parseAddress(address), scanner);
//        client.start();
//    }
//
//    private void start() {
//        System.out.println("Имя");
//        String name = ConsoleHelper.readString();
//        while (true) {
//            System.out.println("Сообщение");
//            String message = ConsoleHelper.readString();
//            try {
//                Socket socket = new Socket("localhost", 8080);
//                connection = new IOConnection(socket);
//                Date date = new Date();
//                connection.send(new Message(name, message, date));
//                ConsoleHelper.writeString(connection.receive().getMessage());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
