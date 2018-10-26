package lesson3;

import java.util.Arrays;

public class Kiwi {
    public static void main(String[] args) {
//        //Массивы
//        //Нумерация начинается с нуля. Инструментарий по массивам занесен в класс Arrays
//        int[] array1; // объявление массива
//        int array2[]; // Второй способ объявить массив. Разницы нет
//        array1 = new int[12];
//
//        System.out.println(Arrays.toString(array1)); //вывести весь массив на экран. Синтаксим: ИмяКласси.ИмяМетода
//        System.out.println(array1.length); //длина массива
//        int a=90;
//        int[] array3 = {2, 12, 45, 78, 34, a};
//        System.out.println(Arrays.toString(array3));
//        System.out.println(array3.length);
//
//        //Доступ к элементам массива
//        System.out.println(array3[2]); // 45
//        //Индекс массива - числа типа int, так же можно использовать выражения: array3[3+2]
//        //Ctrl+D - копирование выделенной строки
//
//        array3[1]=123;
//        System.out.println(Arrays.toString(array3));
//
//        //Заполнение в цикле
//        for (int i = 0; i<array1.length; i++){
//            array1[i] = i+10;
//        }
//        System.out.println(Arrays.toString(array1));
//
//        // копирование массива
//        int[] array4 = {2, 6, 8, 3, 8, 3};
//        int[] array5 = array4; // Так не создается новый массив в памяти - добавляется вторая ссылка. Также при изменении будет меняться для обеих ссылок
//
//        int[] cloneArray4 = array4.clone(); // Фактическое создание нового массива-копии
////        System.arraycopy(srcArr, int srcPos, destArr, int destPos, int length); - исжодный массив, стартовый индекс, массив назначения. стартовый индекс нового массива, количество элементов для копирования
//        int[] array6 = new int[10];
//        System.arraycopy(array4, 0, array6, 2, 1);
//        System.out.println(Arrays.toString(array6));
//
//        int[] copyArray4 = Arrays.copyOf(array4, 3); //Создает новый массив указанной длины, заполняет тем, что есть
//        System.out.println(Arrays.toString(copyArray4));
//
//        int[] copyRangeArray4 = Arrays.copyOfRange(array4, 1, 3); // Тоже создает массив, но с указанием номера начала и конца ВАЖНО: i>=1 && i<3
//        System.out.println(Arrays.toString(copyRangeArray4));
//
//        array4 = new int[] {2, 6, 8, 3, 8, 3, 98}; //объявление нового массива под старым названием
//
//
//        //перебор значений массива в цикле
//        for (int i = 0; i<array4.length; i++){
//            array4[i] +=100;
//        }
//        System.out.println(Arrays.toString(array4));
//
//        for (int num:array4) { //перебор массива по всей длине, num - значение текущего элемента массиваб невозможно изменить элементы массива
//            System.out.println(("num = " + num));
//            num += 100; // не сработает - переменная перезаписывается при каждой новой итерации
//        }
//        System.out.println(Arrays.toString(array4));
//
//        //Сравнение массивов
//        array4 = new int[] {2, 6, 8, 3, 8, 3, 98};
//        array5 = new int[] {2, 6, 8, 3, 8, 3, 98};
//        System.out.println(array4 == array5); // false, не работает (но массивы равны)
//        System.out.println(array4.equals(array5)); // false, не работает. Предназначен для сравнения объектов.
//
//        System.out.println(Arrays.equals(array4, array5)); // true, работает. Предназначен специально для работы с массивами

        int[] array7 = new int[14];
        Arrays.fill(array7, 233); // Наполняет весь моссив указаннымы одинаковыми значениями
        System.out.println(Arrays.toString(array7));

        array7 = new int[] {34, 1, -90, 45, 72};
        Arrays.sort(array7, 1, 4); //сортировка массива или его части по возрастанию
        System.out.println(Arrays.toString(array7));
        Arrays.sort(array7);
        System.out.println(Arrays.toString(array7));

        System.out.println(Arrays.binarySearch(array7, -90)); // поиск элемента (ключа) в массиве. Если вернет отрицательное значение, то такого элемента нет, но вернет индекс, где число могло бы быть в массиве (редко используется)

    }
}
