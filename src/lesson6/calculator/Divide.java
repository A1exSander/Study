package lesson6.calculator;

public class Divide extends Operation {
    @Override
    void execute(int a, int b) {
        if (b!=0) {
            System.out.println(a/b);
        } else {
            System.out.println("Деление на 0 не получится");
        }
    }
}
