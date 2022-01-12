package com.louis.icemango.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  反射相关辅助
 */
public class ReflectionUtils {


    /**
     * 根据方法名调用指定对象的方法
     * @param object 要调用方法的对象
     * @param method 要调用的方法名
     * @param args 要调用的方法参数对象数组
     * @return
     */
    public static Object invoke(Object object, String method, Object... args){
        Object result = null;
        //? extends Object 上界通配符，是Object类以及它所有的派生类
        Class<? extends Object> clazz = object.getClass();
        Method queryMethod = getMethod(clazz, method, args);
        if(queryMethod != null){
            try{
                //反射调用object中的queryMethod方法，参数args
                result = queryMethod.invoke(object, args);
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (IllegalArgumentException e) {
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }
        }else{
            try {
                throw new NoSuchMethodException(clazz.getName()+" 类中没有找到 "+ method+" 方法。");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 根据方法名和参数对象查找方法
     * @param clazz
     * @param name
     * @param args
     * @return
     */
    private static Method getMethod(Class<? extends Object> clazz, String name, Object[] args) {
        Method queryMethod = null;
        //反射获取所有public的方法，default 对于同包中相当于public
        Method[] methods = clazz.getMethods();
        for(Method method: methods){
            if(method.getName().equals(name)){
                //获取每个方法的参数对象
                Class<?>[] parameterTypes = method.getParameterTypes();
                //对比入参数量，区分重构方法
                if(parameterTypes.length == args.length){
                    boolean isSameMethod = true;
                    //轮询每个参数
                    for(int i=0; i<parameterTypes.length;i++){
                        Object arg = args[i];
                        if(arg == null){
                            arg = "";
                        }
                        //对比参数类型，类型不同，不为需要调用方法
                        if(!parameterTypes[i].equals(args[i].getClass())){
                            isSameMethod = false;
                        }
                    }
                    if(isSameMethod){
                        queryMethod = method;
                        break;
                    }
                }
            }
        }
        return queryMethod;
    }

}
