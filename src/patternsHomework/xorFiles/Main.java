package patternsHomework.xorFiles;

//Используя паттерн Decorator создать шифрующие с помощью XOR потоки ввода/вывода.
//Они должны наследовать FilterInputStream и FilterOutputStream.
//Конструктор этих потоков должен принимать пароль в виде массива байт и поток, который он декорирует.
//
//Использование должно выглядеть следующим образом:
//Трафик автоматически шифрует и дешифруется:
//InputStream in = new CryptoInputStream(socket.getInputStream(), password);
//OutputStream out = new CryptoOutputStream(socket.getOutputStream(), password);
//
//Сохраняем в шифрованный файл и читаем из шифрованного файла:
//InputStream in = new CryptoInputStream(new FileInputStream("test.bin"), password);
//OutputStream out = new CryptoOutputStream(new FileOutputStream("test.bin"), password);

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String file1 = "Crypto1.txt";
        String file2 = "Crypto2.txt";
        String file3 = "Crypto3.txt";

        String password = "password";

        try (
                InputStream in = new CryptoInputStream(new FileInputStream(file1), password.getBytes());
                OutputStream out = new CryptoOutputStream(new FileOutputStream(file2), password.getBytes())
        ) {
            byte[] buf = new byte[500];
            while ((in.read(buf)) > 0){
                out.write(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                InputStream in = new CryptoInputStream(new FileInputStream(file2), password.getBytes());
                OutputStream out = new CryptoOutputStream(new FileOutputStream(file3), password.getBytes())
        ) {
            byte[] buf = new byte[500];
            while ((in.read(buf)) > 0){
                out.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
