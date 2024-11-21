package cn.jyd.twelve;

/**
 * 线程interrupt方法，example 12_6
 */
public class ClassRoom implements Runnable {
    public Thread getStudent() {
        return student;
    }

    public Thread getTeacher() {
        return teacher;
    }

    private final Thread student;
    private final Thread teacher;
    public ClassRoom(){
        this.teacher = new Thread(this);
        this.teacher.setName("王教授");
        this.student = new Thread(this);
        this.student.setName("小明");
    }
    @Override
    public void run() {
        if (Thread.currentThread() == student) {
            try {
                System.out.println(student.getName() + "学生正在睡觉");
                Thread.sleep(1000 * 60 * 60);
            } catch (InterruptedException e) {
                System.out.println(student.getName() + "被老师叫醒了");
            }
            System.out.println(student.getName() + "开始听课");
        }else if(Thread.currentThread()==teacher){
            for (int i = 0; i < 3; i++) {
                System.out.println("上课");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { }
            }
            student.interrupt();
        }
    }
}
