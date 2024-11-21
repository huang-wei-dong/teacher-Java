package cn.jyd.fifteen;

import cn.jyd.four.Person;

/**
 * 泛型类
 * <T extends Person>表示T是一个泛型，
 * T必须是Person的子类，即T的上界是Person
 */
public class GenericeClass2<T extends Person> {
    void fun(T t){
        t.getAge();    //因为t一定是Person的子类，所以Person的方法可用
        t.getCardId();
    }
}
