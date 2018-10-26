package lesson1Homework;

public class Closest_Num {
    public static void main(String[] args) {
        double m=-7, n=-12, c;
        c=(Math.abs(m-10)<=Math.abs(n-10)) ? m : n;
        System.out.println("Ближайшее число к 10:");
        System.out.println(c);
    }
}
