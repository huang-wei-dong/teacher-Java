package cn.jyd.five;
// 梯形类
public class Ladder {
    private float above;// 上底
    private float bottom;// 下底
    private float height;// 高
    private float area=0;// 面积

    // 无参构造方法
    public Ladder() {
    }
    // 有两个参数的构造方法
    public Ladder(float above, float bottom) {
        this.above = above;
        this.bottom = bottom;
    }
    // 有三个参数的构造方法
    public Ladder(float above, float bottom, float height) {
        this.above = above;
        this.bottom = bottom;
        this.height = height;
    }
    //计算面积
    public float computeArea() {
        area = (above + bottom) * height / 2;
        return area;
    }

    public float getAbove() {
        return above;
    }

    public void setAbove(float above) {
        this.above = above;
    }

    public float getBottom() {
        return bottom;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
