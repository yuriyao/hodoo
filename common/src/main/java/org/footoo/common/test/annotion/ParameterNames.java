/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �����Ĳ�����ע�⣬��Ϊ�����Ĳ�������Ϣ���ܱ��������class�ļ��У�
 * �����޷�����������Ĳ�������������Ҫһ��ע���ṩ�����Ĳ�������Ϣ
 * 
 * @author fengjing.yfj
 * @version $Id: ParameterNames.java, v 0.1 2014��7��22�� ����10:24:42 fengjing.yfj Exp $
 */
@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ParameterNames {
    /**
     * ��ú����Ĳ������б�
     * 
     * @return
     */
    public String[] values() default {};
}
