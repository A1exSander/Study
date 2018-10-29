package lesson6.calculator;

public class Minus extends Operation{
    @Override
    void execute(int a, int b) {
        System.out.println(a-b);
    }
}
