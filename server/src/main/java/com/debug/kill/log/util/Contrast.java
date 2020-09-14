package com.debug.kill.log.util;



import cn.hutool.core.date.DateUtil;
import com.debug.kill.log.base.AbstractDictMap;
import com.debug.kill.log.factory.DictFieldWarpperFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 对比两个对象的变化的工具类
 */
public class Contrast {


    //记录每个修改字段的分隔符
    public static final String separator = ";;;";


    /**
     * 比较两个对象pojo1和pojo2,并输出不一致信息
     */
    public static String contrastObj(AbstractDictMap dictMap, String key, Map<String, Object> pojo1, Map<String, Object> pojo2, String classPath) {
        String keyValue = pojo2.get(key).toString();
        String str = dictMap.get(key) + "=" + keyValue + separator;
        try {
            Set set = pojo1.keySet();
            Iterator it = set.iterator();
            int i = 1;
            while (it.hasNext()) {
                String keys = (String) it.next();

                Object o1 = pojo1.get(keys);
                Object o2 = pojo2.get(keys);
                if (o1 == null || o2 == null) {
                    continue;
                }
                if (o1 instanceof Date) {
                    o1 = DateUtil.date((Date) o1);
                } else if (o1 instanceof Integer) {
                    o2 = Integer.parseInt(o2.toString());
                }
                if (!o1.toString().equals(o2.toString())) {
                    if (i != 1) {
                        str += separator;
                    }
                    String fieldName = dictMap.get(keys);
                    String fieldWarpperMethodName = dictMap.getFieldWarpperMethodName(keys);
                    if (fieldWarpperMethodName != null) {
                        Object o1Warpper = DictFieldWarpperFactory.createFieldWarpper(o1, fieldWarpperMethodName, classPath);
                        Object o2Warpper = DictFieldWarpperFactory.createFieldWarpper(o2, fieldWarpperMethodName, classPath);
                        str += "字段名称:" + fieldName + ",旧值:" + o1Warpper + ",新值:" + o2Warpper;
                    } else {
                        str += "字段名称:" + fieldName + ",旧值:" + o1 + ",新值:" + o2;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    /**
     * 解析多个key(逗号隔开的)
     */
    public static String parseMutiKey(AbstractDictMap dictMap, String key, Map<String, Object> requests, String classPath) throws ClassNotFoundException {
        Set set = requests.keySet();
        Iterator it = set.iterator();
        StringBuilder sb = new StringBuilder();
        if (key.indexOf(",") != -1) {
            String[] keys = key.split(",");
            for (String item : keys) {
                String fieldWarpperMethodName = dictMap.getFieldWarpperMethodName(item);
                String value = requests.get(item).toString();
                if (fieldWarpperMethodName != null) {
                    Object valueWarpper = DictFieldWarpperFactory.createFieldWarpper(value, fieldWarpperMethodName, classPath);
                    sb.append(dictMap.get(item) + "=" + valueWarpper + ",");
                } else {
                    sb.append(dictMap.get(item) + "=" + value + ",");
                }
            }
            return StrKit.removeSuffix(sb.toString(), ",");
        } else {
            while (it.hasNext()) {
                String keys = (String) it.next();
                String value = requests.get(keys).toString();
                String fieldWarpperMethodName = dictMap.getFieldWarpperMethodName(keys);
                if (fieldWarpperMethodName != null) {
                    Object valueWarpper = DictFieldWarpperFactory.createFieldWarpper(value, fieldWarpperMethodName, classPath);
                    sb.append("字段名称:" + dictMap.get(keys) + "=" + valueWarpper + "," + separator);
                } else {
                    sb.append("字段名称:" + dictMap.get(keys) + "=" + value + separator);
                }
            }
            return sb.toString();
        }
    }

}
