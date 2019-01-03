package threadsHomework.Pizzeria;

//Сделать пиццерию на очередях: клиенты складывают заказы в очередь 1,
//официанты из нее заказы забирают и добавляют в очередь 2, из которой повар заказ забирает и готовит,
//после чего он готовые блюда складывает в очередь 3, из который клиенты будут забирать заказы.
//Сами же клиенты блокируются на очереди 3, официанты на очереди 1, а повара - на очереди 2.

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Pizzeria {

    BlockingQueue<Order> newOrders = new ArrayBlockingQueue<>(10, true);
    BlockingQueue<Order> cookingOrders = new ArrayBlockingQueue<>(10, true);
    BlockingQueue<Order> doneOrders = new ArrayBlockingQueue<>(10, true);

    public Pizzeria() {


        for (int i = 1; i <= 5; i++) {
            new Thread(new Client()).start();
        }
        new Thread(new Waiter()).start();
        new Thread(new Cook()).start();

    }

    class Order {
        String name;
        String clientID;

        public Order(String name, String clientID) {
            this.name = name;
            this.clientID = clientID;
        }

        public String getClientID() {
            return clientID;
        }

        public String getName() {
            return name;
        }
    }

    class Client implements Runnable {

        @Override
        public void run() {

            try {
                newOrders.put(new Order("Маргарита", Thread.currentThread().getName()));
                System.out.println("Клиент сделал заказ");

                newOrders.put(new Order("Карбонара", Thread.currentThread().getName()));
               System.out.println("Клиент сделал заказ");

                System.out.println();
                Order receivedOrder;

                while (!((receivedOrder = doneOrders.take()).getClientID().equals(Thread.currentThread().getName()))) {
                    System.out.println("Это не мой заказ!");
                    doneOrders.put(receivedOrder);
                    Thread.sleep(10);
                }
                System.out.println("Заказ от " + receivedOrder.getClientID() +  " получен клиентом " + Thread.currentThread().getName());
                while (!((receivedOrder = doneOrders.take()).getClientID().equals(Thread.currentThread().getName()))) {
                    System.out.println("Это не мой заказ!");
                    doneOrders.put(receivedOrder);
                    Thread.sleep(10);
                }
                System.out.println("Заказ от " + receivedOrder.getClientID() +  " получен клиентом " + Thread.currentThread().getName());

                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class Waiter implements Runnable {

        @Override
        public void run() {
            try {
                if (newOrders.isEmpty()) Thread.sleep(1000);
                while (!(newOrders.isEmpty())) {
                    Order newOrder;
                    newOrder = newOrders.take();
                    System.out.println("Официант взял заказ");
                    cookingOrders.put(newOrder);
                    System.out.println("Официант передал заказ повару");
                    System.out.println("Осталось непереданных заказов: " + newOrders.size());
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Cook implements Runnable {

        @Override
        public void run() {
            try {
               if (cookingOrders.isEmpty()) Thread.sleep(1000);

                while (!(cookingOrders.isEmpty())) {
                    Order cookingOrder;
                    cookingOrder = cookingOrders.take();
                    System.out.println("Повар взял заказ");
                    doneOrders.put(cookingOrder);
                    System.out.println("Повар отдал заказ на выдачу");
                    System.out.println("Осталось приготовить заказов: " + cookingOrders.size());
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
