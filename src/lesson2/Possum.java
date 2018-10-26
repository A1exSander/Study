package lesson2;

import java.util.Scanner;

public class Possum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите трехзначное число");
        int code = in.nextInt(); //123
        if (code == 123) {
            System.out.println("Угадал");
        } else if (code == 321) {
            System.out.println("Почти");
        }
        else {
            System.out.println("Не угадал");
        }
        //-----------
        int a = 5;
        int b = 7;
        if (a==5) {
            System.out.println("Совпадение найдено: a");
        } else if (b==7) {
            System.out.println("Совпадение найдено: b");
        } else {
            System.out.println("Совпадений нет");
        }
        //------------ switch(оператор выбора)
        // Гран при 555555
        // Средн 444444 333333
        // Утешительный 111111 000000
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите шестизначный номер");
        int userTicketNum= in2.nextInt();
        String prize;
        final int num = 555555; //Константа. В кейсах нельзя использовать переменные
        switch(userTicketNum) {
            case num:
                prize = "Гран при";
                break;
            case 444444:
            case 333333:
                prize="Второй приз";
                break;
            case 1111111:
            case 0000000:
                prize="Третий приз";
                break;
            default:
                prize ="Водокачку";
        }
        System.out.println("Вы выиграли " + prize);


        //--------------
        //Циклы While, do-while
//        while (Условие){}
        int messageCount=5;
        while (messageCount>0) {
            System.out.println("Сообщение № "+messageCount);
            messageCount--;

        }
        Scanner in3;
        System.out.println("Введите код. Трехзначное число");
        int  code2;
        while (true)

    {

        in3 = new Scanner(System.in);
        code2 = in3.nextInt();
        if (code2 == 123) {
            System.out.println("Вы вошли как администратор");
            in3.close();
            break;
        } else if (code2 == 312) {
            System.out.println("Вы вошли как ученик");
            in3.close();
            break;
        } else {
            System.out.println("Повторите попытку");
        }
    }

        //---------
        //do while
        do{
            System.out.println("Первая итерация");
        } while (false);
        //------------
        // цикл for
        // for (инициализация; проверка условия; шаг) {тело цикла}
        // вывести все числа от 1 до 11
        for (int i=1; i<11; i++) {
            if (i%2==0) System.out.println("i = " + i);
        }
        for (int i=1; i<11; i++) {
            if (i % 2 == 0)  continue;
                System.out.println("i = " + i);
        }
        for (int i = 0; i<3; i++) {
            System.out.println("Внещний цикл I = " + i);
            for (int j =0; j<15; j++){
                System.out.println("Внутренний цикл J = " + j);
                if (j == 5) break;
            }
        }
        outer: for (int i = 0; i<3; i++) {   //outer - пользовательская метка. Название придумать самому
            System.out.println("Внещний цикл I = " + i);
            for (int j =0; j<15; j++){
                System.out.println("Внутренний цикл J = " + j);
                if (j == 5) break outer;     //Прерывает в метке
            }
        }

    }
}
