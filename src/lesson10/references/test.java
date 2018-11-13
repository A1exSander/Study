package lesson10.references;

public class test {
    public static void someVoid2() {
        int a = 12;

    }
    public static void someVoid() {
        int a = 90;
        someVoid2();

    }
    public static void main(String[] args) {
        someVoid();
    }
}
