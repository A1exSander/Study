package lesson11;


import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        // Java Collection Framework
        // Главный интерфейс - Collection
        // java.util.Collection
        // Основные методы:
//        boolean add(E e);
//        boolean remove(Object o);
//        int size();
//        boolean isEmpty();
//        boolean contains(Object o);

//        Object[] toArray[]; - преобразование коллекции в массив через объект
//        <T> T[] tpArray(T[] a); - через Generic
//        String[] arr = collectionName.toArray(new String[0]);
//        iterator() - ходит (перебирает) по элементам коллекции

//        java.util.List - нтерфейс коллекций-списков, наследуется от Collection
//        Может включать одинаковые элементы (не все коллекции это могут), хранятся в порядке добавления
//        Получить доступ к любому элементу списка можно по номеру
//        void add(int ind, E object); - добавляет элемент в список на позицию ind
//        boolean addAll(int ind, Collection<? extends E> col) - добавляет коллекцию целиком на позицию
//        E get(int ind); - позволяет найти элемент в списке
//        int indexOf(Object o); - овзвращает индекс элемента
//        int lastШndexOf(Object o); - как и предыдущий, ищет вхождение элемента в коллекцию
//        E remove(int ind); - удаляет элемент с позиции ind
//        E set(int ind, E obj) - вставка элемента в список с заменой
//        List<E> subList(int start, int end); - получает набор элементов со start до end (создает новый подсписок)

//        java.util.Set - еще один подинтерфейс коллекций. Может хранить только уникальные значения в отличие от Collection  List
//        Также может менять порядок хранения элементов в коллекции


//        ArrayList - класс, реализующий интерфейс List и является димамически расширяющимся массивом. Также является Дженериком
//        (может хранить любые объекты и null)
        ArrayList<String> strList = new ArrayList<>();

//        strList.ensureCapacity() - метод, уплавляющий размером списк, ;
//        strList.trimToSize();(); - уменьшает размер списка до количества элементов в нем.

        strList.add("Elem 1");
        strList.add("Elem 2");
        strList.add(0, "Elem2");

//        strList.remove(1); можно удалить по индексу(или по значению)
//        strList. remove(значение)

        String[] arr1 = strList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr1));

        System.out.println(strList.toString());

        Integer[] integers = {23, 67,12,90};
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(integers));
        System.out.println(intList.toString());

        for (Integer i: intList){
            System.out.println(i);
        }
//        Перебор элементов списка через итетарор
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator" + iterator.next());
            if (iterator.next() == 12) {
                iterator.remove();
//                - удалить элемент на итерации

            }

        }
        System.out.println(intList.toString());

//        LinkedList - связные списки. Тоже подкласс List. В них вставка в список и поиск работает быстрее. ArrayList работает быстрее, но этой функции у него нет за адекватную скорость
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("String 1");
        stringLinkedList.add("String 2");
        stringLinkedList.add("String 3");
        stringLinkedList.add(1, "String 4");

        for(String str: stringLinkedList) {
            System.out.println(str);
        }

        // удаление элементов
//
//        stringLinkedList.poll(); // null или элемент
//        stringLinkedList.pollFirst(); // null или элемент
//        stringLinkedList.remove(); // NoSuchElementException (в отличие от poll можно передать индекс и тогда он удалит элемент по индексу)
//        stringLinkedList.removeFirst(); // NoSuchElementException
//
        // Удаление первого элемента списка (выше)

        String[] arr = stringLinkedList.toArray(new String[0]); // Лучший вариант создания массива из коллекции
        System.out.println(Arrays.toString(arr));

        // Класс HashSet - наиболее быстрая реализация
        // Интерфейс SortedSet - > Класс TreeSet (Самый медленный) - элементы хранятся в порядке возрастанния независимо
        // от порядка заполнения
        // Класс LinkedHashSet - позволяет хранить элементы в порядке добавления (быстр, но не так быстр как HashSet)
        // Все классы выше не могут хранить дублирующиеся элементы, хранятся не в том порядке, в котором добавлялись элементы

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");
        hashSet.add("Element 3");

        System.out.println(hashSet.toString());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Element 2");
        treeSet.add("Element 1");
        treeSet.add("Element 3");

        System.out.println(treeSet.toString());

        LinkedHashSet<String> linkedHashSet= new LinkedHashSet<>();

        linkedHashSet.add("Element 2");
        linkedHashSet.add("Element 1");
        linkedHashSet.add("Element 3");

        System.out.println(linkedHashSet.toString());


    }
}
