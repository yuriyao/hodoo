/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package org.footoo.common.stream.util;

import java.io.IOException;
import java.io.InputStream;

import org.footoo.common.buffer.ByteBuffer;

/**
 * 输入流工具
 * 
 * @author fengjing.yfj
 * @version $Id: InputStreamUtil.java, v 0.1 2014年7月20日 下午7:27:20 fengjing.yfj Exp $
 */
public class InputStreamUtil {
    /**
     * 读取所有的输入流
     * 
     * @param in
     * @return
     * @throws IOException 
     */
    public String readFull(InputStream in) throws IOException {
        ByteBuffer byteBuffer = new ByteBuffer();
        final int BUFFER_LEN = 64;
        byte[] bs = new byte[BUFFER_LEN];
        int len = 0;
        while ((len = in.read(bs)) >= 0) {
            byteBuffer.append(bs, 0, len);
        }
        return new String(byteBuffer.toByteArray());
    }
}
