package cn.jyd.ten;

/**example7-6
 * 自定义异常类，银行收支异常
 */
public class BankException extends Exception{
    private String message;

    public BankException(int m,int n) {
        this.message = "入账资金"+m+"是负数，或支出"+n+"是正数，不符合系统要求";
    }
    public String warnMess() {
        return message;
    }
}
