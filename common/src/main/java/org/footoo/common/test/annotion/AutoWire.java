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
 * ���������У��Զ���ʼ��Field�ķ�ʽ<br>
 * field�Ŀɼ��Ա�����protected��������public��<br>
 * 
 * @author fengjing.yfj
 * @version $Id: AutoWire.java, v 0.1 2014��7��20�� ����2:30:55 fengjing.yfj Exp $
 */
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AutoWire {
    /**
     *  ͨ�����ֲ��� <br>
     *  ���Կ�ܻ�ͨ��field��������spring�������ļ��в��ң����������field����
     *  ��ʼ��<br>
     */
    public static final int BY_NAME    = 0;

    /**
     * ͨ���ӿڻ���������ͽ��в���<br>
     * ���Կ�ܻ�ͨ��Field��������spring�������ļ��в��ң����������field���и�ֵ<br>
     * 
     */
    public static final int BY_SERVICE = 1;

    /**
     * ʹ�õĲ��ҷ�ʽ
     * 
     * @return
     */
    public int value() default BY_NAME;

}
