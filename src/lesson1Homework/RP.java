package lesson1Homework;

public class RP {
    public static void main(String[] args) {
        double a=5,b=3,c=2,s,max;
        s=2*(a*b + b*c + a*c);
        max=(a>=c) ? a : c;
        System.out.println("Площадь равна:");
        System.out.println(s);
        System.out.println("Наибольшая сторона");
        System.out.println(max);

    }
}
