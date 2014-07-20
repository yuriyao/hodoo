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
 * ���Ժ����Ĳ������ļ���,�ļ�����json�ļ�������д��fileName�ķ���ֵ����<br>
 * ���û���ṩ����ʹ�ò��Ժ���������<br>
 * ��������ʽ��json�����������:String name, int age, String from,�������������������
 * json�������£�
 * [
 *  {
 *      name : 'jeff',
 *      age : 22,
 *      from : 'hz'
 *  },
 *  {
 *      name : 'yuri',
 *      age : 23,
 *      from : 'bh'
 *  },
 *  {
 *      name : 'yao',
 *      age : 23,
 *      from : 'hrb'
 *  }
 * ]
 * 
 * @author fengjing.yfj
 * @version $Id: MethodParamFileName.java, v 0.1 2014��7��20�� ����2:08:29 fengjing.yfj Exp $
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
public @interface MethodParamFileName {
    public String fileName();
}
