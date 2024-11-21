package cn.jyd.Thirteen;

import cn.jyd.thirteen.PriceToken;
import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试字符串
 */
public class TestString {
    /**
     * Example 8_1
     * 理解字符串的的引用
     */
    @Test
    public void example8_1()
    {
        //字符串放在常量池
        String hello="您好";
        String testOne="您"+"好";
        int address=System.identityHashCode("您好");
        System.out.println("\"您好\"的引用："+address);
        address=System.identityHashCode(hello);
        System.out.println("hello的引用："+address);
        address=System.identityHashCode(testOne);
        System.out.println("testOne的引用："+address);
        System.out.println("hello==testOne："+(hello==testOne));
        System.out.println("testOne==\"您好\"："+(testOne=="您好"));
        System.out.println("hello==\"您好\"："+(hello=="您好"));

        //字符串拼接后
        System.out.println();
        String you = "您";
        String hi = "好";
        String testTwo=you+hi;
        address=System.identityHashCode("您");
        System.out.println("\"您\"的引用："+address);
        address=System.identityHashCode("好");
        System.out.println("\"好\"的引用："+address);
        address=System.identityHashCode(testTwo);
        System.out.println("testTwo的引用："+address);
        System.out.println("testTwo==hello:"+(testTwo==hello));
    }

    /**
     * Example 8_2
     * 理解字符串的equals
     */
    @Test
    public void example8_2()
    {
        String s1,s2;
        s1=new String("天道酬勤");
        s2=new String("天道酬勤");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("s1、s2实体相等吗"+s1.equals(s2));
        int adressS1=System.identityHashCode(s1);
        int adressS2=System.identityHashCode(s2);
        System.out.println("s1、s2引用："+adressS1+","+adressS2);
        System.out.println("s1、s2的引用是否相等："+(s1==s2));

        System.out.println();
        String s3,s4;
        s3="we are students";
        s4=new String("we are students");
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("s3、s4实体相等吗"+s3.equals(s4));
        int adressS3=System.identityHashCode(s3);
        int adressS4=System.identityHashCode(s4);
        System.out.println("s3、s4引用："+adressS3+","+adressS4);
        System.out.println("s3、s4的引用是否相等："+(s3==s4));

        System.out.println();
        String s5,s6;
        s5="勇者无敌";
        s6="勇者无敌";
        System.out.println(s5);
        System.out.println(s6);
        System.out.println("s5、s6实体相等吗"+s5.equals(s6));
        int adressS5=System.identityHashCode(s5);
        int adressS6=System.identityHashCode(s6);
        System.out.println("s5、s6引用："+adressS5+","+adressS6);
        System.out.println("s5、s6的引用是否相等："+(s5==s6));
    }
    /**
     * 常用方法
     */
    @Test
    public void testStandMethod(){
        String str = " I am student ";//创建字符串

        System.out.println(str.length());//获取字符串长度
        System.out.println(str.toUpperCase());//大写
        System.out.println(str.toLowerCase());//
        System.out.println(str.trim());//去除首尾空格
        System.out.println(str.replace("am","was"));//替换
        System.out.println(str.substring(2));//取子串
        System.out.println(str.substring(2,7));//取子串
        System.out.println(str.charAt(3));//取字符
        System.out.println(str.indexOf("am"));//返回索引
        System.out.println(str.lastIndexOf("am"));//返回索引
        System.out.println(str.contains("am"));//是否包含
        System.out.println(str.startsWith("I"));//是否以某字符开头
        System.out.println(str.endsWith(" "));//
        System.out.println(str.equals(" I am student "));//是否相等
        System.out.println(str.equalsIgnoreCase(" i am student "));///忽略大小写比较
        System.out.println(str.compareTo(" I am student!"));//比较先后次序
        System.out.println(str.concat("world"));//字符串连接
    }
    /**
     * 测试字符串format方法
     */
    @Test
    public void testStringFormat()
    {
        String str = "I am %s,%d years old";
        System.out.println(String.format(str,"张三",20));
    }
    /**
     * 测试字符串jion方法
     */
    @Test
    public void testStringJoin()
    {
        String[] strs = {"I","am","student"};
        String str = String.join(", ",strs);
        System.out.println(str);
    }

    /**
     * 字符串裂解
     */
    @Test
    public void testSplit(){
        String str = "I am student";
        //采用空格裂解
        String[] strs = str.split(" ");
        for (String s : strs) {
            System.out.println(s);
        }
    }
    /**
     * 正则表达式提取字符串中数字串
     */
    @Test
    public void testReg(){
        String str = "公元1949年10月1日中华人民共和国成立";
        String regex = "\\D+";//任何非数字字符，出现1次或多次
        String[] strs = str.split(regex);
        for (String s : strs) {
            System.out.println(s);
        }
    }
    /**example 8_10
     * 字符串replaceAll方法，通过regex 参数来指定要替换的字符串
     */
    @Test
    public void testReplaceAll()
    {
        String str = "培训学校的 E-mail:qinghua@sina.com.cn 或 zhang@163.com";
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";//匹配数字串，出现1次或多次
        String result = str.replaceAll(regex,"");
        System.out.println(result);
        String money = "89,235,678$";
        String regex2 = "[,\\p{Sc}]";//\\p{Sc}匹配货币符号
        String resultMoney = money.replaceAll(regex2,"");
        long moneyNum = Long.parseLong(resultMoney);
        System.out.println(moneyNum);
    }
    /**
     * 测试matches方法
     */
    @Test
    public void testMatches()
    {
        //验证身份证
        String cardID = "51021519781209053x";
        String regex = "[1-9][0-9]{16}[a-zA-Z0-9]";
        boolean result = cardID.matches(regex);
        System.out.println("身份证"+cardID+":"+result);
        //验证日期
        String date = "2024-11-18";
        String year = "[1-9][0-9]{3}";
        String month = "((0?[1-9])|(1[012]))";
        String day = "((0?[1-9])|([12][0-9])|(3[01]?))";
        String regexDate = year+"[-./]"+month+"[-./]"+day;
        System.out.println("日期"+date+":"+date.matches(regexDate));
    }

    /**
     * 理解字符串不可变性
     */
    @Test
    public void testStringConst()
    {
        String str1 = "Hello";
        String str2 = str1 + ", World!";
        System.out.println(str2); // 输出: Hello, World!

        str1 = "Goodbye";
        System.out.println(str2); // 输出: Hello, World!
        // str2的值没有改变，因为字符串是immutable的，无法被修改。
    }
    /**
     * StringBuilder和StringBuffer类
     */
    @Test
    public void testStringBuilder()
    {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        System.out.println(sb.toString()); // 输出: Hello, World!

        sb.insert(5, "Java");
        System.out.println(sb.toString()); // 输出: HelloJava, World!

        sb.delete(5, 9);
        System.out.println(sb.toString()); // 输出: Hello, World!

        sb.reverse();
        System.out.println(sb.toString()); // 输出: !dlroW ,olleH
    }
    /**
     * 理解String和StringBuilder的性能差异
     */
    @Test
    public void testStringPerformance()
    {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++)
        {
            sb.append("Hello");
        }
        System.out.println("StringBuilder took " + (System.currentTimeMillis() - startTime) + " milliseconds.");
        startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++)
        {
            str += "Hello";
        }
        System.out.println("String took " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }
    /**
     * 将String转换为数值类型
     */
    @Test
    public void testStringToNumber()
    {
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println("转换为int类型:"+num); // 输出: 123

        float flt = Float.parseFloat(str);
        System.out.println("转换为float类型:"+flt);

        double dbl = Double.parseDouble(str);
        System.out.println("转换为double类型:"+dbl);
    }
    /**
     * String类型和字符数组
     */
    @Test
    public void testStringToCharArray()
    {
        String str = "1945年8月15日是抗战胜利日";
        char[] chars= new char[4];
        str.getChars(11,15,chars,0);
        for (char c : chars)
        {
            System.out.println(c);
        }
    }
    /**
     * Example 8_12
     * 测试StringTokenizer类
     */
    @Test
    public void testStringTokenizer()
    {
        String shoppingReceipt = "牛奶：8.5元，香蕉：3.6元，酱油：2.8元";
        System.out.println(shoppingReceipt);
        PriceToken lookPriceMess=new  PriceToken();
        double sum=lookPriceMess.getPirceSum(shoppingReceipt);
        System.out.println("购物总价为："+sum);
        int amount=lookPriceMess.getGoodsAmount(shoppingReceipt);
        double average=lookPriceMess.getAvgPrice(shoppingReceipt);
        System.out.printf("\n商品数目：%d，平均价格为：%7.2f",amount,average);
    }
    /**
     * 测试Scanner类,Example 8_13
     */
    private double scannerPrice(String cost) {
        double sum = 0;
        Scanner scanner = new Scanner(cost);
        scanner.useDelimiter("[^0123456789.]+");
        while (scanner.hasNext()) {
            try {
                double price = scanner.nextDouble();
                sum += price;
            } catch (InputMismatchException e) {
                String t = scanner.next();
            }
        }
        return sum;
    }
    /**
     * 测试Scanner类，Example 8_14
     */
    @Test
    public void testScanner() {
        String cost = "市话：76.8元，长途167.38元，短信：12.68元";
        System.out.println(cost);
        double priceSum = scannerPrice(cost);
        System.out.println("购物总价为：" + priceSum);
        cost = "牛奶：8.5元，香蕉：3.6元，酱油：2.8元";
        System.out.println(cost);
        priceSum = scannerPrice(cost);
        System.out.println("购物总价为：" + priceSum);
    }

    /**
     * 测试Pattern类和Matcher类，Example 8_14
     */
    @Test
    public void testPattern() {
        //需匹配的数据源
        String dataSource = "市话：76.8元，长途167.38元，短信：12.68元";
        //需匹配的整数和浮点数的正则表达式
        String regex = "-?[1-9][0-9]*[.]?[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dataSource);
        double sum = 0;
        while (matcher.find()) {
            String item = matcher.group();
            System.out.println(item);
            sum += Double.parseDouble(item);
        }
        System.out.println("购物总价为：" + sum);
    }

    /**
     * 测试Scanner类,作业第八章 4.6
     */
    @Test
    public void scannerScore() {
        String score = "数学87分，物理76分，英语96分";
        double sum = 0;//存储成绩的总和
        int count=0;//存储成绩的个数
        Scanner scanner = new Scanner(score);
        scanner.useDelimiter("[^0123456789.]+");

        while (scanner.hasNext()) {
            try {
                double grades = scanner.nextDouble();
                sum += grades;
                count++;
            } catch (InputMismatchException e) {
                String t = scanner.next();
            }
        }
        System.out.println("总成绩：" + sum);
        System.out.println("平均成绩：" + sum / count);
    }
}
