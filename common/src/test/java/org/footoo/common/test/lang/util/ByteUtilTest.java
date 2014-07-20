/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.lang.util;

import org.footoo.common.lang.util.ByteUtil;
import org.footoo.common.test.HodooTestBase;
import org.footoo.common.test.annotion.AutoWire;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 测试Byte工具
 * 
 * @author fengjing.yfj
 * @version $Id: ByteUtilTest.java, v 0.1 2014年7月20日 下午4:27:34 fengjing.yfj Exp $
 */
public class ByteUtilTest extends HodooTestBase {
    @AutoWire(AutoWire.BY_SERVICE)
    protected ByteUtil byteUtil;

    @Test
    public void test() {
        Assert.assertEquals("0000001234567890",
            byteUtil.convertToString(byteUtil.toBytes(0x1234567890L)));
    }
}
