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
 * ���в��ԵĻ��࣬���Կ��ʹ�õ���TestNG
 * <ul>
 *  <li>�������ڽ������Ի���</li>
 *  <li>���е�Field������ͨ��ע����г�ʼ������Ϊ����಻�����õ�spring�����ļ���</li>
 *  <li>���������ͨ��AutoWireע�����Field��ע��</li>
 * </ul>
 * 
 * @author fengjing.yfj
 * @version $Id: HodooTestBase.java, v 0.1 2014��7��18�� ����8:03:22 fengjing.yfj Exp $
 */
public class HodooTestBase extends HodooBaseTestConfig {
    /** ��־���� */
    private static final LoggerUtil logger          = LoggerFactory.getLogger(HodooTestBase.class);
    /** ���乤�ߣ�������ܽ���ע�룬ֻ��ֱ�ӳ�ʼ�� */
    private ReflectUtil             reflectUtil     = new ReflectUtil();
    /** ϵͳ���� */
    private SystemUtil              systemUtil      = new SystemUtil();
    /** ���������� */
    private InputStreamUtil         inputStreamUtil = new InputStreamUtil();
    /** JSON���� */
    private JsonUtil                jsonUtil        = new JsonUtil();

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
     * @throws IOException 
     */
    @DataProvider
    public Object[][] jsonDataProvider(Method method) throws IOException {
        //��ȡ��Ĳ������ݵ�Ŀ¼
        ClassDataDirs classDataDirs = this.getClass().getAnnotation(ClassDataDirs.class);
        String[] dirs = null;
        //�ṩ��ע��,����ע���·��
        if (classDataDirs != null) {
            dirs = classDataDirs.dirs();
        } else {//û���ṩ��ʹ������
            dirs = new String[] { this.getClass().getSimpleName() };
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
        //��Ӻ�׺��
        fileName += ".json";
        //���
        List<Object[]> objs = new ArrayList<Object[]>();
        //���ز�������
        for (String dir : dirs) {
            //��ò�����ע����Ϣ
            ParameterNames parameterNames = method.getAnnotation(ParameterNames.class);
            //�����������Ϸ�
            if (parameterNames.values() == null
                || parameterNames.values().length != method.getParameterCount()) {
                throw new ParameterException("�޷��������ԵĲ�����Ϣ����Ϊ�����������Ϸ�");
            }

            InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream(systemUtil.toFullPath(dir, fileName));
            if (in == null) {
                logger.warn("û���ҵ��ļ�[" + systemUtil.toFullPath(dir, fileName));
                continue;
            }
            //��ȡ�������ݵ�������
            String string = inputStreamUtil.readFull(in);
            //���ز������ݣ�����ΪList�Ľṹ
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> params = (List<Map<String, Object>>) jsonUtil.JsonToObject(
                string, List.class);
            //�����������ɶ����������
            for (Map<String, Object> paramMap : params) {
                //Ϊÿһ����������һ�в���
                Object[] paramOneLine = new Object[method.getParameterCount()];
                for (int i = 0; i < method.getParameterCount(); i++) {
                    //logger.debug("paramName:" + parameter.getName());
                    paramOneLine[i] = paramMap.get(parameterNames.values()[i]);
                }
                objs.add(paramOneLine);
            }
        }
        //���ս��
        Object[][] ret = new Object[objs.size()][];
        for (int i = 0; i < objs.size(); i++) {
            ret[i] = objs.get(i);
        }
        //logger.debug(jsonUtil.ObjectToJson(ret));
        return ret;
    }
}
