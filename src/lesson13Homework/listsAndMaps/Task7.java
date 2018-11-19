package lesson13Homework.listsAndMaps;

//Задача 7
//        Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
//        Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
//        Результат вывести на экран


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task7 {
    public static void main(String[] args) {
        Map<String, String> names = new TreeMap<>();
        names.put("a", "a");
        names.put("b", "b");
        names.put("c", "d");
        names.put("d", "d");
        names.put("e", "e");
        names.put("f", "f");
        names.put("g", "g");
        names.put("h", "f");
        names.put("i", "i");
        names.put("j", "d");
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String surname = scanner.nextLine();
        for (Map.Entry entry : names.entrySet()) {
            if (entry.getKey().equals(name) || entry.getValue().equals(surname)) counter ++;
        }
        System.out.println(counter);

    }
}
