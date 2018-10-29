package lesson6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {
    public static void main(String[] args) {
        String string = "Строка 1 для поиска и замены Символов_ё";
        //рег выражение: символ совпадает с самим собой
        String pattern = "иск";
        //Шаблон. Последовательность символов должна соответствовать ему, кроме случаев с мета-символами и спец. символами
        System.out.println(string.replaceAll(pattern, "*!*"));
        pattern = "^Стр$"; //Вся строка олжна быть таковой
        //"^"-начасло строки. Любой символ, следующий за этим, должен быть в начале строки.
        //"$"-конец строки
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "[иск]"; // [] - символы на выбор (логическое или) - все будут заменены
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "[^иск]"; // Все символы кроме перечисленных
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\d"; // цифровой символ
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\D"; // любой нецифровой символ
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\w"; // буквенно-цифровой символ или "_"
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\W"; // не w
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\s"; // любой пробельный символ (отступы, переносы строки)
        System.out.println(string.replaceAll(pattern, "*!*"));

        pattern = "\\S"; // Не пробельный символ
        System.out.println(string.replaceAll(pattern, "*!*"));

//можно объединять

        pattern = "[а-я,ё]"; // "-" - указывает диапазон
        System.out.println(string.replaceAll(pattern, "*"));

        pattern = "[А-Я][0-9]"; // не сработает, т.к. ищет два символа подряд
        System.out.println(string.replaceAll(pattern, "*"));

        pattern = "[А-Я0-9]"; // сработает, условия указываются без пробелов
        System.out.println(string.replaceAll(pattern, "*"));

        pattern = "[А-Я,0-9,а-я]"; // альтернативный способ записи
        System.out.println(string.replaceAll(pattern, "*"));

        pattern = "[А-Я,0-9,а-я]"; // альтернативный способ записи
        System.out.println(string.replaceAll(pattern, "*"));

//        Pattern - составляет шаблон/ Matcher - работает с результатами
        string = "String B 1 to sreach and replace CHARS _%#@";
        Pattern pattern1 = Pattern.compile(".{6,}"); //"." - любой символ в строке, в фигурных скобках - количество повторений символа подряд
        // .{6,} - от шести повторений любого символа подряд (т.е. 6 любых символов подряд)
        Matcher matcher = pattern1.matcher(string);
        System.out.println(matcher.find()); //True-false на соответствие строки шаблону
        pattern1 = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
        //?= - ищется совпадение,
        //* - означает, что символ повторяется от нуля до ..
        System.out.println(matcher.find()); //True-false на соответствие шаблона строке (ищет кусок как ИЛИ)
        System.out.println(matcher.matches()); //True-false True при полном соответствии шаблону (жесткое условие И)
        //при использовании спец. символов, если нужны сами символы, то использовать \\
        // | - вертикальная черточка - логическое или. Например [a|b]
    }
}
