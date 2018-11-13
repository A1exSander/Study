package lesson11;

import java.util.*;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        //Ввести с клавиатуры 5 слов в список строк
        //Удалить 3й-элемент
        //Вывести оставшиеся в обратном порядке
        List<String> list = new ArrayList<>(5);

        Scanner scan = new Scanner(System.in);
        list.add(scan.nextLine());
        list.add(scan.nextLine());
        list.add(scan.nextLine());
        list.add(scan.nextLine());
        list.add(scan.nextLine());

        for(String s:  list){
            System.out.print(s + " ");
        }

        list.remove(2);
        System.out.println();
        for (int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }

    }
}
