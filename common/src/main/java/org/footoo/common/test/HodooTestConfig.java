/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test;

/**
 * ��ȡtest������������Ϣ
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestConfig.java, v 0.1 2014��7��18�� ����8:28:30 fengjing.yfj Exp $
 */
public interface HodooTestConfig {
    /**
     * ��ȡspring�����ļ�
     * 
     * @return
     */
    public String[] getSpringConfigFiles();

    /**
     * ��ȡ�������ݵ�Ŀ¼
     * 
     * @return
     */
    public String[] getTestParamDir();
}
