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
 * һ��������������������ڵ�Ŀ¼<br>
 * ��������಻�ṩ���ע�⣬��ֱ��Ѱ�����������ͬ���ֵ�Ŀ¼
 * 
 * @author fengjing.yfj
 * @version $Id: TestParamDir.java, v 0.1 2014��7��20�� ����1:55:09 fengjing.yfj Exp $
 */
@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClassDataDirs {
    String[] dirs();
}
