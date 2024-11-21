package cn.jyd.ten;
/**example 7-8
 * 货船超载操作异常
 */
public class DangerException extends Exception {
    private final String message="货船已满，超载";
    public String warnMess() {
        return message;
    }
}
