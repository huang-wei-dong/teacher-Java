package cn.jyd.designPatterns.strategyPattern;
/**
 * 支付宝支付策略
 */
public class AlipayStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用支付宝支付 " + amount + " 元");
    }
}
