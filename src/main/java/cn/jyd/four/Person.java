package cn.jyd.four;

import cn.jyd.seven.Work;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public  class  Person implements Serializable, Work {
    // 成员变量，也称为属性
    private String cardId;// 身份证号
    private String name;
    private String sex;
    private LocalDate birthday;
    private Address address;//家庭住址

    @Override
    public void planWork() {
        System.out.println("普通人计划工作");
    }

    @Override
    public void doWork() {
        System.out.println("普通人工作");
    }

    @Override
    public void workResult(String result) {
        System.out.println("普通人工作完成，工作结果："+result);
    }

    // 内部类,地址
    final class Address{
        private String street;//街道
        private String city;//城市
        private String province;//省份
        private static final String country="中国";
        public  Address(String street, String city, String province) {
            this.street = street;
            this.city = city;
            this.province = province;
            setCity(city);
        }

        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", province='" + province + '\'' +
                    '}';
        }
    }
    // 静态变量,记录人口总数
    private static int count=0;

    // 静态方法，获取人口总数
    public static int getCount(){
        return count;
    }

    // 无参构造方法
    public Person() {
        count++;
    }
    //部分参数 构造方法
    public Person(String cardId, String name,
                  String sex, LocalDate birthday) {
        this.cardId = cardId;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        count++;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        //是否合法
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if(birthday==null){
            return;
        }else {
            this.birthday = birthday;
        }
    }
    // 计算年龄
    public int getAge(){
        int real=(int)birthday.until(LocalDate.now(), ChronoUnit.YEARS);
        int result=real;
        if(real>40){
            result=real-10;
        }
        return (int) result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cardId='" + cardId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", age=" + getAge() +
                "}";
    }
    public void showMessage(){
        System.out.println(this.toString());
    }
    // 重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cardId, person.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cardId);
    }
}
