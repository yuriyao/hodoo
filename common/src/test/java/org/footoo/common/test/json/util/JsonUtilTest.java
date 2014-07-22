/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.test.json.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.footoo.common.data.util.JsonUtil;
import org.footoo.common.log.LoggerFactory;
import org.footoo.common.log.LoggerUtil;
import org.footoo.common.test.HodooTestBase;
import org.footoo.common.test.annotion.AutoWire;
import org.testng.annotations.Test;

/**
 * Json工具测试
 * 
 * @author fengjing.yfj
 * @version $Id: JsonUtilTest.java, v 0.1 2014年7月20日 下午11:47:56 fengjing.yfj Exp $
 */
public class JsonUtilTest extends HodooTestBase {
    /** JSON 工具 */
    @AutoWire(value = AutoWire.BY_NAME)
    private JsonUtil   jsonUtil;
    /** 日志 */
    private LoggerUtil logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        logger.info(jsonUtil.ObjectToJson(this));
        logger.info(jsonUtil.ObjectToJsonWithClassName(this));
        logger.info(jsonUtil.JsonToObject(jsonUtil.ObjectToJson(this), this.getClass()).getClass());

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < 10; i++) {
            Map<String, Object> entry = new HashMap<String, Object>();
            entry.put("str", "<str> " + i);
            entry.put("i", i);
            list.add(entry);
        }
        logger.info(jsonUtil.ObjectToJsonWithClassName(list));

        list = (List<Map<String, Object>>) jsonUtil.JsonToObject(jsonUtil.ObjectToJson(list),
            List.class);
        for (int i = 0; i < 10; i++) {
            logger.info(list.get(i).values().toArray()[0]);
        }
    }
}
