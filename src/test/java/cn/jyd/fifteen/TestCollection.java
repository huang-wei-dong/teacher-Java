package cn.jyd.fifteen;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import cn.jyd.seven.Shapes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class TestCollection {
    Student s1,s2,s3,s4,s5;
    ArrayList<Student> arrayList;
    /**
     * 演示集合类型的常用方法
     */
    @Test
    public void testCollection(){
        init();
        System.out.println("将s3从集合中删除：");
        arrayList.remove(s3);
        System.out.println(arrayList);
        System.out.println("将s2替换为s6：");
        arrayList.set(1,new Student("006","赵六","男",LocalDate.of(1999,8,8),60));
        System.out.println(arrayList);
        System.out.println("集合中是否包含s4："+ arrayList.contains(s4));
        System.out.println("s5在集合中的位置："+ arrayList.indexOf(s5));
    }
    @Test
    public void init() {
        s1 = new Student("001", "张三", "男", LocalDate.of(1996, 5, 5), 90);
        s2 = new Student("002", "李四", "男", LocalDate.of(1997, 6, 6), 80);
        s3 = new Student("003", "王五", "男", LocalDate.of(1998, 7, 7), 70);
        s4 = new Student("004", "赵六", "男", LocalDate.of(1999, 8, 8), 60);
        s5 = new Student("005", "孙七", "男", LocalDate.of(2000, 9, 9), 50);
        arrayList = new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);
        arrayList.add(s5);
    }
    /**
     * 演示链表类型的常用方法
     */
    @Test
    public void testLinkedList(){
        init();
        LinkedList<Student> list = new LinkedList<>();
        //采用函数式编程，将arrayList中的元素添加到list中
        arrayList.forEach(s->list.add(s));
        System.out.println("链表第一个元素");
        list.getFirst().showWithScore();//获取链表的第一个元素
        System.out.println("链表最后一个元素");
        list.getLast().showWithScore();//获取链表的最后一个元素
        System.out.println("--------按成绩逆序排序后-------------");
        list.sort((s1,s2)->-(s1.getScore()-s2.getScore()));
        list.forEach(System.out::println);//遍历集合,输出到控制台
    }
    /**
     * 演示HashMap的常用方法
     */
    @Test
    public void testHashMap(){
        init();
        //创建HashMap对象，键为学号，值为学生
        HashMap<String,Student> map = new HashMap<>();
        //遍历学生集合，将元素添加到map中
        arrayList.forEach(s->map.put(s.getCardId(),s));
        System.out.println("map中键为003的元素："+map.get("003"));
        //打印所有学号
        System.out.print("map中所有键：");
        map.keySet().forEach(s->System.out.print(s+" "));
    }
    /**
     * 演示HashSet的常用方法
     */
    @Test
    public void testHashSet(){
        init();
        HashSet<Student> set1 = new HashSet<>(arrayList);
        HashSet<Student> set2 = new HashSet<>();
        set2.add(new Student("001","张三","男",LocalDate.of(1996,5,5),90));
        set2.add(new Student("002","李四","男",LocalDate.of(1997,6,6),80));
        set1.addAll(set2);
        System.out.println("set1和set2的并集元素个数："+set1.size());

        System.out.println("set1和set2的并集：");
        System.out.println(set1);
    }
    /**
     * 演示通过扩展集合获取集合的max，min，sum,avg
     */
    @Test
    public void testExtendCollection(){
        init();
        ExCollection<Student> extendCollection = new ExCollection<>(arrayList);
        System.out.println("最高成绩："+extendCollection.max(s->(double) s.getScore()));
        System.out.println("最低成绩："+extendCollection.min(s->(double) s.getScore()));
        System.out.println("平均成绩："+extendCollection.avg(s->(double) s.getScore()));
        System.out.println("总成绩："+extendCollection.sum(s->(double) s.getScore()));
        System.out.println("----------------年龄：--------------");
        System.out.println("最大年龄："+extendCollection.max(s->(double) s.getAge()));
        System.out.println("最小年龄："+extendCollection.min(s->(double) s.getAge()));
        System.out.println("平均年龄："+extendCollection.avg(s->(double) s.getAge()));
    }
    /**
     * 集合Collections静态方法
     */
    @Test
    public void testStaticMethod(){
        List<String> collection = Arrays.asList("a","f","b","c","d","e");
        Collections.sort(collection);
        collection.forEach(System.out::println);
    }
    /**
     * 集合Collections静态max方法
     */
    @Test
    public void testMax(){
        List<Student> students =Arrays.asList(TestInit.initStudent());
        Collections.max(students, Comparator.comparingInt(Student::getAge)).show();
    }

    /**
     * 集合Collections静态洗牌和旋转
     */
    @Test
    public void testShuffle(){
        List<String> list = Arrays.asList("a","b","c","d","e");
        System.out.println("倒序：");
        Collections.reverse(list);
        list.forEach(System.out::print);//倒序
        System.out.println("\n旋转：");
        Collections.rotate(list,2);//旋转
        list.forEach(System.out::print);
        System.out.println("\n洗牌：");
        Collections.shuffle(list);//洗牌
        list.forEach(System.out::print);
    }

}
