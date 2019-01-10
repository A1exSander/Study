package threadsHomework.TheBank;

//        Создать следующие классы:
//        Класс Пользователь (поля: ID и Email)
//        Класс Аккаунт (поля: ID, ID пользователя, количество средств)
//        ID должны быть уникальны и ID аккаунтов тоже
//        Класс Банк (Список всех аккаунтов, метод перевода денег)
//        transferMoney(Account src, Account dst, in amount) - откуда, куда, сколько. Аккаунт отправителя и получателя не должен совпадать.
//        Если средств недостаточно, перевод не будет выполнен.
//        Потокобезопасная проверка состояния счета (для отправки)
//        Класс Транзакций (Transaction) - поля: отправитель, получатель, количество денег, дата и время.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        User user1 = new User("blabla@gmail.com");
        User user2 = new User("blabla2@gmail.com");

        Account account11 = new Account(user1, 1000);
        Account account12 = new Account(user1, 3000);
        Account account13 = new Account(user1, 0);
        Account account21 = new Account(user2, 1000);
        Account account22 = new Account(user2, 0);

        bank.transferMoney(account11, account21, 1000);
        bank.transferMoney(account13, account21, 1000);
        bank.transferMoney(account21, account13, 1000);

        for (Thread transactions : bank.getTransactions()) {
            try {
                transactions.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(account11);
        System.out.println(account13);
        System.out.println(account21);
    }
}
