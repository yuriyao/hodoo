/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.buffer;

/**
 * �ֽڻ���
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
        }
        //�ռ䲻����
        int len = 0;
        if (bytes.length < 1 * 1024) {
            len = 2 * bytes.length;
        } else {
            len = 3 * bytes.length / 2;
        }
    }
}
