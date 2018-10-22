package Lesson3;

import java.util.Arrays;

public class LessonStrings {
    public static void main(String[] args) {
//        //Работа со строками
//        String str = "String";
//        String str2 = new String("String");
//        String str4 = "String String";
//        String str5 = "String";
//        String str6 = "string";
////        "String".length(); - можно использовать строки и вычислять их длину без занесения в переменную
////        String str3 = String.format("String %02d", 8); - жрет много ресурсов, применяется редко
////        System.out.println(str3);
//        System.out.println(str == str2); //false
//        System.out.println(str == str5); //true так как повторное объявление, как и с массивами, новуб строку не создает
//        System.out.println(str.equals(str2));
//        System.out.println(str.equals(str5)); // Сравнение содержимого строк посимвольно
//
//        System.out.println(str.equalsIgnoreCase(str6)); //сравнение строк без учета регистра
//        System.out.println(str.equals(str6));
//
//        System.out.println(str.startsWith("Qqwe")); // Начинается ли строка с этой комбинации символов
//        System.out.println((str.endsWith("ng"))); // Оканчивается ли строка этой комбинацией символов
//
//        String str10 = "string";
//        String str11 = new String("string");
//        String str12 = "str";
//        String str13 = "String string";
//
//        System.out.println(str10.compareTo(str11)); // Возвращает 0, если строки равны
//        System.out.println(str11.compareTo(str12)); // Если вызывающая строка больше аргумента, то результат будет положителен
//        System.out.println(str11.compareTo(str13)); // Если меньше, результат отрицательный
//        //На самом деле не больше-меньше, а раньше-позже где? (Лексикографический анализ? Погуглить)
//
//        System.out.println("string".compareToIgnoreCase("String string")); //ненулевой результат не используется на практике. Только факт ==0 ли !=0
//
//        int compareRes = str11.compareTo(str12);
//
//        if (compareRes == 0){
//            System.out.println("==");
//        }
//        String a = "Astring";
//        String b = "Bstring";
//        String c = "Строка \n \"Строка\"";
//
//        String[] strArr = {c, a, b};
//        Arrays.sort(strArr); //Сортировка строки как массива (по коду символа)
//        System.out.println(Arrays.toString(strArr));
//
//        System.out.println(a.substring(3, 5)); //Взятие подстроки начиная с символа под указанным номером до указанного вторым номером
//        //В строках можно использовать спец. сиволы: \n - перенос строки, \"строка\" - показывают кавычки, \ - экранирует последующий элемент
//
//        System.out.println(a.contains("str")); //Возвращает TRUE если подстрока в искомой строке найдена
//
//        String[] arr = {"qwe", "rty", "yui"};
//        System.out.println();

        String string = "First ";
        String string2 = "Second ";
        string2 +=string;  //объединение строк
        System.out.println(string2);

        for (int i = 0; i<10; i++){
            string+=string2; // Не следует использовать для сложных строк (каждый раз создается новая строка - жрется память)
        }
        System.out.println(string);

        // StringBuffer || StringBuilder - позволяют менять строки, не создавая новые
        // StringBuilder - производительнее, но не работает в потоках
        // StringBuffer - используется для потоков

        StringBuilder stringBuilder = new StringBuilder(); //создание нового объекта для работы с StringBuilder
        stringBuilder.append(string); //добавляет строку

        for (int i=0; i<10; i++) {
            stringBuilder.append(" string ").append(" str ");
        }
        System.out.println(stringBuilder.toString());



    }
}
