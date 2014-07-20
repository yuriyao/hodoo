/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.lang.util;

/**
 * �ַ�������
 * 
 * @author fengjing.yfj
 * @version $Id: StringUtil.java, v 0.1 2014��7��20�� ����7:16:58 fengjing.yfj Exp $
 */
public class StringUtil {

    /**
     * �Ƿ��ǿ��ַ���<br>
     * ���ַ���Ϊnull�����߳���Ϊ0ʱ����true
     * 
     * @param str
     * @return
     */
    public boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * �ַ����Ƿ��ǿհ��ַ���
     * 
     * @param str
     * @return
     */
    public boolean isBlank(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        for (char c : str.toCharArray()) {
            if (!isBlank(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * �Ƿ��ǿհ��ַ�
     * 
     * @param c
     * @return
     */
    public boolean isBlank(char c) {
        if (c == '\t' || c == ' ' || c == '\r' || c == '\n' || c == '\0') {
            return true;
        }
        return false;
    }

}
