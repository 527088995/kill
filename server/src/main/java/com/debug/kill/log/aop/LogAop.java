/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.debug.kill.log.aop;


import com.debug.kill.log.annotation.BussinessLog;
import com.debug.kill.log.annotation.PropertiesEnv;
import com.debug.kill.log.base.AbstractDictMap;
import com.debug.kill.log.factory.LogObjectHolder;
import com.debug.kill.log.log.LogManager;
import com.debug.kill.log.log.LogTaskFactory;
import com.debug.kill.log.util.Contrast;
import com.debug.kill.log.util.HttpContext;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 日志记录
 */
@Aspect
@Component
public class LogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PropertiesEnv propertiesEnv;

    @Pointcut(value = "@annotation(com.debug.kill.log.annotation.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        //如果当前用户未登录，不做日志
        Map<String, Object> user = (Map<String, Object>) HttpContext.getSession();
        if (null == user.get("USERNAME").toString()) {
            return;
        }

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();

        //获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();
        String type = annotation.type();
        Class dictClass = annotation.dict();

        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(" & ");
        }

        //如果涉及到修改,比对变化
        String msg = "";
        String bussinessNames = "";
        Object request = LogObjectHolder.me().get();
        List<Map<String, Object>> obj1 = new ArrayList<>();
        if (request instanceof List) {
            obj1 = (List<Map<String, Object>>) request;
        }
        if (request instanceof Map) {
            Map<String, Object> dataRow = (Map<String, Object>) request;
            obj1.add(dataRow);
        }
        //当前描述
        AbstractDictMap dictMap = (AbstractDictMap) dictClass.newInstance();
        //传参
        Object requestParameters = HttpContext.getRequestParameters();
        List<Map<String, Object>> set = (List<Map<String, Object>>) requestParameters;
        if (set.size() > 0) {
            for (Map<String, Object> parameters : set) {
                Object keys = parameters.get(key);
                if (BussinessType.ADD_EDIT_STATUS.equals(type)) {
                    if (StringUtils.isNoneEmpty(keys.toString())) {
                        for (Map<String, Object> dataRow : obj1) {
                            msg = Contrast.contrastObj(dictMap, key, dataRow, parameters, propertiesEnv.getClassPath());
                            bussinessNames = bussinessName + "修改";
                        }
                    } else {
                        msg = Contrast.parseMutiKey(dictMap, key, parameters, propertiesEnv.getClassPath());
                        bussinessNames = bussinessName + "新增";
                    }
                }
                if (BussinessType.DELETE_STATUS.equals(type)) {
                    for (Map<String, Object> dataRow : obj1) {
                        msg = Contrast.contrastObj(dictMap, key, dataRow, parameters, propertiesEnv.getClassPath());
                        bussinessNames = bussinessName;
                    }
                }
                //log.info("[记录日志][RESULT:{}]", "user.getId()" + bussinessName + className + methodName + msg);
                LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.get("OPENID").toString(), user.get("USERNAME").toString(), bussinessNames, className, methodName, msg));
            }
        }

    }

}
