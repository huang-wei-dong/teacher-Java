package cn.jyd.one;

public class Practice {
    /**统计数组中每个数字出现的次数
     * 数据大小为0-9的整数，否则需要使用HashMap
     */
    public void ex01_04() {
        int arr[] = new int[]{1, 2, 1, 3, 1,7,4, 5,4, 7, 9};
        int numberCount[] = new int[10];
        //用遍历的数字i作为统计数组下标

        for (int i : arr) {
            numberCount[i]++;
        }

        for (int i = 0; i < numberCount.length; i++) {
            System.out.println(i+"出现的次数："+numberCount[i]);
        }
    }
}
