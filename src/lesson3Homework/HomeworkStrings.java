package lesson3Homework;

//1) Найти в строке указанную подстроку и заменить ее на новую.
//Строку, ее подстроку для замены и новую подстроку вводит пользователь.
//
//2) Требуется удалить из нее повторяющиеся символы и все пробелы.
//Например, если было введено "abc cde def", то должно быть выведено "abcdef".
//
//3) Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы.
//Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив.
//Например, если дана строка "дом 48, корпус 9, парадная 7, этаж 4", то в массиве должны оказаться числа 48, 9, 7 и 4

import java.util.Arrays;
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
        if (string1.contains(string2)) {
            string1 = string1.replace(string2, string3);
            System.out.println(string1);
        }
        else System.out.println("Ошибка! Искомой подстроки нет в исходной.");

// Адовое удаление повторяющихся символов и пробелов (не забыть спросить про регулярные выражения и коллекции на занятии
        string1 = string1.replaceAll(" ","");
        char[] chars = string1.toCharArray();
// Перебираю массив от конца к началу, так как буду удалять символы, повторяющиеся далее по циклу
        for (int i=string1.length()-1; i>=0; i--) {
            int counter = 0;
            for (int j=string1.length()-1; j>=0; j--) {
                if (chars [i] == chars [j]) counter ++;
                if (counter>1) {
                    chars[i] = 0;
                    break;
// Обнуляю значение элемента массива
                }
            }
        }
//        System.out.println(Arrays.toString(chars));
// Склеиваем массив, исключаем пустые поля
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<chars.length; i++){
            if (chars[i]!=0) stringBuilder.append(chars[i]);
        }
// Спросить про foreach (или почитать)
        System.out.println("Строка без повторяющихся символов и пробелов:");
        System.out.println(stringBuilder.toString());
// Вытаскивание чисел
        System.out.println("Введите строку");
        String string4 = scanString.nextLine();
        int counter2=0, k=0, startpos, endpos=0;
        char[] chars2 = string4.toCharArray();
// Сначала считаем, сколько элементов будет в итоговом массиве. Для этого использую два цикла: внешний - чтобы нащупать первую цифру числа, внутренний - последнюю.
        while (k<chars2.length) {
            if (chars2[k]=='0' || chars2[k]=='1' || chars2[k]=='2' || chars2[k]=='3' || chars2[k]=='4' || chars2[k]=='5' || chars2[k]=='6' || chars2[k]=='7' || chars2[k]=='8' || chars2[k]=='9') {
                counter2++;
                while (chars2[k]=='0' || chars2[k]=='1' || chars2[k]=='2' || chars2[k]=='3' || chars2[k]=='4' || chars2[k]=='5' || chars2[k]=='6' || chars2[k]=='7' || chars2[k]=='8' || chars2[k]=='9') {
                    if (k+1<chars2.length) k++;
                    else break;
                }
            }
            k++;
        }
//        System.out.println(counter2);
// Проверка на налиие чисел в строке
        if (counter2>0) {

            int[] result = new int[counter2];

            k = 0;
            counter2 = -1;
// -1, потому что потом это уже будет не размером массива, а индексом
            while (k < chars2.length) {
                if (chars2[k] == '0' || chars2[k] == '1' || chars2[k] == '2' || chars2[k] == '3' || chars2[k] == '4' || chars2[k] == '5' || chars2[k] == '6' || chars2[k] == '7' || chars2[k] == '8' || chars2[k] == '9') {
                    startpos = k;
                    counter2++;
                    while (chars2[k] == '0' || chars2[k] == '1' || chars2[k] == '2' || chars2[k] == '3' || chars2[k] == '4' || chars2[k] == '5' || chars2[k] == '6' || chars2[k] == '7' || chars2[k] == '8' || chars2[k] == '9') {
                        endpos = k+1;
//                        result[counter2]=result[counter2]*10+Character.getNumericValue(chars2[k]); - альтернативный способ
//substring считает первую позицию включительно, а последнюю исключительно. При k больше максимального индекса массива все равно работает
                        if (k + 1 < chars2.length) k++;
                        else break;
                    }
                    result[counter2] = Integer.parseInt(string4.substring(startpos, endpos));
// Не забыть спросить про класс Integer. И про Random.
                }
                k++;
            }

            System.out.println(Arrays.toString(result));
        } else System.out.println("В строке нет чисел");
    }
}
