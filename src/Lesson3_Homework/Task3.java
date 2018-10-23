package Lesson3_Homework;

//Задача 3
//Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
//Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] lion = new int[15];
        int counter=0;
        for (int i=0; i<15; i++){
            lion[i] = (int) (Math.random()*10);
            if (lion[i]%2==0 && lion[i]!=0) counter++;
        }
        System.out.println(Arrays.toString(lion));
        System.out.println("Количество четных элементов: " + counter);
    }
}
