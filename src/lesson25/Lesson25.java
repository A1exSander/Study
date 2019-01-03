package lesson25;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Lesson25 {
    public static void main(String[] args) throws IOException {
        Integer[] arr = {55, 23, 3, 40, 55,80};
        List list = new ArrayList<>(Arrays.asList(arr));
//        list.stream().filter(s->s>20).distinct().map(s->s+10).sorted().forEach(System.out::println);

        Optional<Integer> optional = Stream.of(1,2,3,6).filter(s->s<5).findFirst();

        Integer i = optional.orElse(0);

        String res = Stream.of("asdas", "dsdsdsd", "ledwdsa").reduce("", (k,j) -> k+j);
        Integer res1 = Stream.of(1, 2, 3).reduce(0, (k,j) -> k+j);
        System.out.println(res);
        System.out.println(res1);

        File file = new File("wp.txt");

        //top 10
        Map<String, Long> top =
                // Получили стрим из файла
                Files.lines(file.toPath())
                //указываем, чьто стрим должен быть параллельным
                .parallel()
                //Убираем знаки препинания
                .map(line->line.toLowerCase().replaceAll("\\pP", " "))
                // каждую строку разбиваем на слова
                .flatMap(line->Arrays.stream(line.split(" ")))
                // Обрезаем пробелы
                .map(String::trim)
                // Убираем невалидные слова
                .filter(word->!"".equals(word))
                // Создаем коллекцию из слов и счетчикаов
                .collect(groupingBy(identity(), counting()))
                .entrySet().parallelStream()
                .sorted((e1, e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(top);

        // Подсчет количества вхождений the

        Stream<String> stringStream =
                Files.lines(file.toPath())
                        //указываем, чьто стрим должен быть параллельным
                        .parallel()
                        //Убираем знаки препинания
                        .map(line->line.toLowerCase().replaceAll("\\pP", " "))
                        // каждую строку разбиваем на слова
                        .flatMap(line->Arrays.stream(line.split(" ")))
                        // Обрезаем пробелы
                        .map(String::trim)
                        // Убираем невалидные слова
                        .filter(word->!"".equals(word));

//        Long count = stringStream.filter("the"::equals).count();
//        System.out.println(count);

        // выбрать все элементы, содержашие the

        List<String> listRes = stringStream.filter((s)->s.contains("the")).collect(Collectors.toList());

        System.out.println(listRes);

        // Выбрать пользователей в возрасте от 18 до 40
        // Найти максимаотный возвраст
        // Найти средний возраст

        User user1 = new User("Вася", 23);
        User user2 = new User("Петя", 12);
        User user3 = new User("Биба", 99);
        User user4 = new User("Боба", 39);
        User user5 = new User("Настя", 21);
        User user6 = new User("Костя", 7);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        List<User> adults = new ArrayList<>();
        userList.stream().filter(user -> user.getAge()<40 && user.getAge()>18).forEach(System.out::println);
        IntSummaryStatistics userStats = userList.stream().collect(Collectors.summarizingInt(s->s.getAge()));
        System.out.println(userStats.getMax());
        System.out.println(userStats.getAverage());
        userList.stream().mapToInt(User::getAge).average().getAsDouble();

        // Отсортировать сначала по возрасту, потом по имени
        // Преобразовать в map
        System.out.println(Arrays.stream(arr).filter(num->num%2==1).reduce(0, (k,j)->k+j));

        System.out.println(userList.stream().allMatch(user -> user.getName().contains("w")));

    }
}

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
