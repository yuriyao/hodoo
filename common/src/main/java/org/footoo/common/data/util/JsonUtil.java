/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.data.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON����
 * 
 * @author fengjing.yfj
 * @version $Id: JsonUtil.java, v 0.1 2014��7��20�� ����11:38:42 fengjing.yfj Exp $
 */
public class JsonUtil {
    /**
     * ת��ΪObject
     * 
     * @param str
     * @return
     */
    public Object JsonToObject(String str, Class<?> clz) {
        return JSON.parseObject(str, clz);
    }

    /**
     * ���л�object������obj��������Ϣ
     * 
     * @param obj
     * @return
     */
    public String ObjectToJsonWithClassName(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.WriteClassName,
            SerializerFeature.PrettyFormat);
    }

    /**
     * ��objectת��Ϊjson����
     * 
     * @param obj
     * @return
     */
    public String ObjectToJson(Object obj) {
        return JSON.toJSONString(obj, SerializerFeature.PrettyFormat);
    }
}
