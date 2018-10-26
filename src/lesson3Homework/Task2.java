package lesson3Homework;

import java.util.Arrays;

//Задача 2
//Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
//а затем этот же массив выведите на экран тоже в строку,
//но в обратном порядке (99 97 95 93 … 7 5 3 1).

public class Task2 {
    public static void main(String[] args) {
        int[] panther = new int[50];
        for (int i=0; i<50; i++){
            panther[i]=i*2+1;
        }
        System.out.println(Arrays.toString(panther));
        for (int i=49; i>=0; i--){
            panther[i]=99-(i*2);
        }
        System.out.println(Arrays.toString(panther));
    }
}
