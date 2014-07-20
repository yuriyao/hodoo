/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test;

/**
 * 获取test环境的配置信息
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestConfig.java, v 0.1 2014年7月18日 下午8:28:30 fengjing.yfj Exp $
 */
public interface HodooTestConfig {
    /**
     * 获取spring配置文件
     * 
     * @return
     */
    public String[] getSpringConfigFiles();

    /**
     * 获取测试数据的目录
     * 
     * @return
     */
    public String[] getTestParamDir();
}
