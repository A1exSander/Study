package lesson21;
import java.net.StandardProtocolFamily;
import java.util.ArrayList;
import java.util.List;

public class Lesson21 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>(100);

        // Создаем потоки

        for (int i = 0; i<100; i++) {
            adderList.add(sync.new Adder());
        }

        // Запускаем потоки
        for (Sync.Adder adder: adderList) {
            adder.start();
        }

        // Ждем завершения
        for (Sync.Adder adder: adderList) {
            try {
                adder.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Вывод результата

        System.out.println("Result: " + sync.counter);
    }
}


// Общий участок памяти, который будем изменять из разных потоков
class Sync {
    int counter;

    private synchronized void increment() {
//        При синхронизации метода происходит синхранизация на текущем объекте (this)
        counter++;
    }

    public  class Adder extends Thread {
        @Override
        public void run(){
            for (int i = 0; i<100000; i++){
//                counter++;
//                Объект, на котором происходит синхронизация, находится в скобках
//                Все, что находится внутри блока, одновременно может выполнять только один поток
//                synchronized (Sync.this) {
//                    counter++;
//                }
                increment();
            }
        }
    }

}

class Storage {
    int booksCount = 0;

    public synchronized void getBook() throws InterruptedException {
        System.out.println("Get Book START");

        while (booksCount < 1) {
            wait();
        }
        booksCount--;
        System.out.println("Got a book!");
        System.out.println("Number of books left: " + booksCount);
        notify(); // notifyAll(); - разбудит все ожидающие потоки
        System.out.println("Get Book FINISH");
    }

    public synchronized void putBook() throws InterruptedException {
        System.out.println("Put Book START");

        while (booksCount >=5) {
            wait();
        }

        booksCount++;
        System.out.println("Book put!");
        System.out.println("Number of books left: " + booksCount);
        notify();
        System.out.println("Put Book FINISH");
    }
}

class Put implements Runnable{

    private Storage storage;

    public Put(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i<10; i++) {
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{
    private Storage storage;

    public Get(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i<10; i++) {
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Library {
    public static void main(String[] args) {
//        Storage storage = new Storage();
//        Put put = new Put(storage);
//        Get get = new Get(storage);
//
//        new Thread(put).start();
//        new Thread(get).start();

// Взаимная блокировка потоков (deadlock)
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (obj1) {
                    // какая-то обработка данных
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread1 locked obj1");
                    synchronized (obj2) {
                        System.out.println("Thread1 locked both objects");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (obj2) {
                    System.out.println("Thread1 locked obj2");
                    synchronized (obj1) {
                        System.out.println("Thread1 locked both objects");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}