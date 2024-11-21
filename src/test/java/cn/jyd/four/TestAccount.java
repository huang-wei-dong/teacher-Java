package cn.jyd.four;

import org.junit.Test;

public class TestAccount {
    @Test
    public void testAccount() {
        //匿名内部类
        Account account = new Account("建设银行",1000){
            @Override
            public void interest() {
                System.out.println("建设银行结息5%");
                deposit(getBalance()*0.05);
            }
        };
        account.deposit(100);
        account.withdraw(200);
        account.interest();
        System.out.println("账户余额：" + account.getBalance());
    }

    @Test
    public void testAccount2() {
        //匿名类:中国银行类
        Account account = new Account("中国银行",1000){
            @Override
            public void interest() {
                System.out.println("中国银行结息4%");
                deposit(getBalance()*0.04);
            }
        };
        account.deposit(100);
        account.withdraw(200);
        account.interest();
        System.out.println("账户余额：" + account.getBalance());
    }
}
