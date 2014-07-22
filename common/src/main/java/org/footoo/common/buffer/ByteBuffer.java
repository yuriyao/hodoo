/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.buffer;

/**
 * 字节缓存<br>
 * 不是线程安全的
 *  
 * @author fengjing.yfj
 * @version $Id: ByteBuffer.java, v 0.1 2014年7月20日 下午7:31:57 fengjing.yfj Exp $
 */
public class ByteBuffer {
    /** 缓存的空间 */
    private byte[] bytes;
    /** 已使用的数量 */
    private int    used;

    /**
     * 默认的构造器
     */
    public ByteBuffer() {
        bytes = new byte[8];
        used = 0;
    }

    public ByteBuffer(int initLen) {
        bytes = new byte[initLen];
        used = 0;
    }

    /**
     * 添加字节序列，开始为from，长度为length
     * 
     * @param bs
     * @param from
     * @param length
     */
    public void append(byte[] bs, int from, int length) {
        //空间还够
        if (used + length <= bytes.length) {
            System.arraycopy(bs, from, bytes, used, length);
            used += length;
            return;
        }
        //空间不够了
        //计算新申请的空间的大小
        int len = 0;
        if (bytes.length < 1 * 1024) {
            len = 2 * bytes.length;
        } else {
            len = 3 * bytes.length / 2;
        }
        len = len > used + length ? len : used + length;

        byte[] newSpace = new byte[len];

        //保存原有数据
        System.arraycopy(bytes, 0, newSpace, 0, used);
        //添加新的数据
        System.arraycopy(bs, from, newSpace, used, length);
        //使用新的存储空间
        bytes = newSpace;
        used += length;
    }

    /**
     * 添加byte数组
     * 
     * @param bs
     * @param from
     */
    public void append(byte[] bs, int from) {
        append(bs, from, bs.length - from);
    }

    /**
     * 添加byte序列
     * 
     * @param bs
     */
    public void append(byte[] bs) {
        append(bs, 0, bs.length);
    }

    /**
     * 添加字符串
     * 
     * @param str
     */
    public void append(String str) {
        append(str.getBytes());
    }

    /**
     * 清空缓存
     */
    public void clear() {
        used = 0;
    }

    /**
     * 将存储的数据转换为byte数组
     * 
     * @return
     */
    public byte[] toByteArray() {
        byte[] ret = new byte[used];
        System.arraycopy(bytes, 0, ret, 0, used);
        return ret;
    }
}
