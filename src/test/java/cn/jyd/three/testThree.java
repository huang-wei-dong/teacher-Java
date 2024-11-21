package cn.jyd.three;
import cn.jyd.Tools.ArrayTools;
import org.junit.Test;

public class testThree {
    @Test
    public void testMaxAndMin(){
        Three three = new Three();
        three.getMaxAndMin();
    }
    @Test
    public void testWhile(){
        Three three = new Three();
        three.getWhile();
    }
    @Test
    public void testFor(){
        Three three = new Three();
        three.getFor();
    }
    @Test
    public void testDoWhile(){
        Three three = new Three();
        three.getDoWhile();
    }
    @Test
    public void testEnhanceFor(){
        Three three = new Three();
        three.getExtendFor();
    }
    @Test
    public void testDelete(){
        Three three = new Three();
        int[] arr = {1,2,3,4,5,6};
        three.remove(arr,3);
        ArrayTools.print(arr);
    }

    @Test
    public void testIndex(){
        Three three = new Three();
        int[] arr = {1,2,3,4,5,6};
        System.out.println(three.getIndex(arr,3));
    }

    /**
     * 理解二维数组
     * 二维数组的每一个元素都是一个一维数组
     */
    @Test
    public void testTwoDimArray(){
        int[] a={10,20,30,40},b[]={{1,2}, {4,5,6,7}};
        System.out.println("b.length="+b.length);
        System.out.println("b[0].length="+b[0].length);
        System.out.println("-------数组b被改变后-------");
        b[0]=a;
        b[0][1]=b[1][3];
        System.out.println("b[0][3]="+b[0][3]);//40
        System.out.println("a[1]="+a[1]);//7
    }
    /**
     * 测试indexOf()方法
     */
    @Test
    public void testIndexOf(){
        Three three = new Three();
        int[] arr = {9,1,2,3,4,5,6};
        System.out.println(three.indexOf(arr,3));
    }

    /**
     * 测试两个数组的交集
     */
    @Test
    public void testIntersection(){
        Three three = new Three();
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {3,2,7,5,4,6,8};
        int[] result = three.intersection(arr1,arr2);
        ArrayTools.print(result);
    }
    /**
     * 测试猴子选大王
     */
    @Test
    public void testKing(){
        Three three = new Three();
        three.king(13,3);
    }
    /**
     * 输出100内完数
     */
    @Test
    public void testPerfectNumber() {
        Three three = new Three();
        for (int i = 1; i <= 100; i++)
            if (three.isPerfectNumber(i)) {
                System.out.println(i);
            }
    }
}
