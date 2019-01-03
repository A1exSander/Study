package lesson23;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // java.util.concurrent.Callable
        // - Возвращает данные из потока
        // java.util.concurrent.Future
        // Методы:
        // get() get(lomg 1, TimeUnit tu)
        // Позволяют получить из потока результат
        // cancel() - отменяет задачу в потоке
        // isCancelled() - возвращает True, если задача отменялась с помощью cancel()
        // isDone() - возвращает True, если задача решилась

        // Класс FutureTask (оболочка над потоками для использования методов выше)
        // new FutureTask(Callable<T> c) - можно передать в конструктор Callable или Runnable:
        // new FutureTask(Runnable r, T result)

        FutureTask<String> task1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int counter = 0;
                while (!Thread.currentThread().isInterrupted() && counter < 3) {
                    counter++;
                    Thread.sleep(1000);
                }
                return "Finished";
            }
        });

        new Thread(task1).start();
        Thread.sleep(2000);

        String result = task1.get();
        System.out.println(result);

        task1.cancel(true);

        System.out.println(task1.isCancelled());
        System.out.println(task1.isDone());

//      Интерфейс Executor - создан для управления группой потоков
//      execute(Runnable run)
//      (Создание потоков, повторное их использование)
//
//        new Thread(task1).start(); // - первый вариант запуска потока
//        ExecutorService executorService; // Создание объекта
//        executorService.execute(new Thread(task1)); // - Второй вариант запуска потока
//        executorService.submit(new Thread(task1)); // - добавляет задачу на выполнение

//        Класс Executors
//        Executors.newFixedThreadPool(int i) - создает пул потоков с фиксированным количеством
//        Executors.newSingleThreadExecutor() - создает пул с одним потоком
//        Executors.newCachedThreadPool() - создает пул с необходимым количеством потоков (решает сам)
//        Executors.newScheduledThreadPool(int i) - создает пул потоков с фиксированным количеством с возможностью задания расписания

        ExecutorService pool = Executors.newFixedThreadPool(2);
//        for (int i = 0; i<5; i++) {
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("pool: "+ Thread.currentThread().getName());
//                }
//            });
//        }
        // метод submit возвращает объект Future
        // соответственно ему доступны все его методы
        pool.submit(new Thread(task1)).get();

        ExecutorService service = new ThreadPoolExecutor(
                1, // основное количество потоков
                10, // максимальное количество потоков
                2, // Время простаивания избыточных потоков в режиме ожидания
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>() // Очередь для задач
        );

        for (int i = 0; i < 3; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    // Код
                }
            });
        }
        Future o = null;
        for (int i = 0; i < 5; i++) {
            o = pool.submit(new Thread(task1));
        }

                pool.shutdown();
        System.out.println(o.get());

//        Объекты синхронизации
//        CountDownLatch(int num); - блокирует работу потока до завершения событий в количестве num
//        await();
//        countDown(); - уменьшает счетчик CountDownLatch на 1

//        Exchanger
//        exchange(T buffer);

//        ДЗ: Создать следующие классы:
//        Класс Пользователь (поля: ID и Email)
//        Класс Аккаунт (поля: ID, ID пользователя, количество средств)
//        ID должны быть уникальны и ID аккаунтов тоже
//        Класс Банк (Список всех аккаунтов, метод перевода денег)
//        transferMoney(Account src, Account dst, in amount) - откуда, куда, сколько. Аккаунт отправителя и получателя не должен совпадать.
//        Если средств недостаточно, перевод не будет выполнен.
//        Потокобезопасная проверка состояния счета (для отправки)
//        Класс Транзакций (Transaction) - поля: отправитель, получатель, количество денег, дата и время.
//
    }
}
