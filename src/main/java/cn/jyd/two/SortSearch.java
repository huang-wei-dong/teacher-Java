package cn.jyd.two;
//排序和查找
//Example2_5
public class SortSearch {
    //选择排序
    public static void selectSort(int[] arr){
        //循环n轮,每一轮找出最小的一个，放到数组最前面
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            //每一轮找出剩余元素最小的一个
            //记录找出最小值的下标
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //将最小值和i位置的值交换
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    /**折半查找（二分查找）
     * @param arr: 待查找的数组
     *             key: 要查找的元素
     *             return: 如果找到，返回下标，否则返回-1
     */
    public static int binarySearch(int[] arr,int key){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            //选择待比较区间中间的数，和key比较
            int mid=(left+right)/2;
            if(arr[mid]==key){
                return mid;//找到，返回下标
            }else if(arr[mid]>key){//key在mid的左边
                right=mid-1;//右指针向左移
            }else{
                left=mid+1;
            }
        }
        //循环结束，没有找到
        return -1;
    }
}
