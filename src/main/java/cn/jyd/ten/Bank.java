package cn.jyd.ten;
/**example 7-6
 * 银行类，用于测试异常处理
 */
public class Bank {
    private int money;
    public void income(int in,int out) throws BankException{
        if(in<=0 || out>=0 || in+out<=0) {
            throw new BankException(in, out);
        }
        int netIncome=in+out;
        System.out.printf("本次计算出的纯收入看来是：%d元\n",netIncome);
        money+=netIncome;
    }
    public int getMoney(){
        return money;
    }
}
