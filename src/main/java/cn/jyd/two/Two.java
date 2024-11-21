package cn.jyd.two;

public class Two {
    public void getMax(){
        int a=1;
        int b=2;
        int c=3;
        int max = a;
        if(b>max){
            max = b;
        }
        if(c>max){
            max = c;
        }
        System.out.println("max="+max);
    }
    //根据考试成绩给出等级
    public void getGrade(){
        int score = 90;
        if(score>=90){
            System.out.println("A");
        }else if(score>=80){
            System.out.println("B");
        }else if(score>=70){
            System.out.println("C");
        }else if(score>=60){
            System.out.println("D");
        }else{
            System.out.println("E");
        }
    }
    //根据考试成绩给出等级，采用switch语句
    public void getGradeBySwitch(){
        int score = 90;
        switch(score/10){
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
               System.out.println("E");
        }
    }
    //理解Coutinue语句
    public void getContinue(){
        for(int i=0;i<10;i++){
            if(i%2==0){
                continue;
            }
            System.out.print(i);
            System.out.print(",");
        }
    }

    //理解break
    public void getBreak(){
        for(int i=0;i<10;i++){
            if(i==5){
                break;
            }
            System.out.print(i);
            System.out.print(",");
        }
    }

    //从数组中找出奇数
    public void getOdd(){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                continue;
            }
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }
    //求绝对值
    public void getAbs(){
        int a = -10;
        if(a<0){
            a = -a;
        }
        System.out.println("abs="+a);
    }
}
