package com.debug.kill.log.util;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Description:
 */
public class HttpContext {

    public HttpContext() {
    }

    public static String getIp() {
        HttpServletRequest request = getRequest();
        return request == null ? "127.0.0.1" : request.getRemoteHost();
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getResponse();
    }

    public static Object getSession() {
        HttpServletRequest request = getRequest();
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("USER_SESSION_KEY_DATA_ROW");
        return user;
    }

    public static Object getRequestParameters() {
        Map<String, Object> values = new HashMap();
        List<Map<String, Object>> mapList = new ArrayList<>();
        HttpServletRequest request = getRequest();
        if (request == null) {
            return mapList;
        } else {
            Enumeration enums = request.getParameterNames();
            if (enums.hasMoreElements()) {
                while (enums.hasMoreElements()) {
                    String paramName = (String) enums.nextElement();
                    String paramValue = request.getParameter(paramName);
                    values.put(paramName, paramValue);
                }
                mapList.add(values);
            }
            return mapList;
        }
    }
}
