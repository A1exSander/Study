package lesson1Homework;

public class SQRT {
    public static void main(String[] args) {
        double a=12,b=7,c=1, disc,x=0,x2=0;
        // Присваиваю ноль как индикатор отсутствия корней
        disc=b*b-4*a*c;
        x = (disc==0) ? -b/(2*a) : (disc>0) ? (-b+Math.sqrt(disc))/(2*a) : x;
        x2 = (disc>0) ? (-b-Math.sqrt(disc))/(2*a) : (disc==0) ? x : x2;
        System.out.println("Корни уравнения:");
        System.out.println(x);
        System.out.println(x2);
        System.out.println("Если x1=x2=0, то с=0 или корней не существует");
    }
}
