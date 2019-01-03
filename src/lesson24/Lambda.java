package lesson24;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface Operation{
    double execute(int a, int b);
}


interface ButtonFactory <T extends Button> {
    T set(String valuse, String color);
}

public class Lambda {
    private static int someVar = 12;
    public static void main(String[] args) {
        // синтаксис
//        (аргументы) -> тело;
//        ()->{
//            телож
//            наж
//            несколько строк;
//            [return возвращаемое значение;] - необязательная часть, квадратные скобки не нужны
//        }

//        (a,b)->a+b;
//        (a,b)->{
//
//
//            return a+b;
//        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });

        new Thread(()-> System.out.println("Hello Lambda"));

        Runnable runnable = ()-> System.out.println("Hello Lambda");

        new Thread(runnable);

        Operation plus = (a,b) -> a+b;
        Operation minus = (a,b) -> a-b;

        double result = plus.execute(12,23);
        result = minus.execute(12,23);

        int someLocalVar = 12;

        Operation operation = (a, b)->{ // в лямбда-выражениях не обязательно указывать тип данных переменных
            someVar -= a;
//            someLocalVar += b;

            return someVar;
        };

        // ссылка на метод через нотацию (статическую ссылку на метод)
        ButtonFactory<Button> factory = Button::new;
        Button button = factory.set("Cancel", "pink");
        System.out.println(button);

        // Предикаты
        Predicate<Integer> pos = (num)-> num > 0;
        boolean predicateRes = pos.test(4);
        Predicate<Integer> neg = (num)-> num < 0;
        predicateRes = neg.test(23);

        predicateRes = pos.or(neg).test(2);
        System.out.println(predicateRes);

        Button.tstVoid(pos, 7);

        // Функции

        Function<Integer, Integer> plusTen = (a)->a+10;

        int functionRes = plusTen.apply(4);

//        Consumer
        Consumer<Button> makeResetbtn = (button1) -> button1.setButton("Reset"); // в лямбда-выражениях можно передавать аргумент без скобок, если он один
        makeResetbtn.accept(button);
        System.out.println(button);

//        Компараторы
        Button button1 = new Button("First", "gra");
        Button button2 = new Button("Second", "gray");
        Comparator<Button> buttonComparator = (b1, b2)-> b1.getValue().compareTo(b2.getValue());
        Comparator<Button> buttonComparator2 = Comparator.comparing(Button::getValue); // то же самое

        int compareRes = buttonComparator.compare(button1, button2);
        System.out.println(compareRes);


//        forEach(лямбда)

        List<Integer> integers = new ArrayList<>(Arrays.asList(23,67,12,-12,0));
        List<Integer> integers1 = new ArrayList<>();
        integers.forEach((s)-> System.out.println(s + " "));
        integers.forEach((s)-> integers1.add(s+10));

        System.out.println(integers1);

//        removeIf()
        integers.removeIf((s)-> s< 20);
        System.out.println(integers);

//        Map.forEach()
        Map<String, String> books = new HashMap<>();
        books.put("Книга 1", "Автор 1");
        books.put("Книга 2", "Автор 2");

        books.forEach((key, value) -> System.out.println("Title: " + key + "Author: " + value));

//        Map.compute()
        books.compute("Книга 1", (key, value) -> value + " закомпучено");
        System.out.println(books);

//        computeIfAbsent()
//        computeIfPresent()
        books.computeIfAbsent("Книга 3", (value) -> value + " закомпучено ifAbsent");
        System.out.println(books);

//        Map.getOrDefault()

        String author = books.getOrDefault("Книга4", "Нет автора");
        System.out.println(author);

        System.out.println(books);

    }
}

class Button{
    private String button;
    private String value;

    public Button(String button, String value) {
        this.button = button;
        this.value = value;
    }

    public static void tstVoid(Predicate<Integer> predicate, int i) {
        predicate.test(i);
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "button='" + button + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
