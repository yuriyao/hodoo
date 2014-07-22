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
 * ���Բ������ɹ���,
 * ���������������б����ɲ���json�ļ�
 * 
 * @author fengjing.yfj
 * @version $Id: TestParameterGeneratorUtil.java, v 0.1 2014��7��22�� ����10:38:53 fengjing.yfj Exp $
 */
public class JsonTestParameterGeneratorUtil {
    /** JSON���� */
    private JsonUtil jsonUtil;

    /**
     * �ɲ������б�Ͳ����б����ɲ��������ļ�������
     * 
     * @param paramNames �������б�
     * @param params �����б�
     * @return
     * @throws ParameterNumberException 
     */
    public String generate(String[] paramNames, Object[][] params) throws ParameterNumberException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (Object[] objects : params) {
            if (paramNames.length != objects.length) {
                throw new ParameterNumberException("�����������Ϸ�");
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
     * �ɲ������б�Ͳ����б����ɲ��������ļ�������
     * 
     * @param paramNames �������б�
     * @param params �����б�
     * @return
     * @throws ParameterNumberException 
     */
    public String generate(String[] paramNames, List<Object[]> params)
                                                                      throws ParameterNumberException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (Object[] objects : params) {
            if (paramNames.length != objects.length) {
                throw new ParameterNumberException("�����������Ϸ�");
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
