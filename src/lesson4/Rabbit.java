package lesson4;

import java.util.Arrays;

public class Rabbit {
    public static void main(String[] args) {
        //Не монструозное решение задачи с вытаскиванием чисел
        String str = "дом 48, корпус 9, парадная 7, этаж 4";
        String[] strArr = (str.replaceAll("\\D+", " ").trim().split(" "));
        System.out.println(Arrays.toString(strArr));

        //Классы и объекты
        //public - класс только один, другие не могут быть публичными, но их можно сделать много в одном файле
        //Правила именования: src.com.companyName.projName.projPackajes.ProjClass (перевернутый домен, название компании, название проекта, все остальное
        //Не использовать "_" в названиях, пакеты с маленькой буквы, классы с большой
    }
}
