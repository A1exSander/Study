package Lesson3_Homework;

//1) Найти в строке указанную подстроку и заменить ее на новую.
//Строку, ее подстроку для замены и новую подстроку вводит пользователь.
//
//2) Требуется удалить из нее повторяющиеся символы и все пробелы.
//Например, если было введено "abc cde def", то должно быть выведено "abcdef".
//
//3) Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы.
//Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив.
//Например, если дана строка "дом 48, корпус 9, парадная 7, этаж 4", то в массиве должны оказаться числа 48, 9, 7 и 4

import java.util.Scanner;

public class HomeworkStrings {
    public static void main(String[] args) {
        Scanner scanString = new Scanner(System.in);
        System.out.println("Введите главную строку");
        String string1 = scanString.nextLine();
        System.out.println("Введите подстроку для замены");
        String string2 = scanString.nextLine();
        System.out.println("Введите новую подстроку");
        String string3 = scanString.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        if (string1.contains(string2)) string1 = string1.replace(string2, string3);
        System.out.println(string1);
    }
}
