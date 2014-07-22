/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.test.util;

import org.footoo.common.log.LoggerFactory;
import org.footoo.common.log.LoggerUtil;
import org.footoo.common.test.HodooTestBase;
import org.footoo.common.test.annotion.AutoWire;
import org.footoo.common.test.exception.ParameterNumberException;
import org.footoo.common.test.util.JsonTestParameterGeneratorUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * JSON测试数据生成工具测试
 * 
 * @author fengjing.yfj
 * @version $Id: JsonTestParameterGeneratorUtilTest.java, v 0.1 2014年7月22日 下午10:49:47 fengjing.yfj Exp $
 */
public class JsonTestParameterGeneratorUtilTest extends HodooTestBase {
    @AutoWire(value = AutoWire.BY_NAME)
    private JsonTestParameterGeneratorUtil jsonTestParameterGeneratorUtil;
    /** 日志工具 */
    private LoggerUtil                     logger = LoggerFactory
                                                      .getLogger(JsonTestParameterGeneratorUtilTest.class);

    /**
     * @throws ParameterNumberException 
     * 
     */
    @Test
    public void test() throws ParameterNumberException {
        Object[][] objs = new Object[][] { new Object[] { "hello", 1, "fuck" },
                new Object[] { "you", 2, "bitch" } };
        String[] params = new String[] { "p1", "p2", "p3" };

        logger.info(jsonTestParameterGeneratorUtil.generate(params, objs));

        Assert.assertTrue(true);
    }

}
