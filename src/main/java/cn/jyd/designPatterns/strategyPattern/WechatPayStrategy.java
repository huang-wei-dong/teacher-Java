package cn.jyd.designPatterns.strategyPattern;
/**
 * 微信支付策略
 */
public class WechatPayStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用微信支付 " + amount + " 元");
    }
}
