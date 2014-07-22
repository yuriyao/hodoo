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
 * 函数的参数名注解，因为函数的参数名信息不能保存在类的class文件中，
 * 导致无法反射出函数的参数名，所以需要一个注解提供函数的参数名信息
 * 
 * @author fengjing.yfj
 * @version $Id: ParameterNames.java, v 0.1 2014年7月22日 下午10:24:42 fengjing.yfj Exp $
 */
@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ParameterNames {
    /**
     * 获得函数的参数名列表
     * 
     * @return
     */
    public String[] values() default {};
}
