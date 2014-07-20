/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.log;

/**
 * ��־����
 * 
 * @author fengjing.yfj
 * @version $Id: LoggerFactory.java, v 0.1 2014��7��20�� ����2:56:41 fengjing.yfj Exp $
 */
public class LoggerFactory {
    /**
     * ��ȡ��־����
     * 
     * @param clz
     * @return
     */
    public static LoggerUtil getLogger(Class<?> clz) {
        //ֻ֧��log4j
        return new Logger4jUtil().getLogger(clz);
    }
}
