package com.debug.kill.log.factory;

import java.lang.reflect.Method;

public class DictFieldWarpperFactory {


    public static Object createFieldWarpper(Object parameter, String methodName, String classPath) throws ClassNotFoundException {


        Class classType = Class.forName(classPath);
        try {
            Method method = classType.getMethod(methodName, parameter.getClass());
            Object o = method.invoke(classType.newInstance(), parameter);
            return o;
        } catch (Exception e) {
            try {
                Method method = classType.getMethod(methodName, Integer.class);
                return method.invoke(classType.newInstance(), Integer.parseInt(parameter.toString()));
            } catch (Exception e1) {
                throw new RuntimeException("BizExceptionEnum.ERROR_WRAPPER_FIELD");
            }
        }
    }

}
