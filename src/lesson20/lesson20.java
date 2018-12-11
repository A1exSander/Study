package lesson20;


public class lesson20 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        // методы класса Thread
        // currentThread(); - позволяет получить текущий поток
        // setName(); - задает имя потока
        // getName(); - возвращает имя потока

//        Thread thread = new Thread(); // создание потока
//        thread.start(); // запуск потока
//
//        Thread thread1 = new MyThread();
//        thread1.start();
//
//        Thread thread2 = new Thread(new OtherThread());
//        thread2.start();
//
//        for (int i = 0; i<5; i++) {
//            Thread thread3 = new Thread(new OtherThread());
//            thread3.setName("T-" + i);
//            thread3.start();
//        }

//        Thread thread4 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread 4 " + Thread.currentThread().isAlive());
//                System.out.println("Thread 4 " + Thread.currentThread().getState());
//            }
//        });
//
//        System.out.println("Before start" + thread4.isAlive());
//        System.out.println("Before start" + thread4.getState());
//        thread4.start();
//
//        // меод join - ожидаем, пока поток завершится и присоединится к текущему (в данном случае Main
//
//        try {
//            thread4.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("After join " + thread4.isAlive());
//        System.out.println("After join " + thread4.getState());

//        Thread thread5 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread5.start();

        // Программа будет работать, пока есть незавершенные потоки
        // Это касается только ОСНОВНЫХ потоков
        // Потоки, отмеченные как daemon, будут остановлены c разу после остановки последнего основного потока


        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread6.setDaemon(true);
        thread6.start();

        // остановка потоков
        // 1. Поток выполнил все инструкции и вышел из метода run
        // 2. В методе run было выброшено необрабатываемое исключение
        // 3. Остановилась JVM
        // 4. Это был Daemon поток и последний основной поток остановился

        // механизм прерываний

        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("Thread 7");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread 7 interrupted");
                    }
                }
            }
        });
        thread7.start();
        System.out.println(thread7.isInterrupted());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread7.interrupt();
    }
}


// для создания своего потока нужно унаследоваться от класса Thread

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My Thread " + Thread.currentThread().getName());
    }
}

// или реализовать интерфейс Runnable (чаще используется этот вариант, чтобы можно было использовать extends для других целей)
class OtherThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Other thread " + Thread.currentThread().getName());
    }
}


