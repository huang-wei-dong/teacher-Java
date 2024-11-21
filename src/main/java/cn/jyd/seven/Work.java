package cn.jyd.seven;

public interface Work {
    void planWork();// 计划
    void doWork();//
    void workResult(String result);// 工作结果

    /**
     * Java 8以后可以有默认方法，可以有方法体，可以有默认实现，
     *work方法实现了模板的设计模式，也称模板方法
     *模板方法，在方法中定义了算法骨架（算法步骤），而这些步骤延迟到子类中进行实现
     */
    default void work(){
        planWork();
        doWork();
        workResult("工作圆满完成");
    }
}

