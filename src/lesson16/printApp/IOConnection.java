package lesson16.printApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class IOConnection {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public IOConnection(Socket socket) {
        this.socket = socket;
        try {
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send (Message message){
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message receive (){
        Message message = null;
        try {
            message = (Message) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return message;
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }
}
