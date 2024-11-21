package cn.jyd.fifteen;

import cn.jyd.seven.Condition;
import java.util.*;

/**
 * 扩展集合的常用方法
 * 提供集合的排序sort、筛选where、分组groupBy，汇总sum、avg、max、min操作
 * @author 黄卫东
 * @date 2018/12/26 0026 15:06
 */
public class ExCollection<E> implements Collection<E> {
    /**
     * 实现了Collection接口的类实例变量，作为扩展集合核心成员
     * Collection方法均委托给collection完成
     */
    private Collection<E> collection;

    //构造函数
    public ExCollection(){
        this.collection = new ArrayList<>();
    }
    public ExCollection(E[] array){
        this.collection = new ArrayList<>();
        Collections.addAll(collection, array);
    }
    public ExCollection(Collection<E> collection){
        this.collection = collection;
    }

    /**
     * 集合显示
     */
    public ExCollection<E> print(){
        System.out.println("-------------集合显示开始-----------------");
        collection.forEach(System.out::println);
        System.out.println("-------------集合显示结束----------------");
        return this;
    }
    public ExCollection<E> print(String message){
        System.out.println(message);
        return this.print();
    }

    @Override
    public int size() {
        return collection.size();
    }
    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }
    @Override
    public Iterator<E> iterator() {
        return collection.iterator();
    }
    @Override
    public Object[] toArray() {
        return collection.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return collection.toArray(a);
    }
    //通过成员变量提供的方法实现Collection接口方法
    @Override
    public boolean add(E e) {
        return collection.add(e);
    }
    @Override
    public boolean remove(Object o) {
        return collection.remove(o);
    }
    @Override
    public boolean contains(Object o) {
        return collection.contains(o);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return collection.contains(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return collection.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return collection.removeAll(c);
    }
    // 交集，删除不在c中的元素
    @Override
    public boolean retainAll(Collection<?> c) {
        return collection.retainAll(c);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E getIndexOf(int index){
        return collection.stream().skip(index).findFirst().get();
    }

    /**
     * 排序
     * @param comparator 比较器
     * @return 排序后的结果
     */
    public ExCollection<E> sort(Comparator<E> comparator){
        ArrayList<E> arrayList;
        if(!(collection instanceof ArrayList)){
            arrayList = new ArrayList<>(collection.size());
            arrayList.addAll(collection);;
        }else {
            arrayList = (ArrayList<E>) collection;
        }
        arrayList.sort(comparator);
        collection=arrayList;
        return this;
    }
    /**
     * 条件筛选
     * @param condition 筛选条件
     * @return 满足条件的筛选结果
     */
    public ExCollection<E> where(Condition<E> condition){
        ExCollection<E> result = new ExCollection<>();
        for(E e : collection){
            if(condition.accept(e)){
                result.add(e);
            }
        }
        return result;
    }
    /**
     * 返回集合中最大值1233
     * @param getNumber 获取数值的函数
     * @return 集合中由getNumber指定的最大值
     */
    public double max(GetNumber<E> getNumber){
        double max = Double.MIN_VALUE;
        for(E e : collection){
            double num = getNumber.getNumber(e);
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    /**
     * 通过比较器获取最大值
     * @param comparator 比较器
     * @return 最大元素
     */
    public E max(Comparator<E> comparator){
        E max = collection.iterator().next();
        for(E e : collection){
            if(comparator.compare(e, max) > 0){
                max = e;
            }
        }
        return max;
    }

    /**
     * 最小值
     * @param getNumber 获取数值的函数
     * @return 最小值
     */
    public double min(GetNumber<E> getNumber){
        double min = Double.MAX_VALUE;
        for(E e : collection){
            double num = getNumber.getNumber(e);
            if(num < min){
                min = num;
            }
        }
        return min;
    }
    /**
     * 通过比较器获取最小值
     * @param comparator 比较器
     * @return 最小元素
     */
    public E min(Comparator<E> comparator){
        E min = collection.iterator().next();
        for(E e : collection){
            if(comparator.compare(e, min) < 0){
                min = e;
            }
        }
        return min;
    }
    /**
     * 平均值
     * @param getNumber 获取数值的函数
     * @return 平均值
     */
    public double avg(GetNumber<E> getNumber){
        return this.sum(getNumber)/collection.size();
    }
    /**
     * 汇总
     * @param getNumber 获取数值的函数
     * @return 汇总结果
     */
    public double sum(GetNumber<E> getNumber){
        double sum = 0;
        for(E e : collection){
            double num = getNumber.getNumber(e);
            sum += num;
        }
        return sum;
    }
    /**
     * 实现groupBy功能
     */
    public <T> Map<T,List<E>> groupBy(GetKey<T,E> getKey){
        Map<T,List<E>> map = new HashMap<>();
        for(E e : collection){
            T key = getKey.getKey(e);
            List<E> list = map.computeIfAbsent(key,k-> new ArrayList<>());
            list.add(e);
        }
        return map;
    }

    /**
     * 实现分组功能
     * @return 分组结果
     * @param <T> 分组类型
     * @getKey 分组关键字接口
     */
    public <T> Map<T, ExCollection<E>> groupBy2(GetKey<T,E> getKey){
        Map<T,ExCollection<E>> map = new HashMap<>();
        for(E e : collection){
            T key = getKey.getKey(e);
            ExCollection<E> list = map.computeIfAbsent(key,k-> new ExCollection<>());
            list.add(e);
        }
        return map;
    }
    /**
     * 分组计数
     */
    public <T> Map<T,Integer> groupCount(GetKey<T,E> getKey){
        Map<T,Integer> map = new HashMap<>();
        for(E e : collection){
            T key = getKey.getKey(e);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return map;
    }
    /**
     * 分组汇总
     */
    public <T> Map<T, Double> groupSum(GetKey<T,E> getKey, GetNumber<E> getNumber){
        Map<T,Double> map = new HashMap<>();
        for(E e : collection){
            T key = getKey.getKey(e);
            map.put(key,map.getOrDefault(key,0.0)+getNumber.getNumber(e));
        }
        return map;
       // return groupStats(getKey, getNumber, "sum");
    }
    /**
     * 分组求平均值
     */
    public <T> Map<T, Double> groupAvg(GetKey<T,E> getKey, GetNumber<E> getNumber){
        Map<T,Double> map = new HashMap<>();
        groupBy2(getKey).forEach((k,v)->map.put(k,v.sum(getNumber)/v.size()));
        return map;
        //return groupStats(getKey, getNumber, "avg");
    }
    /**
     * 分组求最大对象
     * @param getKey 分组函数
     *        comparator 比较器
     * @return 分组最大对象
     */
    public <T> Map<T, E> groupMax(GetKey<T,E> getKey, Comparator<E> comparator){
        return groupMaxOrMin(getKey, comparator, "max");
    }
    /**
     * 分组求最小对象
     * @param getKey 分组函数
     *        comparator 比较器
     *  return 分组最小对象
     */
    public <T> Map<T, E> groupMin(GetKey<T,E> getKey, Comparator<E> comparator){
        return groupMaxOrMin(getKey, comparator, "min");
    }
    /**
     * 分组最大或最小
     * @param getKey 分组函数
     *        comparator 比较器
     *        method "max" or "min"
     * return 分组最大对象或最小对象
     */
    private <T> Map<T, E> groupMaxOrMin(GetKey<T, E> getKey, Comparator<E> comparator, String method) {
        Map<T, E> map = new HashMap<>();
        Map<T, List<E>> mapGroup = this.groupBy(getKey);
        for(Map.Entry<T,List<E>> entry : mapGroup.entrySet()){
            if(method.equals("max")){
                map.put(entry.getKey()
                        ,new ExCollection<E>(entry.getValue()).max(comparator));
            }else if(method.equals("min")){
                map.put(entry.getKey()
                        ,new ExCollection<E>(entry.getValue()).min(comparator));
            }
        }
        return map;
    }

    /**
     * 分组最大
     * @param getKey 分组函数
     *        getNumber 获取数值的函数
     * @return 分组最大值
     */
    public <T> Map<T, Double> groupMax(GetKey<T,E> getKey, GetNumber<E> getNumber){
        Map<T, Double> map = new HashMap<>();
        for(E e : collection){
            T key = getKey.getKey(e);
            double value=getNumber.getNumber(e);
            map.put(key, Math.max(map.getOrDefault(key, value),value));
        }
        return map;
        //return groupStats(getKey, getNumber, "max");
    }
    /**
     * 分组最小
     * @param getKey 分组函数
     *        getNumber 获取数值的函数
     * @return 分组最小值
     */
    public <T> Map<T, Double> groupMin(GetKey<T, E> getKey, GetNumber<E> getNumber) {
        return groupStats(getKey, getNumber, "min");
    }
    /**
     * 分组统计
     * @param getKey 分组函数
     * @param getNumber 获取数值的函数
     * @param method "sum" or "max" or "min" or "avg"
     * @return 分组总和、最大、最小值、平均值
     */
    private <T> Map<T, Double> groupStats(GetKey<T,E> getKey, GetNumber<E> getNumber, String method){
        Map<T, Double> map = new HashMap<>();
        Map<T, List<E>> mapGroup = this.groupBy(getKey);
        double value = 0.0d;
        for(Map.Entry<T,List<E>> entry : mapGroup.entrySet()){
            if("max".equals(method)) {
                value = new ExCollection<E>(entry.getValue()).max(getNumber);
            }else if("min".equals(method)) {
                value = new ExCollection<E>(entry.getValue()).min(getNumber);
            }else if("sum".equals(method)){
                value = new ExCollection<E>(entry.getValue()).sum(getNumber);
            }else if("avg".equals(method)){
                value = new ExCollection<E>(entry.getValue()).sum(getNumber)/entry.getValue().size();
            }
            map.put(entry.getKey(), value);
        }
        return map;
    }

    /**
     * 分组求和
     */
    public <T> Map<T, Double> groupBySum(GetKey<T,E> getKey, GetNumber<E> getNumber) {
        Map<T, Double> map = new HashMap<>();
        groupBy2(getKey).forEach((k,v)->map.put(k,v.sum(getNumber)));
        return map;
    }
}
