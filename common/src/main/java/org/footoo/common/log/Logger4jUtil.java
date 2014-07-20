/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

import org.apache.log4j.Logger;

/**
 * 使用log4j封装的日志工具
 * 
 * @author fengjing.yfj
 * @version $Id: Logger4jUtil.java, v 0.1 2014年7月20日 下午4:06:06 fengjing.yfj Exp $
 */
public class Logger4jUtil extends AbstractLoggerUtil {
    /** log4j日志工具 */
    private Logger logger;

    /** 
     * @see org.footoo.common.log.LoggerUtil#getLogger(java.lang.Class)
     */
    @Override
    public LoggerUtil getLogger(Class<?> clz) {
        logger = Logger.getLogger(clz);
        return this;
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#debug(java.lang.Object, java.lang.Throwable)
     */
    @Override
    public void debug(Object msg, Throwable throwable) {
        logger.debug(msg, throwable);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#debug(java.lang.Object)
     */
    @Override
    public void debug(Object msg) {
        logger.debug(msg);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#info(java.lang.Object, java.lang.Throwable)
     */
    @Override
    public void info(Object msg, Throwable throwable) {
        logger.info(msg, throwable);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#info(java.lang.Object)
     */
    @Override
    public void info(Object msg) {
        logger.info(msg);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#warn(java.lang.Object, java.lang.Throwable)
     */
    @Override
    public void warn(Object msg, Throwable throwable) {
        logger.warn(msg, throwable);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#warn(java.lang.Object)
     */
    @Override
    public void warn(Object msg) {
        logger.warn(msg);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#error(java.lang.Object, java.lang.Throwable)
     */
    @Override
    public void error(Object msg, Throwable throwable) {
        logger.error(msg, throwable);
    }

    /** 
     * @see org.footoo.common.log.LoggerUtil#error(java.lang.Object)
     */
    @Override
    public void error(Object msg) {
        logger.error(msg);
    }

}
