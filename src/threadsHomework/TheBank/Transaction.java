package threadsHomework.TheBank;

import java.util.Date;

public class Transaction implements Runnable {

    private Account src;
    private Account dst;
    private int money;
    private Date date;
    private Account obj1, obj2;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
        this.date = new Date();
    }


    @Override
    public void run() {
        date = new Date();
        if(src.getMoney() < money || src == dst || money <= 0) {
            System.out.println("Транзакция не удалась: на счету недостаточно средств или введены неверные данные");
            Thread.currentThread().interrupt();
        } else {
            if (src.getId() < dst.getId()) {
                obj1 = src;
                obj2 = dst;
            } else {
                obj2 = src;
                obj1 = dst;
            }

            synchronized (obj1) {
                synchronized (obj2) {
                    src.setMoney(src.getMoney()-money);
                    dst.setMoney(dst.getMoney()+money);
                    System.out.println("Транзакция прошла успешно в " + date);
                }
            }

        }



    }
}
