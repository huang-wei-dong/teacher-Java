package cn.jyd.fifteen;

import org.junit.Test;

import java.util.HashMap;

/**
 * 测试Map类.
 */
public class TestMap {
    //测试HashMap
    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "张三");
        map.put("002", "李四");
        System.out.println("map中键为002的元素：" + map.get("002"));
        System.out.println("map中所有键：");
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
    //测试MapPut方法
    @Test
    public void testMapPut() {
        HashMap<String, Double> map = new HashMap<>();
        map.put("001", 0.0);
        map.put("002", 0.0);
        map.put("001", map.getOrDefault("001", 0.0)+80);
        map.put("001", map.getOrDefault("001", 0.0)+90);
        map.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
    }
}
