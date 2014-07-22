/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.footoo.common.data.util.JsonUtil;
import org.footoo.common.test.exception.ParameterNumberException;

/**
 * 测试参数生成工具,
 * 用来将测试数据列表生成测试json文件
 * 
 * @author fengjing.yfj
 * @version $Id: TestParameterGeneratorUtil.java, v 0.1 2014年7月22日 下午10:38:53 fengjing.yfj Exp $
 */
public class JsonTestParameterGeneratorUtil {
    /** JSON工具 */
    private JsonUtil jsonUtil;

    /**
     * 由参数名列表和参数列表生成测试数据文件的内容
     * 
     * @param paramNames 参数名列表
     * @param params 参数列表
     * @return
     * @throws ParameterNumberException 
     */
    public String generate(String[] paramNames, Object[][] params) throws ParameterNumberException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (Object[] objects : params) {
            if (paramNames.length != objects.length) {
                throw new ParameterNumberException("参数数量不合法");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < paramNames.length; i++) {
                map.put(paramNames[i], objects[i]);
            }
            list.add(map);
        }
        return jsonUtil.ObjectToJsonWithClassName(list);
    }

    /**
     * 由参数名列表和参数列表生成测试数据文件的内容
     * 
     * @param paramNames 参数名列表
     * @param params 参数列表
     * @return
     * @throws ParameterNumberException 
     */
    public String generate(String[] paramNames, List<Object[]> params)
                                                                      throws ParameterNumberException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (Object[] objects : params) {
            if (paramNames.length != objects.length) {
                throw new ParameterNumberException("参数数量不合法");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < paramNames.length; i++) {
                map.put(paramNames[i], objects[i]);
            }
            list.add(map);
        }
        return jsonUtil.ObjectToJsonWithClassName(list);
    }

    /**
     * Setter method for property <tt>jsonUtil</tt>.
     * 
     * @param jsonUtil value to be assigned to property jsonUtil
     */
    public void setJsonUtil(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

}
