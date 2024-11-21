package cn.jyd.five;

import cn.jyd.TestInit;
import cn.jyd.four.Person;
import org.junit.Test;

import java.time.LocalDate;

public class TestFive {
    private final Integer[] arr = {1, 2, 14, 3, 13, 4, 5};
    private String[] str = {"a", "b", "e", "f", "c", "d", "g"};
    private Student[] students = TestInit.initStudent();
    @Test
    public void testSort() {
        Sort<Integer> sort1 = new Sort<Integer>(arr);
        sort1.sort();
        sort1.show();

        Sort<String> sort2 = new Sort<String>(str);
        sort2.sort();
        sort2.show();
    }


    @Test
    public void testSortFun() {
        Sort<Integer> sort1 = new Sort<Integer>(arr);
        sort1.sort((o1, o2) -> o2 - o1);
        sort1.show();

        Sort<String> sort2 = new Sort<String>(str);
        sort2.sort((o1, o2) -> o2.compareTo(o1));
        sort2.show();

    }
    //测试成员方法重载
    @Test
    public void testReload() {
        int a = 10;
        int b = 20;
        System.out.println(MyMath.add(a,b));
        System.out.println(MyMath.add(5.3f,6.7f));
        System.out.println(MyMath.add("I am ","student"));
    }

    /**
     * 测试Person的equals方法
     */
    @Test
    public void testEquals() {
        Person p1 = new Person("1111","张三","男", LocalDate.of(1990,1,1));
        Person p2 = new Person("1111","张三","女", LocalDate.of(1990,1,1));
        System.out.println("p1==p2结果："+p1.equals(p2));
    }
    /**
     * 测试单例模式
     */
    @Test
    public void testPrinter(){
        //Printer p1=new Printer();//错误！试图在外部new一个对象
        Printer p=Printer.getInstance();//正确！通过静态方法获取唯一实例
    }

}
