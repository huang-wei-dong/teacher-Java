package cn.jyd.Thirteen;

import cn.jyd.five.Student;
import cn.jyd.five.Teacher;
import cn.jyd.four.Person;
import cn.jyd.thirteen.Interceptor;
import cn.jyd.thirteen.MyInterceptor;
import org.junit.Test;

import java.lang.reflect.*;
import java.time.LocalDate;

/**
 * 测试Class类
 */
public class TestClass {
    /**
     * 测试Class类,Example 8_23
     */
    @Test
    public void testClass() throws ClassNotFoundException {
        Student student = new Student();
        Class<? extends Student> cs = student.getClass();
        System.out.println(cs==Student.class);
        String className = cs.getName();
        Constructor[] constructors = cs.getDeclaredConstructors();
        Field[] fields = cs.getDeclaredFields();
        Method[] methods = cs.getDeclaredMethods();
        System.out.println("类的名字："+className);
        System.out.println("类的构造方法：");
        for (Constructor constructor : constructors){
            System.out.println("构造方法："+constructor);
        }
        System.out.println("类的成员变量：");
        for (Field field : fields){
            System.out.println("类的成员变量："+field);
        }
        System.out.println("类的成员方法：");
        for (Method method : methods){
            System.out.println("类的成员方法："+method);
        }
    }
    /**
     * 测试通过反射获取实例,Example 8_24
     */
    @Test
    public void testNewInstance() throws ClassNotFoundException
            , InstantiationException, IllegalAccessException
            , NoSuchMethodException, InvocationTargetException {
        // 依据类名获取类，类名必须包含包名称
        Class<?> cs = Class.forName("cn.jyd.five.Student");
        // 获取无参构造方法
        Constructor<?> constructor = cs.getDeclaredConstructor();
        // 通过无参构造方法创建对象
        Student student = (Student) constructor.newInstance();
        student.setName("张三");
        student.setCardId("111");
        student.setSex("男");
        student.setBirthday(LocalDate.of(2002,8,1));
        student.show();
    }

    /**
     * 测试通过类名和反射机制获取实例
     */
    private Object getInstance(String className) throws ClassNotFoundException
            , InstantiationException, IllegalAccessException
            , NoSuchMethodException, InvocationTargetException {
        Class<?> cs = Class.forName(className);
        Constructor<?> constructor = cs.getDeclaredConstructor();
        return constructor.newInstance();
    }
    /**
     * 测试通过反射
     * 获取实例，Example 8_25
     */
    @Test
    public void testGetInstance() throws ClassNotFoundException
            , InstantiationException, IllegalAccessException
            , NoSuchMethodException, InvocationTargetException {
        Student student = (Student)  getInstance("cn.jyd.five.Student");
        student.setName("张三");
        student.setCardId("111");
        student.setSex("男");
        student.setBirthday(LocalDate.of(2002,8,1));
        student.showWithScore();
    }
    /**
     * 测试通过反射获取方法，实现多态
     */
    @Test
    public void testGetMethod() throws ClassNotFoundException
            , NoSuchMethodException, InvocationTargetException
            , InstantiationException, IllegalAccessException {
        // Person类
        Person p= (Person) getInstance("cn.jyd.four.Person");
        p.setName("李四");
        p.setCardId("222");
        p.setSex("女");
        p.setBirthday(LocalDate.of(2003,9,1));
        p.showMessage();
        // Student类
        p = (Student) getInstance("cn.jyd.five.Student");
        p.setName("张三");
        p.setCardId("111");
        p.setSex("男");
        p.setBirthday(LocalDate.of(2002,8,1));
        p.showMessage();
        // Teacher类
        p= (Teacher) getInstance("cn.jyd.five.Teacher");
        p.setName("王五");
        p.setCardId("333");
        p.setSex("男");
        ((Teacher)p).setTeachingHours(40);
        p.setBirthday(LocalDate.of(2004,10,1));
        p.showMessage();
    }

    /**
     * 测试通过反射调用方法
     */
    @Test
    public void testInvokeMethod() throws ClassNotFoundException
            , NoSuchMethodException, InvocationTargetException
            , InstantiationException, IllegalAccessException {
        Person p= (Person) getInstance("cn.jyd.four.Person");
        p.setName("李四");
        p.setCardId("222");
        p.setSex("女");
        p.setBirthday(LocalDate.of(2003,9,1));
        Class<?> cs = p.getClass();
        Method method = cs.getDeclaredMethod("setName", String.class);
        method.invoke(p, "王五");
        Method method1 = cs.getDeclaredMethod("showMessage");
        method1.invoke(p);
    }
    /**
     * 测试通过代理调用方法，增强程序功能
     */
    @Test
    public void testProxy()
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Student s=new Student();
        /**创建拦截器
         * 通过拦截器调用方法，可以增强程序功能
         */
        Interceptor interceptor=new MyInterceptor();//
        interceptor.proxy(s,"setName","张山");
        interceptor.proxy(s,"setSex","男");
        interceptor.proxy(s,"setBirthday",LocalDate.of(2002,8,1));
        String name = interceptor.proxy(s,"getName").toString();
        System.out.println("学生姓名："+name);
        interceptor.proxy(s,"show");
    }


}
