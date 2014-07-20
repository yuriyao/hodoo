/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * 日志工具
 * 
 * @author fengjing.yfj
 * @version $Id: LoggerFactory.java, v 0.1 2014年7月20日 下午2:56:41 fengjing.yfj Exp $
 */
public class LoggerFactory {
    /**
     * 获取日志工具
     * 
     * @param clz
     * @return
     */
    public static LoggerUtil getLogger(Class<?> clz) {
        //只支持log4j
        return new Logger4jUtil().getLogger(clz);
    }
}
