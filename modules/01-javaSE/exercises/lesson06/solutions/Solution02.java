package lesson06.solutions;

/**
 * 练习 2 参考答案：自定义异常
 * 注意：先独立完成练习，再对照这份答案。
 */
public class Solution02 {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("小明", 100);
        System.out.println("余额：" + account.getBalance());

        account.withdraw(30);
        System.out.println("余额：" + account.getBalance());

        try {
            account.withdraw(100);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        account.withdraw(50);
        System.out.println("余额：" + account.getBalance());
    }
}

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String owner;
    private double balance;

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException("余额不足，当前余额：" + balance);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}