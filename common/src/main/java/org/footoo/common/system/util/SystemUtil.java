/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.system.util;

import java.io.File;

/**
 * 系统相关的工具
 * 
 * @author fengjing.yfj
 * @version $Id: SystemUtil.java, v 0.1 2014年7月20日 下午11:23:36 fengjing.yfj Exp $
 */
public class SystemUtil {
    /**
     * 将目录和路径合并为一个完整的路径
     * 
     * @param dir
     * @param path
     * @return
     */
    public String toFullPath(String dir, String path) {
        return dir + File.separator + path;
    }
}
