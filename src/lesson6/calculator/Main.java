package lesson6.calculator;

public class Main {
    public static void main(String[] args) {
        int a = 9;
        int b = 2;
        Operation plus = new Plus();
        plus.execute(a, b); //10

        Operation minus = new Minus();
        minus.execute(a, b);

        Operation divide = new Divide();
        divide.execute(a, b);

        Operation multiply = new Multiply();
        multiply.execute(a, b);
    }
}
