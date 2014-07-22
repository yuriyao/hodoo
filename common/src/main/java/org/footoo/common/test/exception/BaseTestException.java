/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.exception;

/**
 * 测试的基本异常
 * 
 * @author fengjing.yfj
 * @version $Id: BaseTestException.java, v 0.1 2014年7月22日 下午10:33:17 fengjing.yfj Exp $
 */
public class BaseTestException extends Exception {

    /**  */
    private static final long serialVersionUID = -7257631271609197848L;

    /**
     * 
     */
    public BaseTestException() {
    }

    /**
     * @param arg0
     */
    public BaseTestException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public BaseTestException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public BaseTestException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public BaseTestException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
