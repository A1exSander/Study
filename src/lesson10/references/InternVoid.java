package lesson10.references;

public class InternVoid {
    public static void main(String[] args) {
        String str = "String";
        String str2 = "String";

        System.out.println(str.intern() == str2.intern()); // сравнение значений строк
        System.out.println(str == str2);
    }
}
