/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * ϵͳ����־����
 * 
 * @author fengjing.yfj
 * @version $Id: LoggerUtil.java, v 0.1 2014��7��20�� ����3:07:55 fengjing.yfj Exp $
 */
public interface LoggerUtil {
    /**
     * ��ȡ��־����
     * 
     * @param clz
     * @return
     */
    public LoggerUtil getLogger(Class<?> clz);

    /**
     * �����object�ϲ���һ��String
     * 
     * @param objs
     * @return
     */
    public String combineToString(Object... objs);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     * @param throwable
     */
    public void debug(Object msg, Throwable throwable);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     */
    public void debug(Object msg);

    /**
     * ��ӡ��Ϣ
     * 
     * @param msg
     * @param throwable
     */
    public void info(Object msg, Throwable throwable);

    /**
     * ��ӡ��Ϣ
     * 
     * @param msg
     */
    public void info(Object msg);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     * @param throwable
     */
    public void warn(Object msg, Throwable throwable);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     */
    public void warn(Object msg);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     * @param throwable
     */
    public void error(Object msg, Throwable throwable);

    /**
     * ��ӡ������Ϣ
     * 
     * @param msg
     */
    public void error(Object msg);
}
