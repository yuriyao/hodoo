/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.buffer;

/**
 * 字节缓存
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
        }
        //空间不够了
        int len = 0;
        if (bytes.length < 1 * 1024) {
            len = 2 * bytes.length;
        } else {
            len = 3 * bytes.length / 2;
        }
    }
}
