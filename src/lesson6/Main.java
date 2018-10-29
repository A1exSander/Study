package lesson6;

import lesson6.battleUnit.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(100, 20);
        Spearman spearman = new Spearman(60, 70);

        knight.attack(spearman);

        Doctor doctor = new Doctor(50, 10);
        doctor.attack(knight); // будет использовать базовый attack из BattleUnit

        // Абстрактный класс - в котором есть методы нереализованные и реализованные

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название персонажа");
        String userChoice = scanner.nextLine();


        BattleUnitFactory unitFactory = new BattleUnitFactory();
        BattleUnit unit = unitFactory.create(userChoice);
//        if (userChoice.equals("knight")) {
//            unit = new Knight(100, 20);
//        } else if (userChoice.equals("spman")) {
//            unit = new Spearman(70, 40)
//        } else {
//            unit = new Doctor(20, 40);
//        }

        Fight fight = new Fight(unit, spearman);
        fight.fight();
        System.out.println(fight.fightResult());
//
//        Парадигмы ООП:
//        Абстракция; - создание шаблонов для использования в других классах
//        Инкапсуляция; - private, secure (скрытие переменных, необходимых только внутри класса)
//        Полиморфизм; - Когда можно создать внутри одного класса несколько методов с одним названием, но разными аргументами
//        Или создаем объекты, используя общий родительский класс
//        Наследование; - расширение функционала какого-либо класса с помощью нового (extends)
//
//        Посылка сообщений
//        Повторное использование - повторно использовать классы можно только если они независимы друг от друга
    }
}