package lesson12;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User user = new User(2, "Миша");
        System.out.println(user.hashCode());

//        Map
//        Это интерфейс со структурой наддых, который позволять хратить инфу в паре "клю-значение
//        Null может быть ключом, но чаще всего нет.
//        Ключи не дублируются
        //Nill может быть в качетве ключа с это йел=оизаци
//        Хранение зависит от реализации

//       Реализация Map:
//boolean containsKey(Object key);
//boolean containsValue(Object key);
//void putAll (Map<Map < 2 extends L, ?extends v>)m;
//get(Object key)l put()
//put (T, key);
////        Object val;
////        get (ti Jey,T val)
//        //HashMap
////
////        EnumMap
////         Tree map
////        LinkedHashMap
////        WeakHashMap
//        IdentityHashMap
        Map<Integer, String> hashMap= new HashMap<>();
        hashMap.put(1,"Elem1");
        hashMap.put(2,"Elem2");
        hashMap.put(2,"Elem3");
        hashMap.put(null,"Elem3 null");
        System.out.println(hashMap);
    //    System.out.println(hashMap.get(1));
        //Перебрать элементы map
        for (Map.Entry entry: hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }


        //linkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"Elem1");
        linkedHashMap.put(2,"Elem2");
        linkedHashMap.put(2,"Elem3");
        linkedHashMap.put(null,"Elem3 null");
        System.out.println(linkedHashMap);
        //Работает медленнее. Использовать только если важен порядок элементов

        //treeMap
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2,"Elem1");
        treeMap.put(1,"Elem2");
        treeMap.put(2,"Elem3");
       // treeMap.put(null,"Elem3 null"); - не умеет хратить null
        // Сортирует по возрастанию ключей
        System.out.println(treeMap);
    // Бинарное дерево
//    1. корень - самый верхний узел
//    2. систья - узлы без потомков
//    3. Значение левого потомка должно быть меньше родителя
//    4. Значение правого потомка должно быть больше родителя

//        красно-черное бинарное дерево
//        1. Корень и листья всегда черные
//        2. Каждый красный узел имеет 2 черных потомка        \
//        3. Все пути от узла (корня) до листьев должны иметь одинаковое количество черных узлов

        User user1 = new User (3, "Mike");
        User user2 = new User (2, "Saul");
        User user3 = new User (1, "Walter");

        Map<Integer, User> userTreeMap = new TreeMap<>();
        userTreeMap.put(1, user1);
        userTreeMap.put(2, user2);
        userTreeMap.put(3, user3);
        System.out.println(userTreeMap);

        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        System.out.println(treeSet);

        Map<Integer, String> hashMap2= new HashMap<>();
        hashMap2.put(1,"Elem1");
        hashMap2.put(3,"Elem3");
        hashMap2.put(7,"Elem7");
        hashMap2.put(10,"Elem10");
        hashMap2.put(23,"Elem13");
        hashMap2.put(4,"Elem4");
        hashMap2.put(8,"Elem8");
        System.out.println(hashMap2);

        TreeMap<Integer, String> treeMap1 = new TreeMap<>(hashMap2);
        System.out.println(treeMap1);



    }

}
