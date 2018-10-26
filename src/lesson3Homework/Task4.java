package lesson3Homework;

//Задача 4*
//Пользователь должен указать с клавиатуры чётное положительное число, а программа должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку.
//После этого программа должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше:
//левой или правой, либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число,
//то программа должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int ammInt=0, leftModSum=0, rightModSum=0;
        do {
            System.out.println("Введите четное положительное число");
            Scanner amm = new Scanner(System.in);
            ammInt = amm.nextInt();
        } while (ammInt<=0 || ammInt%2!=0);
        int[] caracal = new int[ammInt];
        Random rnd = new Random();
        for (int i=0; i<ammInt; i++){
            caracal[i] = (rnd.nextInt(11))-5;
            if (i <= (ammInt-1)/2) leftModSum = leftModSum + Math.abs(caracal[i]);
            else rightModSum = rightModSum + Math.abs(caracal[i]);
            }

        System.out.println(Arrays.toString(caracal));
        if (leftModSum>rightModSum) System.out.println("Сумма модулей левой половины массива больше");
        else if (leftModSum<rightModSum) System.out.println("Сумма модулей правой половины массива больше");
        else System.out.println("Сумма модулей левой и правой половин массива равны");
    }
}
