package Lesson1_Homework;

public class Mortgage {
    public static void main(String[] args) {
        double ammount=3000000, percentage=6, years=20, overpayment;
        overpayment=ammount*percentage/100*years;
        System.out.println(overpayment);
    }
}
