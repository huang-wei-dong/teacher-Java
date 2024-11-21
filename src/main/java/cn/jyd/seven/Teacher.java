package cn.jyd.seven;
/**
 * 老师类，实现Work接口，完成备课，完成授课，等到工作结果
 */
public class Teacher implements Work {
    @Override
    public void planWork() {
        System.out.println("老师计划：备课，准备PPT");
    }
    @Override
    public void doWork() {System.out.println("老师工作：授课，批改作业");
    }
    @Override
    public void workResult(String result) {System.out.println("老师工作结果："+result);
    }
}
