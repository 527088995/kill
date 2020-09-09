package com.debug.kill.log.log;


import com.debug.kill.log.annotation.RedisDb;
import com.debug.kill.log.util.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.TimerTask;


@Component
@DependsOn("springContextHolder")
public class LogTaskFactory {

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);

    private static StringRedisTemplate redisTemplate = RedisDb.getMapper(StringRedisTemplate.class);

    public static TimerTask loginLog(final Long userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    Object loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, null, ip);
                    redisTemplate.opsForList().rightPush("sys_login_log", loginLog.toString());
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                Object loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, null, "账号:" + username + "," + msg, ip);
                try {
                    redisTemplate.opsForList().rightPush("sys_login_log", loginLog.toString());
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Long userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                Object loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, null, ip);
                try {
                    redisTemplate.opsForList().rightPush("sys_login_log", loginLog.toString());
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

    /**
     * 业务日志
     *
     * @param userName
     * @param bussinessName
     * @param clazzName
     * @param methodName
     * @param msg
     * @return
     */
    public static TimerTask bussinessLog(final String sysName, final String sysId, final String userId, final String userName, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                Object operationLog = LogFactory.createOperationLog(
                        LogType.BUSSINESS, sysName, sysId, userName, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {

                    redisTemplate.opsForList().rightPush("sys_operation_log", operationLog.toString());
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    /**
     * 异常日志
     *
     * @param userName
     * @param exception
     * @return
     */
    public static TimerTask exceptionLog(final String sysName, final String sysId, final String userName, final String userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = ToolUtil.getExceptionMsg(exception);
                Object operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, sysName, sysId, userName, userId, "异常日志", null, null, msg, LogSucceed.FAIL);
                try {
                    redisTemplate.opsForList().rightPush("sys_operation_log", operationLog.toString());
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }

}
