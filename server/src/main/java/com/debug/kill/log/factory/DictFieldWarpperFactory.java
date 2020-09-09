package com.debug.kill.log.factory;

import com.debug.kill.server.common.constant.factory.ConstantFactory;
import com.debug.kill.server.common.constant.factory.IConstantFactory;

import java.lang.reflect.Method;


public class DictFieldWarpperFactory {


    public static Object createFieldWarpper(Object parameter, String methodName) {
        IConstantFactory constantFactory = ConstantFactory.me();
        try {
            Method method = IConstantFactory.class.getMethod(methodName, parameter.getClass());
            return method.invoke(constantFactory, parameter);
        } catch (Exception e) {
            try {
                Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
                return method.invoke(constantFactory, Integer.parseInt(parameter.toString()));
            } catch (Exception e1) {
                throw new RuntimeException("BizExceptionEnum.ERROR_WRAPPER_FIELD");
            }
        }
    }

}
