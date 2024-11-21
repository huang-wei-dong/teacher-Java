package cn.jyd.eight;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class TestMyCollection {
    private MyArrayCollection<Student> collection;

    @Before
    public void init() {
        collection = new MyArrayCollection<>(TestInit.initStudent());
    }

    @Test
    public void testMyCollection() {
        MyArrayCollection<Integer> collection = new MyArrayCollection<>(4);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(4);
        System.out.println(collection);
        System.out.println("-----------------------------");
        System.out.println("去重后的集合");
        System.out.println(collection.distinct());
    }

    @Test
    public void testMyCollectionSelect() {
        MyArrayCollection<Student> select = collection.select(s -> s.getAge() > 22);
        System.out.println(select.toString());
    }

    /**
     * 多字段排序
     * 1. 先按性别排序，如果性别相同，则按年龄排序
     */
    @Test
    public void testMyCollectionSort() {
        MyArrayCollection<Student> sort = collection.sort(
                (s1, s2) -> s1.getSex().compareTo(s2.getSex()) == 0 ?
                        s1.getAge() - s2.getAge() : s1.getSex().compareTo(s2.getSex()));
        System.out.println(sort.toString());
    }

    /**
     * 链式编程
     * 需要上一个方法返回值也是MyArrayCollection
     */
    @Test
    public void testChainProgramming() {
        MyArrayCollection<Student> result =
                collection.select(s -> s.getAge() > 21)
                        .sort((s1, s2) -> -(s1.getScore() - s2.getScore()))
                        .select(s -> s.getName().startsWith("王"));
        System.out.println(result.toString());
    }

    /**
     * 将实现接口的类实例作为方法参数
     */
    @Test
    public void testInterfaceParam() {
        // 实现Comparator接口的类
        class StudentComparator implements Comparator<Student> {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        }
        // 实例化Comparator接口的类
        StudentComparator comparator = new StudentComparator();
        // 调用sort方法，将接口的实现类实例传入
        MyArrayCollection<Student> students = collection.sort(comparator);
        System.out.println(students);
    }

    /**
     * 采用匿名类实例作为方法参数
     */
    @Test
    public void testAnonymousClass() {
        // 调用sort方法，将匿名类实例传入
        MyArrayCollection<Student> students = collection.sort(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getScore() - o2.getScore();
                    }
        });
        System.out.println(students);
    }

    /**
     * 采用Lambda表达式作为方法参数
     */
    @Test
    public void testLambda() {
        // 调用sort方法，将Lambda表达式传入
        MyArrayCollection<Student> students=collection.sort(
                (s1, s2) -> s1.getScore() - s2.getScore());
        System.out.println(students);
    }
}
