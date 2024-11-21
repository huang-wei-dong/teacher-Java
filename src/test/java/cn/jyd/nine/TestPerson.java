package cn.jyd.nine;

import cn.jyd.TestInit;
import cn.jyd.Tools.ArrayTools;
import cn.jyd.four.Person;
import org.junit.Test;
import java.util.Comparator;

/**第七章 匿名类、内部类和Lambda表达式
 *
 */
public class TestPerson {
    @Test
    public void testPersonSort()
    {
        Person[] persons = TestInit.initPerson();
        ArrayTools<Person> arrayTools = new ArrayTools<>(persons);
        /**new Comparator<Person>()实现一个匿名类
         * 该匿名类重写了compare方法，实现了前后比较，
         * 程序用该比较进行排序
         */
        arrayTools.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        arrayTools.print();
    }
    /**使用Lambda表达式进行排序
     *
     */
    @Test
    public void testPersonSortLambda()
    {
        Person[] persons = TestInit.initPerson();
        ArrayTools<Person> arrayTools = new ArrayTools<>(persons);
        /**(p1,p2)-> p1.getAge()-p2.getAge()是一个lambad表达式
         * 该表达式，本质上一个函数
         * (p1,p2) 是参数
         * -> 是关键字（lambad表达式的约定符合）
         * p1.getAge()-p2.getAge()是函数体
         * 该表达式可以理解为，将p1和p2作为参数，返回p1.getAge()-p2.getAge()
         */
        arrayTools.sort((p1,p2)-> p1.getAge()-p2.getAge() );
        arrayTools.print();
    }
}
