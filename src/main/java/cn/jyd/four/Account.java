package cn.jyd.four;
// 账户类，封装了账户余额，实现账户余额的加减操作
public abstract class Account {
    private String  bankName;// 银行名称

    private double balance;    // 账户余额
    // 收入
    public void deposit(double amt) {
        balance += amt;
        System.out.println("账户收入：" + amt);
    }
    //支出
    public void withdraw(double amt) {
        balance -= amt;
        System.out.println("账户支出：" + amt);
    }
    //结息
    public abstract void interest();

    // 无参构造
    public Account() {
        balance=0;
    }
    // 带参构造

    public Account(String bankName, double balance) {
        this.bankName = bankName;
        this.balance = balance;
        System.out.println(bankName+"账户已创建，余额为：" + balance);
    }
    // 获取余额
    public double getBalance() {
        return balance;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
