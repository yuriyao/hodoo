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
 * 反射工具
 * 
 * @author fengjing.yfj
 * @version $Id: ReflectUtil.java, v 0.1 2014年7月20日 下午4:36:54 fengjing.yfj Exp $
 */
public class ReflectUtil {
    /**
     * 获取类的所有的域
     * 
     * @param obj
     * @return
     */
    public List<Field> getAllFields(Class<?> clz) {
        List<Field> fields = new ArrayList<Field>();
        //添加自身的fields
        for (Field field : clz.getDeclaredFields()) {
            fields.add(field);
        }

        //添加父类的域
        Class<?> clz2 = clz.getSuperclass();
        if (clz2 != null) {
            for (Field field : clz2.getDeclaredFields()) {
                fields.add(field);
            }
        }

        return fields;
    }

    /**
     * 获取clz的所有类型和接口
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
     * 获取object的所有类和接口
     * 
     * @param object
     * @return
     */
    public Set<Class<?>> getTypes(Object object) {
        return getTypes(object.getClass());
    }

    /**
     * 获取对象的所有类
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
     * 获取类的所有的接口
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
        //获取父类的接口
        clz = clz.getSuperclass();
        if (clz != null) {
            clzs.addAll(getInterfaces(clz));
        }
        return clzs;
    }

    /**
     * 获取object对象的所有接口
     * 
     * @param object
     * @return
     */
    public Set<Class<?>> getInterfaces(Object object) {
        return getInterfaces(object.getClass());
    }
}
