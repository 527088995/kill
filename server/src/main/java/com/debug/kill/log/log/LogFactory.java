package com.debug.kill.log.log;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LogFactory {


    /**
     * 创建操作日志
     */
    public static Map<String, Object> createOperationLog(LogType logType, String appName, String appKey, String userName, String userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        Map<String, Object> operationLog = new HashMap<>();
        operationLog.put("LOG_TYPE", logType.getMessage());
        operationLog.put("SYS_NAME", appName);
        operationLog.put("SYS_ID", appKey);
        operationLog.put("USER_NAME", userName);
        operationLog.put("USER_ID", userId);
        operationLog.put("LOG_NAME", bussinessName);
        operationLog.put("CLASS_NAME", clazzName);
        operationLog.put("METHOD", methodName);
        operationLog.put("CREATE_TIME", new Date());
        operationLog.put("SUCCEED", succeed.getMessage());
        if (msg.length() > 800) {
            msg = msg.substring(0, 800);
            operationLog.put("MESSAGE", msg);
        } else {
            operationLog.put("MESSAGE", msg);
        }
        return operationLog;
    }

    /**
     * 创建登录日志
     */
    public static Map<String, Object> createLoginLog(LogType logType, String appName, String appKey, Long userId, String userName, String msg, String ip) {
        Map<String, Object> loginLog = new HashMap<>();
        loginLog.put("SYS_NAME", appName);
        loginLog.put("SYS_ID", appKey);
        loginLog.put("LOG_NAME", logType.getMessage());
        loginLog.put("USER_ID", userId);
        loginLog.put("USER_NAME", userName);
        loginLog.put("CREATE_TIME", new Date());
        loginLog.put("SUCCEED", LogSucceed.SUCCESS.getMessage());
        loginLog.put("IP", ip);
        loginLog.put("MESSAGE", msg);
        return loginLog;
    }
}
