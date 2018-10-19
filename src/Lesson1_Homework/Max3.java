package Lesson1_Homework;

public class Max3 {
    public static void main(String[] args) {
        int max=0, a=123;
        max = (a%100/10>=a%10) ? a%100/10 : a%10;
        max = (a/100>max) ? a/100 : max;
        System.out.println("Наибольшая цифра:");
        System.out.println(max);
    }
}
