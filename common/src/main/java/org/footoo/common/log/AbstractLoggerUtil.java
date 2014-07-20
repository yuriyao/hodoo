/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * 实现combineToString方法的抽象日志工具
 * 
 * @author fengjing.yfj
 * @version $Id: AbstractLoggerUtil.java, v 0.1 2014年7月20日 下午4:11:12 fengjing.yfj Exp $
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
