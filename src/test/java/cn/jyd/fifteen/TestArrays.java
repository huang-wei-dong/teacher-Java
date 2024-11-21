package cn.jyd.fifteen;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestArrays {
    /**
     * 测试Arrays的常用方法
     */
    @Test
    public void testArrays() {
        int[] array = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = Arrays.copyOf(array, 5);
        System.out.println(Arrays.toString(array2));
        Arrays.fill(array2, 0);
        System.out.println(Arrays.toString(array2));
        Arrays.sort(array, 0, 6);
        System.out.println(Arrays.toString(array));
    }
}
