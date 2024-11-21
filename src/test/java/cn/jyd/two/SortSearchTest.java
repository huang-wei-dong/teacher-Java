package cn.jyd.two;

import org.junit.Test;

public class SortSearchTest {
    @Test
    public void testSelectSort(){
        int[] arr={8,2,3,9,-3,5,6,7,1,4};
        System.out.println("选择排序前：");
        showArray(arr);
        SortSearch.selectSort(arr);
        System.out.println("选择排序后：");
        showArray(arr);


        System.out.println("选择排序完毕,下面进行折半查找--------------");
        int index= SortSearch.binarySearch(arr,7);
        if(index!=-1){
            System.out.println("找到!位置在："+index);
        }
        else {
            System.out.println("未找到！");
        }
    }

    /**
     * 打印数组
     * @param arr：待打印数组
     */
    private void showArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
}


