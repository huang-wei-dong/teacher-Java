package cn.jyd.thirteen;

import java.util.StringTokenizer;

/**
 * Exapmle 8_12
 * 计算购物小票中商品价格和
 */
public class PriceToken {
    public double getPirceSum(String shoppingReceipt){
        double sum=0;
        String regex="[^0123456789.]+";//匹配非数字和点
        //将非数字和点替换为#
        shoppingReceipt=shoppingReceipt.replaceAll(regex,"#");
        //以#分割
        StringTokenizer fenxi=new StringTokenizer(shoppingReceipt,"#");
        while(fenxi.hasMoreTokens()){
            String item=fenxi.nextToken();
            double price=Double.parseDouble(item);
            sum+=price;
        }
        return sum;
    }
    public double getAvgPrice(String shoppingReceipt){
        double priceSum=getPirceSum(shoppingReceipt);
        int goodsAmount=getGoodsAmount(shoppingReceipt);
        return priceSum/goodsAmount;
    }

    public int getGoodsAmount(String shoppingReceipt) {
        String regex="[^0123456789.]+";//匹配非数字和点
        shoppingReceipt=shoppingReceipt.replaceAll(regex,"#");
        StringTokenizer fenxi=new StringTokenizer(shoppingReceipt,"#");
        int amount=fenxi.countTokens();
        return amount;
    }
}
