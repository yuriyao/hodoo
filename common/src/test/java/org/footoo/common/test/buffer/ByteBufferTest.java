/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.buffer;

import org.footoo.common.buffer.ByteBuffer;
import org.footoo.common.test.HodooTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * byte缓存测试
 * 
 * @author fengjing.yfj
 * @version $Id: ByteBufferTest.java, v 0.1 2014年7月20日 下午11:10:05 fengjing.yfj Exp $
 */
public class ByteBufferTest extends HodooTestBase {

    @Test
    public void test() {
        ByteBuffer byteBuffer = new ByteBuffer();
        byteBuffer.append("hello");
        byteBuffer.append(" world");
        Assert.assertEquals("hello world", new String(byteBuffer.toByteArray()));

        byteBuffer.clear();
        byteBuffer.append("1234567890");
        byteBuffer.append("abcdefghijklmn".getBytes(), 1, 10);
        Assert.assertEquals("1234567890bcdefghijk", new String(byteBuffer.toByteArray()));
    }
}
