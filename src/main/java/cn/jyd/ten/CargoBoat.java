package cn.jyd.ten;
/**example 7-8
 * 货轮
 */
public class CargoBoat {
    int realContent;//实际装载量
    int maxContent;//最大装载量
    public void setMaxContent(int maxContent){
        this.maxContent = maxContent;
    }
    //添加货物
    public void loading(int content) throws DangerException{
        realContent += content;
        if(realContent>maxContent){
            throw new DangerException();
        }
    }
}
