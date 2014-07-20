/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test;

/**
 * 
 * @author fengjing.yfj
 * @version $Id: HodooBaseTestConfig.java, v 0.1 2014年7月18日 下午8:32:03 fengjing.yfj Exp $
 */
public class HodooBaseTestConfig implements HodooTestConfig {

    /** 
     * @see org.footoo.common.test.HodooTestConfig#getSpringConfigFiles()
     */
    @Override
    public String[] getSpringConfigFiles() {
        return new String[] { "spring/*.xml" };
    }

    @Override
    public String[] getTestParamDir() {
        return null;
    }

}
