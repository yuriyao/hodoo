/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.footoo.common.lang.util.StringUtil;
import org.footoo.common.log.LoggerFactory;
import org.footoo.common.log.LoggerUtil;
import org.footoo.common.reflect.ReflectUtil;
import org.footoo.common.test.annotion.AutoWire;
import org.footoo.common.test.annotion.ClassDataDirs;
import org.footoo.common.test.annotion.MethodParamFileName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

/**
 * 所有测试的基类，测试框架使用的是TestNG
 * <ul>
 *  <li>本类用于建立测试环境</li>
 * </ul>
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestBase.java, v 0.1 2014年7月18日 下午8:03:22 fengjing.yfj Exp $
 */
public class HodooTestBase extends HodooBaseTestConfig {
    /** 日志工具 */
    private static final LoggerUtil logger      = LoggerFactory.getLogger(HodooTestBase.class);
    /** 反射工具，这个不能进行注入，只能直接初始化 */
    private ReflectUtil             reflectUtil = new ReflectUtil();

    /**
     * 创建测试环境
     */
    @BeforeClass
    public void setupTestEnvironmet() throws Throwable {
        logger.info("正在建立类的测试环境");
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(this.getSpringConfigFiles());
        //初始化所有的field
        List<Field> fields = reflectUtil.getAllFields(this.getClass());
        for (Field field : fields) {
            AutoWire autoWire = field.getAnnotation(AutoWire.class);
            if (autoWire != null) {
                //通过名字查找
                if (autoWire.value() == AutoWire.BY_NAME) {
                    Object object = context.getBean(field.getName());
                    //没有找到，打印警告信息
                    if (object == null) {
                        logger.warn("没有找到名为[" + field.getName() + "]的bean");
                    }// 找到了，进行赋值
                    else {
                        field.setAccessible(true);
                        field.set(this, object);
                    }
                }//通过类型查找
                else {
                    //寻找当前类型的bean
                    String[] names = context.getBeanNamesForType(field.getClass());
                    Object object;
                    //找到了
                    if (names != null && names.length >= 1) {
                        object = context.getBean(names[1]);
                        field.setAccessible(true);
                        field.set(this, object);
                    }//没有找到，找子类的
                    else {
                        names = context.getBeanDefinitionNames();
                        for (String name : names) {
                            object = context.getBean(name);
                            //类型符合
                            if (reflectUtil.getTypes(object).contains(field.getType())) {
                                field.setAccessible(true);
                                field.set(this, object);
                                break;
                            }
                        }
                    }

                }

            }
        }//field设置完毕
    }

    /**
     * 进行数据提供
     * 
     * @param method
     */
    @DataProvider
    public Object[][] jsonDataProvider(Method method) {
        //获取类的测试数据的目录
        ClassDataDirs classDataDirs = this.getClass().getAnnotation(ClassDataDirs.class);
        String[] dirs = null;
        //提供了注解,试用注解的路径
        if (classDataDirs != null) {
            dirs = classDataDirs.dirs();
        } else {//没有提供，使用类名
            dirs = new String[] { this.getClass().getName() };
        }

        //获得文件的路径名
        MethodParamFileName methodParamFileName = method.getAnnotation(MethodParamFileName.class);
        String fileName = null;
        //提供了注解
        if (methodParamFileName != null) {
            fileName = methodParamFileName.fileName();
        }
        //没有获取到路径
        if (new StringUtil().isBlank(fileName)) {
            fileName = method.getName();
        }

        //加载测试数据
        return null;
    }
}
