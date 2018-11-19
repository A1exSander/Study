package lesson13Homework.listsAndMaps;

//Задача 1
//        Написать программу со следующим функционалом:
//        Считывание максимум 5 строк с клавиатуры,
//        занесение строк в список,
//        поиск самой короткой строки,
//        вывод самой короткой строки на экран по запросу пользователя (команда в консоле /short string)
//        Если одинаково коротких строк несколько, выводить каждую с новой строки.


import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        String shortStr;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<5; i++) {
            strings.add(scanner.nextLine());
        }
        System.out.println(strings);
        shortStr = strings.get(0);
        for (String count: strings) {
            if (count.length() < shortStr.length()) shortStr=count;
        }
            if (scanner.nextLine().equals("/short string")){
                for (String count: strings) {
                    if (count.length() == shortStr.length()) {
                        System.out.println(count);
                    }
                }
            }


    }
}

