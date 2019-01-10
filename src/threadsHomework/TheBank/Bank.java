package threadsHomework.TheBank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> userAccounts = new ArrayList<>();
    private List<Thread> transactions = new ArrayList<>();

    public void transferMoney(Account src, Account dst, int money) {
        Transaction trans = new Transaction(src, dst, money);
        Thread transaction = new Thread(trans);
        transaction.start();
        transactions.add(transaction);
    }

    public void createAccount(Account account){
        userAccounts.add(account);
    }

    public List<Thread> getTransactions() {
        return transactions;
    }
}
