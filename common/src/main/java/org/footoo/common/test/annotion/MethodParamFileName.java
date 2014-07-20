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
 * 测试函数的参数的文件名,文件名是json文件，不用写在fileName的返回值里面<br>
 * 如果没有提供，则使用测试函数的名字<br>
 * 参数的形式是json，比如参数是:String name, int age, String from,并且有三组测试用例：
 * json数据如下：
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
 * @version $Id: MethodParamFileName.java, v 0.1 2014年7月20日 下午2:08:29 fengjing.yfj Exp $
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
public @interface MethodParamFileName {
    public String fileName();
}
