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
 * ���в��ԵĻ��࣬���Կ��ʹ�õ���TestNG
 * <ul>
 *  <li>�������ڽ������Ի���</li>
 * </ul>
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestBase.java, v 0.1 2014��7��18�� ����8:03:22 fengjing.yfj Exp $
 */
public class HodooTestBase extends HodooBaseTestConfig {
    /** ��־���� */
    private static final LoggerUtil logger      = LoggerFactory.getLogger(HodooTestBase.class);
    /** ���乤�ߣ�������ܽ���ע�룬ֻ��ֱ�ӳ�ʼ�� */
    private ReflectUtil             reflectUtil = new ReflectUtil();

    /**
     * �������Ի���
     */
    @BeforeClass
    public void setupTestEnvironmet() throws Throwable {
        logger.info("���ڽ�����Ĳ��Ի���");
        //����spring�����ļ�
        ApplicationContext context = new ClassPathXmlApplicationContext(this.getSpringConfigFiles());
        //��ʼ�����е�field
        List<Field> fields = reflectUtil.getAllFields(this.getClass());
        for (Field field : fields) {
            AutoWire autoWire = field.getAnnotation(AutoWire.class);
            if (autoWire != null) {
                //ͨ�����ֲ���
                if (autoWire.value() == AutoWire.BY_NAME) {
                    Object object = context.getBean(field.getName());
                    //û���ҵ�����ӡ������Ϣ
                    if (object == null) {
                        logger.warn("û���ҵ���Ϊ[" + field.getName() + "]��bean");
                    }// �ҵ��ˣ����и�ֵ
                    else {
                        field.setAccessible(true);
                        field.set(this, object);
                    }
                }//ͨ�����Ͳ���
                else {
                    //Ѱ�ҵ�ǰ���͵�bean
                    String[] names = context.getBeanNamesForType(field.getClass());
                    Object object;
                    //�ҵ���
                    if (names != null && names.length >= 1) {
                        object = context.getBean(names[1]);
                        field.setAccessible(true);
                        field.set(this, object);
                    }//û���ҵ����������
                    else {
                        names = context.getBeanDefinitionNames();
                        for (String name : names) {
                            object = context.getBean(name);
                            //���ͷ���
                            if (reflectUtil.getTypes(object).contains(field.getType())) {
                                field.setAccessible(true);
                                field.set(this, object);
                                break;
                            }
                        }
                    }

                }

            }
        }//field�������
    }

    /**
     * ���������ṩ
     * 
     * @param method
     */
    @DataProvider
    public Object[][] jsonDataProvider(Method method) {
        //��ȡ��Ĳ������ݵ�Ŀ¼
        ClassDataDirs classDataDirs = this.getClass().getAnnotation(ClassDataDirs.class);
        String[] dirs = null;
        //�ṩ��ע��,����ע���·��
        if (classDataDirs != null) {
            dirs = classDataDirs.dirs();
        } else {//û���ṩ��ʹ������
            dirs = new String[] { this.getClass().getName() };
        }

        //����ļ���·����
        MethodParamFileName methodParamFileName = method.getAnnotation(MethodParamFileName.class);
        String fileName = null;
        //�ṩ��ע��
        if (methodParamFileName != null) {
            fileName = methodParamFileName.fileName();
        }
        //û�л�ȡ��·��
        if (new StringUtil().isBlank(fileName)) {
            fileName = method.getName();
        }

        //���ز�������
        return null;
    }
}
