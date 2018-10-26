package lesson2Homework;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
//      Задача 1*
//      В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
//      Создать программу, которая переставит числа в переменных таким образом,
//      чтобы при выводе на экран последовательность a, b и c оказалась строго возрастающей.
//
//      Числа в переменных a, b и c: 3, 9, -1
//      Возрастающая последовательность: -1, 3, 9
//
//      Числа в переменных a, b и c: 2, 4, 3
//      Возрастающая последовательность: 2, 3, 4
//
//      Числа в переменных a, b и c: 7, 0, -5
//      Возрастающая последовательность: -5, 0, 7
        final int a=1, b=5, c=-10;
        int first=a, second=b, third=c;
        System.out.println("Задание 1");
        if (b>c) {
            second=c;
            third=b;
        }
        if (a>third) {
            first = second;
            second=third;
            third = a;
        } else if(a>second) {
            first = second;
            second = a;
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
        System.out.println("Задание 4");
        System.out.println("Введите натуральное число");
        Scanner num = new Scanner(System.in);
        int number= num.nextInt();
        int j=0, div=6;
        if (number % 2==0) j = 1;
        if (number % 3==0) j = 1;
            while ((j != 1) && ((div-1) * (div-1) <= number)) {
                if (number % (div-1) == 0) j = 1;
                if ((div+1)*(div+1) > number) break;
                if (number % (div+1)==0) j = 1;
                div = div+6;
            }
        if (j==0) System.out.println("Число простое");
        else System.out.println("Число составное");
        System.out.println();


//        Задача 5
//        Выведите на экран первые 11 членов последовательности Фибоначчи.
//        Первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
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
        for (int i=0; i<1440; i++){
            minutes=i%60;
            hours=i/60;
            sym=minutes%10*10+minutes/10;
            if (hours==sym) hourCounter++;
        }
        System.out.println("Количество симметричных комбинаций: " + hourCounter);
        System.out.println();


//        Задача 8*
//        Есть три вершины X, Y, Z.
//        Их координаты (x1, x2), (y1, y2), (z1, z2) заданы как целые числа.
//        Нужно определить - является ли треугольник с заданными координатами прямоугольным.
        System.out.println("Задание 8");
        int x1=0, x2=0, y1=3, y2=0, z1=0, z2=4;
        double len1, len2, len3;
//        Ищем длины сторон
        len1=Math.abs(Math.sqrt((x1-y1)*(x1-y1)+(x2-y2)*(x2-y2)));
        len2=Math.abs(Math.sqrt((y1-z1)*(y1-z1)+(y2-z2)*(y2-z2)));
        len3=Math.abs(Math.sqrt((z1-x1)*(z1-x1)+(z2-x2)*(z2-x2)));
//        Применяем теорему Пифагора
        if (len1*len1==(len2*len2 + len3*len3) || len2*len2==(len1*len1 + len3*len3) || len3*len3==(len2*len2 + len1*len1)) {
            System.out.println("Треугольник прямоугольный");
        } else System.out.println("Треугольник не прямоугольный");
        System.out.println();


//        Задача 9*
//        Задать количество тарелок и количество моющего средства.
//        Моющее средство расходуется из расчета 0,5 на одну тарелку.
//        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки
//        В конце вывести, сколько тарелок осталось, когда моющее средство закончилось или наоборот.
        System.out.println("Задание 9");
        int plates=17;
        double fairy=9;
        while (fairy>=0.5 && plates>0) {
            plates--;
            fairy=fairy-0.5;
            System.out.println("Тарелка вымыта! Осталось средства для мытья посуды: " + fairy + "мл");
        }
        if (fairy<0.5 && plates>0) System.out.println("Средства не хватило. Осталось немытых тарелок:" + plates);
        else if (fairy==0 && plates==0) System.out.println(("Посула вымыта, и средство как раз закончилось"));
        else System.out.println("Ура! Тарелки чистые, и на новую помывку хватит. Осталось " + fairy + "мл посудомоечного средства");

    }
}

