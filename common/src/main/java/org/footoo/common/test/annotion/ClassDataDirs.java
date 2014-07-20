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
 * 一个测试类的所有数据所在的目录<br>
 * 如果测试类不提供这个注解，就直接寻找与测试类相同名字的目录
 * 
 * @author fengjing.yfj
 * @version $Id: TestParamDir.java, v 0.1 2014年7月20日 下午1:55:09 fengjing.yfj Exp $
 */
@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ClassDataDirs {
    String[] dirs();
}
