package cn.jyd.designPattern;

import cn.jyd.designPatterns.strategyPattern.AlipayStrategy;
import cn.jyd.designPatterns.strategyPattern.PaymentContext;
import cn.jyd.designPatterns.strategyPattern.WechatPayStrategy;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void strategyTest() {
        // 使用微信支付
        PaymentContext wechatContext = new PaymentContext(new WechatPayStrategy());
        wechatContext.executePayment(100.0);

        // 使用支付宝支付
        PaymentContext alipayContext = new PaymentContext(new AlipayStrategy());
        alipayContext.executePayment(200.0);
    }
}
