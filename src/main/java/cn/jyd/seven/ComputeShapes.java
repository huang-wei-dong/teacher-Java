package cn.jyd.seven;

public class ComputeShapes {
    private Shapes  shapes;
    public ComputeShapes(Shapes shapes) {
        this.shapes = shapes;
    }
    public void showAreaAndPerimeter(){
        if(shapes==null){
            System.out.println("没有图形");
            return;
        }
        System.out.println("面积："+shapes.area()+" 周长："+shapes.perimeter());
    }

    public Shapes getShapes() {
        return shapes;
    }

    public void setShapes(Shapes shapes) {
        this.shapes = shapes;
    }
}
