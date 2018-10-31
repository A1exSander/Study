package lesson7.anonymous;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc (3, 1);
        calc.summ(new Operation() { // анонимный класс. Он должен либо наследоваться от другого, либо реализовывать интерфейс
            @Override
            public double apply(double var1, double var2) {
                return 0;
            }
        });
    }

}
