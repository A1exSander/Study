package lesson16.printApp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;
import java.util.Scanner;

public class Client {

    private  IOConnection connection;

    private SocketAddress socketAddress;
    private Scanner scanner;

    public Client(SocketAddress socketAddress, Scanner scanner) {
        this.socketAddress = socketAddress;
        this.scanner = scanner;
    }

    private static SocketAddress parseAddress(String address) {
        String[] strings = address.split(":");
        return new InetSocketAddress(strings[0], Integer.parseInt(strings[1]));
    }

    public static void main(String[] args) {

        String address = null;
        if (args != null && args.length > 0) {
            address = args[0];
        }

        Scanner scanner = new Scanner(System.in);
        if (address == null) {
            System.out.println("Enter server IP and port");
            address = scanner.nextLine();
        }
        Client client = new Client(parseAddress(address), scanner);
        client.start();
    }

    private void start() {
        System.out.println("Имя");
        String name = ConsoleHelper.readString();
        while (true) {
            System.out.println("Сообщение");
            String message = ConsoleHelper.readString();
            try {
                Socket socket = new Socket("localhost", 8080);
                connection = new IOConnection(socket);
                Date date = new Date();
                connection.send(new Message(name, message, date));
                ConsoleHelper.writeString(connection.receive().getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
