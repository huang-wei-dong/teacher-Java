package cn.jyd.designPatterns.strategyPattern;
/**
 * 支付策略接口
 */
public interface PaymentStrategy {
    void pay(double amount);
}
