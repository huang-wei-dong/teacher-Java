package cn.jyd.thirteen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 拦截器接口
 */
public interface Interceptor {
    public default Object proxy(Object instance, String methodName, Object... params)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> cs =instance.getClass() ;// 获取类
        Class<?>[] paramClasses = new Class[params.length];// 获取参数类型数组
        for (int i = 0; i < params.length; i++) {
            paramClasses[i] = params[i].getClass();
        }
        Method method = cs.getMethod(methodName, paramClasses);// 获取方法
        before(instance, methodName, params);//调用方法前拦截
        Object result = method.invoke(instance, params);//调用对象方法
        after(instance, methodName, params);//调用方法后拦截
        return result;
    };
    //前置拦截
    public void before(Object instance, String methodName, Object[] params)
            throws InvocationTargetException, IllegalAccessException;
    //后置拦截
    public void after(Object instance, String methodName, Object[] params)
            throws InvocationTargetException, IllegalAccessException;
}
