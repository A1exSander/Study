package lesson4Homework.task1;


//Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
//Все фигуры должны иметь методы, которые возвращают площадь и периметр
//(для окружности - длина окружности).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Figures cir = new Figures(0,0, 5, 0);
        Figures rect = new Figures(0, 0, 1, 0, 1, 1, 0, 1);
        Figures tri = new Figures(0, 0, 1, 0, 1,1);


        System.out.println("Периметр треугольгника: " + tri.getPerimeterT());
        System.out.println("Периметр прямоугольника: " + rect.getPerimeterR());
        System.out.println("Длина окружности: " + cir.getPerimeterR());

        System.out.println("Площадь треугольника: " + tri.getSpaceT());
        System.out.println("Площадь прямоугольника: " + rect.getPerimeterR());
        System.out.println("Площадь круга: " + cir.getPerimeterC());

    }
}
