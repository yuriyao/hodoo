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
 * 测试用例中，自动初始化Field的方式<br>
 * field的可见性必须是protected，或者是public的<br>
 * 
 * @author fengjing.yfj
 * @version $Id: AutoWire.java, v 0.1 2014年7月20日 下午2:30:55 fengjing.yfj Exp $
 */
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AutoWire {
    /**
     *  通过名字查找 <br>
     *  测试框架会通过field的名字在spring的配置文件中查找，并给对象的field进行
     *  初始化<br>
     */
    public static final int BY_NAME    = 0;

    /**
     * 通过接口或者类的类型进行查找<br>
     * 测试框架会通过Field的类型在spring的配置文件中查找，并给对象的field进行赋值<br>
     * 
     */
    public static final int BY_SERVICE = 1;

    /**
     * 使用的查找方式
     * 
     * @return
     */
    public int value() default BY_NAME;

}
