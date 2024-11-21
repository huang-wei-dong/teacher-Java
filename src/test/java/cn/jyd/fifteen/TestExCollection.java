package cn.jyd.fifteen;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 测试扩展集合的常用方法
 */
public class TestExCollection {
    ExCollection<Student> students;
    @Before
    public void init() {
        Student[] studentArray = TestInit.initStudent();
        students = new ExCollection<>(studentArray);
    }

    /**
     * 测试ExCollection基本功能
     */
    @Test
    public void testExCollectionStandFunction() {
        System.out.println("\n添加一个学生：");
        students.add(new Student("101", "张三", "男",
                LocalDate.of(1998, 1, 1), 90));
        students.print();
        System.out.println("\n集合元素个数：" + students.size());

        System.out.println("\n删除一个学生：");
        students.remove(new Student("102", "李四", "男", LocalDate.of(1997, 6, 6), 80));
        students.print("删除学生102以后：");

        System.out.println("\n清空集合：");
        students.clear();
        System.out.println("集合是否为空：" + students.isEmpty());
    }

    /**
     * 测试排序,采用lambda表达式，按年龄排序
     */
    @Test
    public void testSort() {
        students.sort((s1, s2) -> s1.getAge() - s2.getAge())
                .print("按学生年龄排序：");
    }

    /**
     * 采用匿名类排序,按成绩排序
     */
    @Test
    public void testSort2() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
        }).print("按学生成绩排序：");
    }
    /**
     * 测试条件查询
     */
    @Test
    public void testWhere() {
        System.out.println("\n-------------成绩>80：--------------");
        ExCollection<Student> whereResult = students.where(s -> s.getScore() > 80);
        whereResult.print();
    }
    /**
     * 测试聚合函数
     */
    @Test
    public void testAggregate() {
        System.out.println("\n学生总数：" + students.size());

        System.out.println("学生总年龄：" + students.sum(s -> s.getAge()));
        System.out.println("学生平均年龄：" + students.avg(s -> s.getAge()));
        System.out.println("学生最大年龄：" + students.max(s -> s.getAge()));
        System.out.println("学生最小年龄：" + students.min(s -> s.getAge()));

        System.out.println("学生总成绩：" + students.sum(Student::getScore));
        System.out.println("学生平均成绩：" + students.avg(Student::getScore));
        System.out.println("学生最大成绩：" + students.max(Student::getScore));
        System.out.println("学生最小成绩：" + students.min(Student::getScore));
    }

    /**
     * 测试链式编程
     */
    @Test
    public void testChain() {
        System.out.println("链式编程：");
        students.print("初始化结果")
                .where(s -> s.getAge()>=22)
                .print("年龄大于22岁")
                .sort((s1,s2)->s1.getScore()-s2.getScore())
                .print("按成绩排序")
                .where(s->s.getSex().equals("男"))
                .print("仅男同学")
                .where(s->s.getName().startsWith("李"))
                .print("仅姓李同学");
    }

    /**
     * 测试比较器最大值
     */
    @Test
    public void testMaxByComparator() {
        Student maxStudent = students.max((s1, s2) -> s1.getAge() - s2.getAge());
        Student minStudent = students.min((s1, s2) -> s1.getAge() - s2.getAge());
        System.out.println("\n年龄最大最小同学：");
        maxStudent.showWithScore();
        minStudent.showWithScore();
        maxStudent = students.max((s1, s2) -> s1.getScore() - s2.getScore());
        minStudent = students.min((s1, s2) -> s1.getScore() - s2.getScore());
        System.out.println("\n成绩最高最低同学：");
        maxStudent.showWithScore();
        minStudent.showWithScore();
        maxStudent = students.max((s1, s2) -> s1.getCardId().compareTo(s2.getCardId()));
        minStudent = students.min((s1, s2) -> s1.getCardId().compareTo(s2.getCardId()));
        System.out.println("\n身份证最大最小同学：");
        maxStudent.showWithScore();
        minStudent.showWithScore();
    }

    /**
     * 测试groupBy
     */
    @Test
    public void testGroupBy() {
        System.out.println("\n按性别分组：");
        students.groupBy(Student::getSex).forEach((k, v) -> {
            System.out.println(k + " : ");
            v.forEach(System.out::println);
        });
        System.out.println("\n下面是等价语句，按姓名分组：");
        //下面语句等价于上面的语句
        //等价语句开始：---------------------------------
        Map<String, List<Student>> map = students.groupBy(Student::getSex);
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : ");
            List<Student> list = entry.getValue();
            for (Student s : list) {
                System.out.println(s);;
            }
        }
        //等价语句结束：----------------------------------
        System.out.println("\n按年龄段分组：");
        students.groupBy(s -> s.getAge() / 10).forEach((k, v) -> {
            System.out.println(k + " : ");
            v.forEach(System.out::println);
        });
        System.out.println("\n按成绩是否合格分组：");
        students.groupBy(s -> s.getScore() >= 60 ? "合格" : "不合格").forEach((k, v) -> {
            System.out.println(k + " : ");
            v.forEach(System.out::println);
        });
    }

    /**
     * 测试分组求和、计数、平均
     */
    @Test
    public void testGroupSum() {
        System.out.println("\n按性别分组求和：");
        students.groupSum(Student::getSex, Student::getScore)
                .forEach((k, v) -> {
                    System.out.println(k + " :成绩求和： " + v);
        });
        System.out.println("\n按性别分组统计：");
        students.groupCount(Student::getSex).forEach((k, v) -> {
            System.out.println(k + " :计数： " + v);
        });
        System.out.println("\n按性别分组求平均：");
        students.groupAvg(Student::getSex, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩平均： " + v);
        });
    }
    /**
     * 测试分组最大值、最小值，给出分组最大、最小对象
     */
    @Test
    public void testGroupMax() {
        System.out.println("\n按性别分组求最大：");
        students.groupMax(Student::getSex, (s1, s2) -> s1.getScore() - s2.getScore()).forEach((k, v) -> {
            System.out.println(k + " :成绩最大： " + v);
        });
        System.out.println("\n按性别分组求最小：");
        students.groupMin(Student::getSex, (s1, s2) -> s1.getScore() - s2.getScore()).forEach((k, v) -> {
            System.out.println(k + " :成绩最小： " + v);
        });
    }
    /**
     * 测试分组最大值、最少值，直接给出值
     */
    @Test
    public void testGroupMax2() {
        System.out.println("\n按性别分组求最大：");
        students.groupMax(Student::getSex, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩最大： " + v);
        });
        System.out.println("\n按性别分组求最小：");
        students.groupMin(Student::getSex, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩最小： " + v);
        });
    }
    /**
     * 测试分组最大值、最少值，直接给出值
     * 按年龄分组
     */
    @Test
    public void testGroupMax3() {
        System.out.println("\n按年龄分组求最大：");
        students.groupMax(s->s.getAge()/5*5, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩最大： " + v);
        });
        System.out.println("\n按年龄分组求最小：");
        students.groupMin(s->s.getAge()/5*5, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩最小： " + v);
        });
    }
    /**
     * 测试分组求平均2
     * 按年龄分组
     */
    @Test
    public void testGroupAvg() {
        System.out.println("\n按年龄分组求平均：");
        students.groupAvg(s->s.getAge()/10*10, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩平均： " + v);
        });
    }

    /**
     * 测试分组求和2
     * 按年龄分组
     */
    @Test
    public void testGroupSum2() {
        System.out.println("\n----按年龄分组求和：----");
        students.groupBySum(s->s.getAge()/10*10, Student::getScore).forEach((k, v) -> {
            System.out.println(k + " :成绩求和： " + v);
        });
    }

}
