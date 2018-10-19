package Lesson1_Homework;

public class SQRT {
    public static void main(String[] args) {
        double a=12,b=7,c=1, disc,x=0,x2=0;
        // Присваиваю ноль как индикатор отсутствия корней. Да-да, если с=0, то это и будут корни, но без условного оператора не знаю, как сделать лучше
        disc=b*b-4*a*c;
        x = (disc==0) ? -b/(2*a) : (disc>0) ? (-b+Math.sqrt(disc))/(2*a) : x;
        x2 = (disc>0) ? (-b-Math.sqrt(disc))/(2*a) : x2;
        System.out.println(x);
        System.out.println(x2);
    }
}
