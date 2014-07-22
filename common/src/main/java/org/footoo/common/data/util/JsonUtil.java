/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.data.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON工具
 * 
 * @author fengjing.yfj
 * @version $Id: JsonUtil.java, v 0.1 2014年7月20日 下午11:38:42 fengjing.yfj Exp $
 */
public class JsonUtil {
    /**
     * 转换为Object
     * 
     * @param str
     * @return
     */
    public Object JsonToObject(String str, Class<?> clz) {
        return JSON.parseObject(str, clz);
    }

    /**
     * 序列化object，带有obj的类型信息
     * 
     * @param obj
     * @return
     */
    public String ObjectToJsonWithClassName(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.WriteClassName,
            SerializerFeature.PrettyFormat);
    }

    /**
     * 将object转换为json数据
     * 
     * @param obj
     * @return
     */
    public String ObjectToJson(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.PrettyFormat);
    }
}
