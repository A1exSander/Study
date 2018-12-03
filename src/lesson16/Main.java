package lesson16;

import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        File file = new File("test.txt");
//
//        LaunchStat stat;
//
//        if (!file.exists()) {
//            stat = new LaunchStat();
//        } else {
//            try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file))) {
//                stat = (LaunchStat) objIn.readObject();
//            }
//        }
//
//        if(stat.isFirstLaunch()) {
//            System.out.println("Первый запуск");
//        } else {
//            System.out.println(stat);
//
//            stat.update();
//
//            // Сохранение
//
//            try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file))) {
//                objOut.writeObject(stat);
//            }
//        }
        File file = new File("test.bin");

        LaunchStatExteralizable stat;
        if (!file.exists()) {
            stat = new LaunchStatExteralizable();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                stat = (LaunchStatExteralizable) ois.readObject();
            }
        }

        if (stat.isFirstLaunch()) {
            System.out.println("Первый запуск");
        } else {
            System.out.println(stat);
        }

        stat.update();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(stat);
        }
    }
}
