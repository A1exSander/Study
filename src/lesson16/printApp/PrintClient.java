package lesson16.printApp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;
import java.util.Scanner;

public class PrintClient {

    private SocketAddress socketAddress;
    private Scanner scanner;

    public PrintClient(SocketAddress socketAddress, Scanner scanner) {
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



        PrintClient client = new PrintClient(parseAddress(address), scanner);
        client.start();

    }

    private void start() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();

        while (true) {
            System.out.println("Введите сообщение");
            String msg = scanner.nextLine();

            buildAndSendMessage(name, msg);
        }
    }

    private void buildAndSendMessage(String name, String msg) {
        Date date = new Date();
        Message message = new Message(name, msg, date);
        sendMessage(message);
    }

    private void sendMessage(Message message) {
        try (Socket socket = new Socket()){
            socket.connect(socketAddress);
            try (OutputStream out = socket.getOutputStream()) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(message);
                objOut.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
