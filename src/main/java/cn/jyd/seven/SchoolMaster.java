package cn.jyd.seven;

/**
 * 校长类实现接口Work，实现方法planWork()、doWork()、workResult()
 */
public class SchoolMaster implements Work {
    @Override
    public void planWork() {
        System.out.println("校长计划：指定学校工作计划");
    }
    @Override
    public void doWork() {
        System.out.println("校长工作：检查计划完成情况");
    }
    @Override
    public void workResult(String result) {
        System.out.println("校长工作：" + result);
    }
}
