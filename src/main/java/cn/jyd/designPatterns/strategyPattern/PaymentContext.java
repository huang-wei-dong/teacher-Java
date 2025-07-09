package cn.jyd.designPatterns.strategyPattern;
/**
 * 支付上下文类
*/
public class PaymentContext {
    private final PaymentStrategy strategy;
    /**
     * 构造函数，在构造函数中将支付策略注入
     * @param strategy：支付策略
     */
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}
