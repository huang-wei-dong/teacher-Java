package cn.jyd.fifteen;

import cn.jyd.TestInit;
import cn.jyd.five.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试流.
 */
public class TestStream {
    /**
     * 测试流的基本用法
     */
    @Test
    public void testStream() {
        Student[] students = TestInit.initStudent();
        List< Student > list = Arrays.stream(students)
                .sorted((o1, o2)-> -(o1.getScore()-o2.getScore()))
                .filter(s->s.getAge()>20)
                .limit(5)
                        .toList();

        list.forEach(Student::showWithScore);
    }
    /**
     * 测试流的groupBy用法
     */
    @Test
    public void testGroupBy() {
        Student[] students = TestInit.initStudent();
        Map<String,List<Student>  > map = Arrays.stream(students)
                .collect(Collectors.groupingBy(Student::getSex));

        map.forEach((k,v)->{
            System.out.println(k+" : ");
            v.forEach(Student::showWithScore);
        });
    }
    /**
     * 测试流的groupBy后采用复合收集器用法
     * 统计每个性别的分数，人数，年龄
     */
    @Test
    public void testGroupBy2() {
        Student[] students = TestInit.initStudent();
        Map<String,Map<Integer,Long>> map = Arrays.stream(students)
                .collect(Collectors.groupingBy(Student::getSex,//按性别分组
                        Collectors.groupingBy(Student::getAge,//再按年龄分组
                                Collectors.counting())));//统计人数

        map.forEach((k,v)->{
            System.out.println(k+" : ");//性别
            v.forEach((k1,v1)->{//年龄，计数
                System.out.println(k1+" : "+v1);
            });
        });
    }
    /**
     * 测试流的groupBy后采用复合收集器用法
     * 统计每个性别平均分数
     */
    @Test
    public void testGroupBy3() {
        Student[] students = TestInit.initStudent();
        Map<String,Double> map = Arrays.stream(students)
                .collect(Collectors.groupingBy(Student::getSex,//按性别分组
                   Collectors.averagingDouble(Student::getScore)));//统计分数和

        map.forEach((k,v)->{
            System.out.println(k+" : "+v);
        });
    }
    /**
     * 使用 groupingBy 与 reducing 结合
     * 如果需要对分组后的每个子集进行进一步的聚合操作，可以使用 reducing 方法。
     * reducing 方法接受一个函数，该函数用于将两个元素合并成一个元素。
     * reducing 方法返回一个 Optional 对象，其中包含合并后的元素。
     * 本程序统计每个性别的最高分数
     */
    @Test
    public void testGroupingByReducing() {
        Student[] students = TestInit.initStudent();
        Map<String,Optional<Student>> maxScoreStudent = Arrays.stream(students)
                .collect(Collectors.groupingBy(Student::getSex,
                        Collectors.reducing((s1,s2)-> s1.getScore()>s2.getScore()?s1:s2)));

        maxScoreStudent.forEach((sex,optionalStudent)->{
            System.out.println(sex+"同学 最高成绩:"+optionalStudent.orElseGet(null));
            System.out.println("最高成绩为："+optionalStudent.get().getScore());
        });
    }
}
