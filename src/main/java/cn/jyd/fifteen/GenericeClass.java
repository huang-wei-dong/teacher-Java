package cn.jyd.fifteen;

import cn.jyd.four.Person;

/**
 * 泛型类
 * 这是一个泛型类示例
 * 其中<>中的T,E,K,V是占位符号，表示四种类型
 * 这四种类型在类中任何位置都可以使用
 */
public class GenericeClass<T,E,K,V> {
    T fun1(K key){//返回值为T类型，参数为K类型
        V value=null;//value是类型为V的变量
        return null;
    }
    void fun2(E element){//参数element的类型是E
    }

    /**
     * 泛型方法
     * <R,P>是fun3方法中可以使用的泛型
     * fun3 返回R类型
     *      使用的参数 params 是P类型
     */
    public <R,P> R fun3(P params){

        return null;
    }
}

