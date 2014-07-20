/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * 系统的日志工具
 * 
 * @author fengjing.yfj
 * @version $Id: LoggerUtil.java, v 0.1 2014年7月20日 下午3:07:55 fengjing.yfj Exp $
 */
public interface LoggerUtil {
    /**
     * 获取日志工具
     * 
     * @param clz
     * @return
     */
    public LoggerUtil getLogger(Class<?> clz);

    /**
     * 将多个object合并成一个String
     * 
     * @param objs
     * @return
     */
    public String combineToString(Object... objs);

    /**
     * 打印调试信息
     * 
     * @param msg
     * @param throwable
     */
    public void debug(Object msg, Throwable throwable);

    /**
     * 打印调试信息
     * 
     * @param msg
     */
    public void debug(Object msg);

    /**
     * 打印信息
     * 
     * @param msg
     * @param throwable
     */
    public void info(Object msg, Throwable throwable);

    /**
     * 打印信息
     * 
     * @param msg
     */
    public void info(Object msg);

    /**
     * 打印警告信息
     * 
     * @param msg
     * @param throwable
     */
    public void warn(Object msg, Throwable throwable);

    /**
     * 打印调试信息
     * 
     * @param msg
     */
    public void warn(Object msg);

    /**
     * 打印错误信息
     * 
     * @param msg
     * @param throwable
     */
    public void error(Object msg, Throwable throwable);

    /**
     * 打印错误信息
     * 
     * @param msg
     */
    public void error(Object msg);
}
