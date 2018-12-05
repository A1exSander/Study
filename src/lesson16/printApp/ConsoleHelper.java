package lesson16.printApp;


import java.util.Scanner;

public class ConsoleHelper {
    public static void writeString(String string) {
        System.out.println(string);
    }

    public static String readString() {
        Scanner in = new Scanner(System.in);
        return(in.nextLine());
    }
}
