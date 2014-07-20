/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.lang.util;

/**
 * 字符串工具
 * 
 * @author fengjing.yfj
 * @version $Id: StringUtil.java, v 0.1 2014年7月20日 下午7:16:58 fengjing.yfj Exp $
 */
public class StringUtil {

    /**
     * 是否是空字符串<br>
     * 当字符串为null，或者长度为0时返回true
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
     * 字符串是否是空白字符串
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
     * 是否是空白字符
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
