package com.debug.kill.log.log;


public class LogFactory {


    /**
     * 创建操作日志
     */
    public static Object createOperationLog(LogType logType, String sysName, String sysId, String userName, String userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        Object operationLog = new Object();
//        operationLog.put("log_type", logType.getMessage());
//        operationLog.put("SYS_NAME", sysName);
//        operationLog.put("SYS_ID", sysId);
//        operationLog.put("USER_NAME", userName);
//        operationLog.put("USER_ID", userId);
//        operationLog.put("log_name", bussinessName);
//        operationLog.put("CLASS_NAME", clazzName);
//        operationLog.put("METHOD", methodName);
//        operationLog.put("CREATE_TIME", new Date());
//        operationLog.put("SUCCEED", succeed.getMessage());
//        if (msg.length() > 800) {
//            msg = msg.substring(0, 800);
//            operationLog.put("MESSAGE", msg);
//        } else {
//            operationLog.put("MESSAGE", msg);
//        }
        return operationLog;
    }

    /**
     * 创建登录日志
     */
    public static Object createLoginLog(LogType logType, Long userId, String userName, String msg, String ip) {
        Object loginLog = new Object();
//        loginLog.put("Log_Name", logType.getMessage());
//        loginLog.put("USER_ID", userId);
//        loginLog.put("USER_NAME", userName);
//        loginLog.put("CREATE_TIME", new Date());
//        loginLog.put("SUCCEED", LogSucceed.SUCCESS.getMessage());
//        loginLog.put("IP", ip);
//        loginLog.put("MESSAGE", msg);
        return loginLog;
    }
}
