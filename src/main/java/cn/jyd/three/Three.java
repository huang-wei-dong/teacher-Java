package cn.jyd.three;

//求数组中的最大最小值
public class Three {
    public void getMaxAndMin() {
        int arr[] = {7, 2, 3, 4, 10, 6, 3, 8, 9, 5};
        ;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max=" + max + ",Min=" + min);
    }

    //演示while循环
    public void getWhile() {
        int i = 0;
        while (i < 10) {
            System.out.print("i=" + i);
            System.out.print(",");
            i++;
        }
    }

    //用for循环，求8+88+888+...+8888888，前8项和
    public void getFor() {
        int sum = 0;
        int item = 8;
        for (int i = 1; i <= 8; i++) {
            System.out.print(item);
            System.out.println();
            sum += item;
            item = item * 10 + 8;
        }
        System.out.println("sum=" + sum);
    }

    //do while 示例
    public void getDoWhile() {
        int i = 0;
        do {
            System.out.print("i=" + i);
            System.out.print(",");
            i++;
        } while (i < 10);
    }

    //增强for循环
    public void getExtendFor() {
        int arr[] = {1, 2, 3, 4, 5, 6};
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    /**
     * 查找数组中某个元素出现的位置*
     * @param arr 待查找的数组
     * @param key 要查找的元素
     * @return 找到的下标，没有找到返回-1
     * @author 黄卫东
     */
    public int getIndex(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 删除数组中某个元素
     *
     * @param arr 待删除的数组
     *            key 要删除的元素
     *            return 删除成功返回true，否则返回false
     * @author 黄卫东
     */
    public boolean remove(int[] arr, int key) {
        int index = getIndex(arr, key);
        if (index == -1) {
            return false;
        } else {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            return true;
        }
    }

    /**
     * 查找数组中某个元素出现的位置
     *
     * @param arr 待查找的数组
     * @param key 要查找的元素
     * @return 找到的下标，没有找到返回-1
     * @author 黄卫东
     */
    public int indexOf(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 求两个数组的交集
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 两个数组的交集
     * @author 黄卫东
     */
    public int[] intersection(int[] arr1, int[] arr2) {
        int minLength = Math.min(arr1.length, arr2.length);
        int[] result = new int[minLength];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (indexOf(arr2, arr1[i]) != -1) {
                result[index++] = arr1[i];
            }
        }
        int[] intersection=new int[index];
        for (int i = 0; i < index; i++) {
            intersection[i]=result[i];
        }
        return intersection;
    }

    /**
     * 猴子选大王游戏，猴子0~n，拍成一个圈，
     * 从1开始报数，报到3的猴子出列被淘汰，
     * 后续猴子重新从0开始报数，最后剩下的猴子就是大王。
     * @param monkeyNum 猴子数量
     *        outCount 报数出列数
     */
    public void king(int monkeyNum,int outCount) {
        int[] monkeys = new int[monkeyNum];
        //初始化猴子数组，每个位置都有猴子用1表示存在
        //猴子出列后设置为0
        for (int i = 0; i < monkeyNum; i++) {
            monkeys[i] = 1;
        }
        int i = 0;              //循环报数
        int count = 0;          //报数计数
        int outMonkeyNum = 0;   //出列猴数
        while (outMonkeyNum < monkeyNum) {
            int currentIndex = i % monkeyNum;//当前下标
            count += monkeys[currentIndex];
            if (count == outCount) {
                System.out.print(currentIndex+",");//输出出列猴子的下标
                monkeys[currentIndex] = 0;//猴子出列设置为0
                outMonkeyNum++;//出列猴数加一
                count = 0;//重置报数为0
            }
            i++;
        }
    }
    /**
     * 求一个数是否完数
     * 完数：一个数如果恰好等于它的因子和，这个数被称为完数
     */
    public boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if(num % i == 0){
                sum += i;
            }
        }
        return sum == num;
    }
}
