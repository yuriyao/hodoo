/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.system.util;

import java.io.File;

/**
 * ϵͳ��صĹ���
 * 
 * @author fengjing.yfj
 * @version $Id: SystemUtil.java, v 0.1 2014��7��20�� ����11:23:36 fengjing.yfj Exp $
 */
public class SystemUtil {
    /**
     * ��Ŀ¼��·���ϲ�Ϊһ��������·��
     * 
     * @param dir
     * @param path
     * @return
     */
    public String toFullPath(String dir, String path) {
        return dir + File.separator + path;
    }
}
