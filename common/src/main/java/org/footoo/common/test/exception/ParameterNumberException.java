/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.exception;

/**
 * 参数数量异常
 * 
 * @author fengjing.yfj
 * @version $Id: ParameterNumberException.java, v 0.1 2014年7月22日 下午10:34:21 fengjing.yfj Exp $
 */
public class ParameterNumberException extends BaseTestException {

    /**  */
    private static final long serialVersionUID = 5182523957622873994L;

    /**
     * 
     */
    public ParameterNumberException() {
    }

    /**
     * @param arg0
     */
    public ParameterNumberException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public ParameterNumberException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public ParameterNumberException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public ParameterNumberException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
