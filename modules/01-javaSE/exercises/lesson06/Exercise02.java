package lesson06;

/**
 * 练习 2：自定义异常
 * 配套笔记：notes/06-异常.md 第 6 节
 * <p>
 * 题目：定义 InsufficientBalanceException，补全 BankAccount，并测试。
 */
public class Exercise02 {

    public static void main(String[] args) {
        // TODO 1：创建 BankAccount("小明", 100)，打印余额，预期：余额：100.0

        // TODO 2：取款 30，打印余额，预期：余额：70.0

        // TODO 3：取款 100（余额不足）
        // 用 try-catch 捕获 InsufficientBalanceException，打印 e.getMessage()
        // 预期：余额不足，当前余额：70.0

        // TODO 4（选做）：取款 50（刚好够），打印余额，预期：余额：20.0
    }
}

// TODO：定义 InsufficientBalanceException
// 继承 RuntimeException，提供带 String message 的构造，调用 super(message)

// TODO：补全 BankAccount
// 1. 私有字段：String owner、double balance
// 2. 构造 BankAccount(String owner, double balance)
// 3. withdraw(double amount)：
//    - amount > balance 时 throw new InsufficientBalanceException("余额不足，当前余额：" + balance)
//    - 否则 balance -= amount
// 4. getBalance() 返回余额
class BankAccount {
    // 你的代码
}