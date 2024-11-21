package cn.jyd.five;

import cn.jyd.Tools.ArrayTools;
import cn.jyd.four.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

/**
 * 测试数组排序函数
 */
public class TestArrayTools {
    /**
     * 测试人员按年龄排序函数
     */
    @Test
    public void testSortPerson(){
        Person[] persons = new Person[]{
                new Person("1111","张三","男", LocalDate.of(1990,1,1)),
                new Person("2222","李四","男",LocalDate.of(1991,2,2)),
                new Person("3333","王五","女",LocalDate.of(1989,3,3)),
                new Person("4444","赵六","男",LocalDate.of(1993,4,4)),
        };
        ArrayTools<Person> arrayTools = new ArrayTools<>(persons);
        Comparator<Person> comparator=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        arrayTools.sort(comparator);
        arrayTools.print();
    }

    /**
     * 测试学生按成绩排序函数
     */
    @Test
    public void testSortStudent(){
        Student[] students = new Student[]{
                new Student("1111","张三","男",LocalDate.of(1990,1,1),90),
                new Student("2222","李四","男",LocalDate.of(1991,2,2),80),
                new Student("3333","王五","女",LocalDate.of(1992,3,3),98),
                new Student("4444","赵六","男",LocalDate.of(1993,4,4),60),
        };
        ArrayTools<Student> arrayTools = new ArrayTools<>(students);

        Comparator<Student> comparator=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
        };
        arrayTools.sort(comparator);
        arrayTools.print();
    }

    /**
     * 测试老师按课时排序函数
     */
    @Test
    public void testSortTeacher(){
        Teacher[] teachers = new Teacher[]{
                new Teacher("1111","张三","男",LocalDate.of(1990,1,1),90),
                new Teacher("2222","李四","男",LocalDate.of(1991,2,2),80),
                new Teacher("3333","王五","女",LocalDate.of(1992,3,3),98),
                new Teacher("4444","赵六","男",LocalDate.of(1993,4,4),60),
        };
        ArrayTools<Teacher> arrayTools = new ArrayTools<>(teachers);
        Comparator<Teacher> comparator=new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getTeachingHours()-o2.getTeachingHours();
            }
        };
        arrayTools.sort(comparator);
        arrayTools.print();
    }
}
