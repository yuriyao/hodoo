/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.footoo.common.data.util.JsonUtil;
import org.footoo.common.lang.util.StringUtil;
import org.footoo.common.log.LoggerFactory;
import org.footoo.common.log.LoggerUtil;
import org.footoo.common.reflect.ReflectUtil;
import org.footoo.common.stream.util.InputStreamUtil;
import org.footoo.common.system.util.SystemUtil;
import org.footoo.common.test.annotion.AutoWire;
import org.footoo.common.test.annotion.ClassDataDirs;
import org.footoo.common.test.annotion.MethodParamFileName;
import org.footoo.common.test.annotion.ParameterNames;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.beust.jcommander.ParameterException;

/**
 * 所有测试的基类，测试框架使用的是TestNG
 * <ul>
 *  <li>本类用于建立测试环境</li>
 *  <li>所有的Field都不能通过注入进行初始化，因为这个类不会配置到spring配置文件中</li>
 *  <li>其子类可以通过AutoWire注解进行Field的注入</li>
 * </ul>
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestBase.java, v 0.1 2014年7月18日 下午8:03:22 fengjing.yfj Exp $
 */
public class HodooTestBase extends HodooBaseTestConfig {
    /** 日志工具 */
    private static final LoggerUtil logger          = LoggerFactory.getLogger(HodooTestBase.class);
    /** 反射工具，这个不能进行注入，只能直接初始化 */
    private ReflectUtil             reflectUtil     = new ReflectUtil();
    /** 系统工具 */
    private SystemUtil              systemUtil      = new SystemUtil();
    /** 输入流工具 */
    private InputStreamUtil         inputStreamUtil = new InputStreamUtil();
    /** JSON工具 */
    private JsonUtil                jsonUtil        = new JsonUtil();

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
     * @throws IOException 
     */
    @DataProvider
    public Object[][] jsonDataProvider(Method method) throws IOException {
        //获取类的测试数据的目录
        ClassDataDirs classDataDirs = this.getClass().getAnnotation(ClassDataDirs.class);
        String[] dirs = null;
        //提供了注解,试用注解的路径
        if (classDataDirs != null) {
            dirs = classDataDirs.dirs();
        } else {//没有提供，使用类名
            dirs = new String[] { this.getClass().getSimpleName() };
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
        //添加后缀名
        fileName += ".json";
        //结果
        List<Object[]> objs = new ArrayList<Object[]>();
        //加载测试数据
        for (String dir : dirs) {
            //获得参数名注解信息
            ParameterNames parameterNames = method.getAnnotation(ParameterNames.class);
            //参数数量不合法
            if (parameterNames.values() == null
                || parameterNames.values().length != method.getParameterCount()) {
                throw new ParameterException("无法建立测试的参数信息，因为参数数量不合法");
            }

            InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream(systemUtil.toFullPath(dir, fileName));
            if (in == null) {
                logger.warn("没有找到文件[" + systemUtil.toFullPath(dir, fileName));
                continue;
            }
            //获取测试数据的输入流
            String string = inputStreamUtil.readFull(in);
            //加载测试数据，解析为List的结构
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> params = (List<Map<String, Object>>) jsonUtil.JsonToObject(
                string, List.class);
            //多组数据生成多组测试数据
            for (Map<String, Object> paramMap : params) {
                //为每一组数据生成一行参数
                Object[] paramOneLine = new Object[method.getParameterCount()];
                for (int i = 0; i < method.getParameterCount(); i++) {
                    //logger.debug("paramName:" + parameter.getName());
                    paramOneLine[i] = paramMap.get(parameterNames.values()[i]);
                }
                objs.add(paramOneLine);
            }
        }
        //最终结果
        Object[][] ret = new Object[objs.size()][];
        for (int i = 0; i < objs.size(); i++) {
            ret[i] = objs.get(i);
        }
        //logger.debug(jsonUtil.ObjectToJson(ret));
        return ret;
    }
}
