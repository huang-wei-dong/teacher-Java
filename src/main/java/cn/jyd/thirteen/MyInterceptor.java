package cn.jyd.thirteen;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器实现类
 */
public class MyInterceptor implements Interceptor{
    @Override
    public void before(Object instance, String methodName, Object[] params)
            throws InvocationTargetException, IllegalAccessException {
        if(methodName.startsWith("set")){
            System.out.println("设置属性值");
        }
    }
    @Override
    public void after(Object instance, String methodName, Object[] params)
            throws InvocationTargetException, IllegalAccessException {
        if(methodName.startsWith("get")){
            System.out.println("读取属性值");
        }
    }
}
