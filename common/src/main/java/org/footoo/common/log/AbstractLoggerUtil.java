/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * ʵ��combineToString�����ĳ�����־����
 * 
 * @author fengjing.yfj
 * @version $Id: AbstractLoggerUtil.java, v 0.1 2014��7��20�� ����4:11:12 fengjing.yfj Exp $
 */
public abstract class AbstractLoggerUtil implements LoggerUtil {

    /** 
     * @see org.footoo.common.log.LoggerUtil#combineToString(java.lang.Object[])
     */
    @Override
    public String combineToString(Object... objs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : objs) {
            stringBuilder.append(object);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
