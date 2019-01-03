package lesson22;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SomeClass {
//    Чтение и запись всегда будут атомарными
//    Чтение всегда вернет актуальное значение из памяти (для волатильных переменных и объектов)
    private static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new SomeThread().start();
        }

        Thread.sleep(3000);
        run=false;
    }

    private static class SomeThread extends Thread {
        @Override
        public void run(){
            while (run) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    run = false;
                    e.printStackTrace();
                }
            }
        }
    }

//    Многопоточные коллекции

//    Изначальные потокобезопасные коллекции:
//    Vector
//    Hashtable
//    Stack
//    StringBuffer

//    Однопоточные коллекции плюс декораторы
//    List<String> list = Collections.synchronizedList(new ArrayList<>());
//    Set<String> set = Collections.synchronizedSet(new HashSet<>());
//    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
//    Коллекции выше низкопроизводительны (хреновы, короче)

//    java.util.concurrent. - java 1.5
//    Многопоточные коллекции:
//    Итерфейс ConcurrentMap - чтение и запись всегда будут атомарны
//    Операция чтения не требует блокировки
//    Операции записи могут происходить без блокировки

//    putIfAbsent(key, val) - Добавляет значение val по ключу, если это значение отличается
//    remove(key, val) - Удаляет ключ и значение из Map, если они совпадают с существующими
//    replace(key, oldValue, newValue) - заменяет старое значение на новое (если key и oldValue соответствуют находящимся в мапе)

//   Реализации Concurrent
//   ConcurrentHashMap - Блокировка для записи происходит на уровне сегментов
//   ConcurrentSkipListMap (Skip List алгоритм)
//   ConcurrentSkipListSet (тот же алгоритм)
//   CopyOnWriteList - интерфейс для коллекций ниже
//   CopyOnWriteArrayList - Для ситуаций, когда много читающих потоков и мало записывающих
//   CopyOnWriteArraySet - Аналогично

//   Interface BlockingQueue - блокирующие очереди (интерфейс однонаправленной очереди)
//   Вставка:
//   add(o) - Добалвение в очередь. Выбросит исключение, если некуда вставить данные (очередь полна)
//   offer(o) - Тоже добавлегние. В случае, если некуда добавить, false
//   put(o) - Тоже добавление. Если некуда вставить элемент, поток будет заблокирован до освободившегося места
//   Удаление:
//   remove() - выбросит исключение, если очередь пуста (иначе удалит крайний элемент)
//   poll() - аналогичен offer, но для удаления
//   take() - блокирует поток, пока не появится элемент для удаления

//   Interface BlockingDeque - интерфейс для двунаправленных очередей

//    ArrayBlockingQueue(фиксированный размер очереди)
//    В конструкторе необходимо обязательно передать размер
//    new ArrayBlockingQueue(int capacity)
//    new ArrayBlockingQueue(int capacity, boolean fair) - флаг оптимизирует работу с потоками (при полном списке
//    приоритет на запись, при пустом на чтение). По умолчанию true
//    new ArrayBlockingQueue(int capacity, boolean fair, Collection collection) - создает очередь элементов
//    для работы потоков на основе коллекции

//    LinkedBlockingQueue() - размер фиксирован Integer.MAX_VALUE (почти неограничен
//    LinkedBlockingQueue(nt capacity)
//    LinkedBlockingQueue(Collection collection) - создает на основе коллекции

//    SynchronousQueue - каждая операция добавления будет ждать операции удаления (вместо списка буфер на 1 элемент)

}

// 1. Что если задать в метод toArray в ArrayBlockingQueue массив меньшего размера, чем размер очереди?
// 2. Что если добавить null в очередь?
// 3. Каков размер синхронизированной очереди?