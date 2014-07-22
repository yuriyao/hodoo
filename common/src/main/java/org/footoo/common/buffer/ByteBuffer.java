/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.buffer;

/**
 * �ֽڻ���<br>
 * �����̰߳�ȫ��
 *  
 * @author fengjing.yfj
 * @version $Id: ByteBuffer.java, v 0.1 2014��7��20�� ����7:31:57 fengjing.yfj Exp $
 */
public class ByteBuffer {
    /** ����Ŀռ� */
    private byte[] bytes;
    /** ��ʹ�õ����� */
    private int    used;

    /**
     * Ĭ�ϵĹ�����
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
     * ����ֽ����У���ʼΪfrom������Ϊlength
     * 
     * @param bs
     * @param from
     * @param length
     */
    public void append(byte[] bs, int from, int length) {
        //�ռ仹��
        if (used + length <= bytes.length) {
            System.arraycopy(bs, from, bytes, used, length);
            used += length;
            return;
        }
        //�ռ䲻����
        //����������Ŀռ�Ĵ�С
        int len = 0;
        if (bytes.length < 1 * 1024) {
            len = 2 * bytes.length;
        } else {
            len = 3 * bytes.length / 2;
        }
        len = len > used + length ? len : used + length;

        byte[] newSpace = new byte[len];

        //����ԭ������
        System.arraycopy(bytes, 0, newSpace, 0, used);
        //����µ�����
        System.arraycopy(bs, from, newSpace, used, length);
        //ʹ���µĴ洢�ռ�
        bytes = newSpace;
        used += length;
    }

    /**
     * ���byte����
     * 
     * @param bs
     * @param from
     */
    public void append(byte[] bs, int from) {
        append(bs, from, bs.length - from);
    }

    /**
     * ���byte����
     * 
     * @param bs
     */
    public void append(byte[] bs) {
        append(bs, 0, bs.length);
    }

    /**
     * ����ַ���
     * 
     * @param str
     */
    public void append(String str) {
        append(str.getBytes());
    }

    /**
     * ��ջ���
     */
    public void clear() {
        used = 0;
    }

    /**
     * ���洢������ת��Ϊbyte����
     * 
     * @return
     */
    public byte[] toByteArray() {
        byte[] ret = new byte[used];
        System.arraycopy(bytes, 0, ret, 0, used);
        return ret;
    }
}
