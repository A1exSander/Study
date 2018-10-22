package Lesson2_Homework;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        //    Задача 1*
//    В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа. Создать программу, которая переставит числа в переменных таким образом, чтобы при выводе на экран последовательность a, b и c оказалась строго возрастающей.
//
//    Числа в переменных a, b и c: 3, 9, -1
//    Возрастающая последовательность: -1, 3, 9
//
//    Числа в переменных a, b и c: 2, 4, 3
//    Возрастающая последовательность: 2, 3, 4
//
//    Числа в переменных a, b и c: 7, 0, -5
//    Возрастающая последовательность: -5, 0, 7
        final int a=1, b=5, c=-10;
        int first, second, third;
        System.out.println("Задание 1");
        if (a<b && a<c) {
            first=a;
            if (b<c){
                second=b;
                third=c;
            } else {
                second=c;
                third=b;
            }
        } else if (b<a && b<c) {
            first = b;
            if (a < c) {
                second = a;
                third = c;
            } else {
                second = c;
                third = a;
            }
        } else {
            first = c;
            if (a < b) {
                second = a;
                third = b;
            } else {
                second = b;
                third = a;
            }
        }
        System.out.println("Упорядоченная последовательность чисел: "+first+" "+second+" "+third);
        System.out.println();

//        Задача 2
//        Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….
        System.out.println("Задание 2");
        System.out.println("Список чисел последовательности: ");
        for (int i=90; i>0; i=i-5){
            System.out.println(i);
        }
        System.out.println();


//        Задача 3*
//        Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
        int counter3=2;
        System.out.println("Задание 3");
        for (int i=1; i<21; i++){
            System.out.println("Элеемент №" + i + ": " + counter3);
            counter3=counter3*2;
        }
        System.out.println();


//        Задача 4
//        Проверьте, является ли натуральное число — простым.
//        (Метод перебора делителей)
        int number=59, j=0, div=2;
        System.out.println("Задание 4");
        while ((j!=1) && (div*div<=number)) {
            if (number%div==0) j=1;
            div++;
            }
        if (j==0) System.out.println("Число простое");
        else System.out.println("Число составное");
        System.out.println();


//        Задача 5
//        Выведите на экран первые 11 членов последовательности Фибоначчи. Первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
        int fib1=1, fib2=1, fib;
        System.out.println("Задание 5");
        System.out.println("Последовательность Фибоначчи:");
        System.out.println(fib1);
        System.out.println(fib2);
        for (int i=3; i<13; i++) {
            fib = fib1+fib2;
            fib1 = fib2;
            fib2=fib;
            System.out.println(fib);
        }
        System.out.println();



//        Задача 6*
//        В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую неделю трамвайное депо заказывает
//        в местной типографии рулон билетов с номерами от 000001 до 999999. «Счастливым»
//        считается билетик у которого сумма первых трёх цифр номера равна сумме последних трёх цифр, как, например,
//        в билетах с номерами 003102 или 567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого
//        билета и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
//        сколько счастливых билетов в одном рулоне?
        int happyCounter=0;
        System.out.println("Задание 6");
        for (int ticketNum=1; ticketNum<1000000; ticketNum++){
            if (ticketNum/100000 + ticketNum%100000/10000+ ticketNum%10000/1000 == ticketNum%1000/100 + ticketNum%100/10 + ticketNum%10) happyCounter++;
        }
        System.out.println("Количество счастливых битетов: " + happyCounter);
        System.out.println();


//        Задача 7*
//        Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько раз за сутки случается так,
//        что слева от двоеточия показывается симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
        System.out.println("Задача 7");
//        В сутках 1440 минут
        int hourCounter=0;
        int sym, minutes, hours;
        for (int i=0; i<1441; i++){
            minutes=i%60;
            hours=i/60;
            sym=minutes%10*10+minutes/10;
            if (hours==sym) hourCounter++;
        }
        System.out.println("Количество симметричных комбинаций: " + hourCounter);
        System.out.println();
    }
}
