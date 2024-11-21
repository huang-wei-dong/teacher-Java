package cn.jyd.seven;
/**
*教工类实现接口Work，实现方法planWork，doWork，workResult
 */
public class Staff implements Work {
    @Override
    public void planWork() {
        System.out.println("教工计划工作：检查教学设备");
    }
    @Override
    public void doWork() {
        System.out.println("教工做工作：维修损坏的教学设备");
    }
    @Override
    public void workResult(String result) {
        System.out.println("教工工作完成，结果为："+result);
    }
}
