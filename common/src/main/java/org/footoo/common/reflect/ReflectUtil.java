/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ���乤��
 * 
 * @author fengjing.yfj
 * @version $Id: ReflectUtil.java, v 0.1 2014��7��20�� ����4:36:54 fengjing.yfj Exp $
 */
public class ReflectUtil {
    /**
     * ��ȡ������е���
     * 
     * @param obj
     * @return
     */
    public List<Field> getAllFields(Class<?> clz) {
        List<Field> fields = new ArrayList<Field>();
        //��������fields
        for (Field field : clz.getDeclaredFields()) {
            fields.add(field);
        }

        //��Ӹ������
        Class<?> clz2 = clz.getSuperclass();
        if (clz2 != null) {
            for (Field field : clz2.getDeclaredFields()) {
                fields.add(field);
            }
        }

        return fields;
    }

    /**
     * ��ȡclz���������ͺͽӿ�
     * 
     * @param clz
     * @return
     */
    public Set<Class<?>> getTypes(Class<?> clz) {
        Set<Class<?>> clzs = new HashSet<Class<?>>();

        clzs.add(clz);
        for (Class<?> i : clz.getInterfaces()) {
            clzs.add(i);
        }

        clz = clz.getSuperclass();
        if (clz != null) {
            clzs.addAll(getTypes(clz));
        }
        return clzs;
    }

    /**
     * ��ȡobject��������ͽӿ�
     * 
     * @param object
     * @return
     */
    public Set<Class<?>> getTypes(Object object) {
        return getTypes(object.getClass());
    }

    /**
     * ��ȡ�����������
     * 
     * @param object
     * @return
     */
    public Set<Class<?>> getClasses(Object object) {
        Set<Class<?>> clzs = new HashSet<Class<?>>();

        Class<?> clz = object.getClass();
        while (clz != null) {
            clzs.add(clz);
            clz = clz.getSuperclass();
        }

        return clzs;
    }

    /**
     * ��ȡ������еĽӿ�
     * 
     * @param clz
     * @return
     */
    public Set<Class<?>> getInterfaces(Class<?> clz) {
        Set<Class<?>> clzs = new HashSet<Class<?>>();

        Class<?>[] interfaces = clz.getInterfaces();
        for (Class<?> i : interfaces) {
            clzs.add(i);
        }
        //��ȡ����Ľӿ�
        clz = clz.getSuperclass();
        if (clz != null) {
            clzs.addAll(getInterfaces(clz));
        }
        return clzs;
    }

    /**
     * ��ȡobject��������нӿ�
     * 
     * @param object
     * @return
     */
    public Set<Class<?>> getInterfaces(Object object) {
        return getInterfaces(object.getClass());
    }
}
