/*******************************************************************************
 * Copyright (c) 2017-2019, org.smartboot. All rights reserved.
 * project name: smart-socket
 * file name: IOUtil.java
 * Date: 2019-12-31
 * Author: sandao (zhengjunweimail@163.com)
 *
 ******************************************************************************/

package org.smartboot.socket.transport;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.NotYetConnectedException;

/**
 * @author 三刀
 * @version V1.0 , 2019/12/2
 */
final class IOUtil {
    /**
     * @param channel 需要被关闭的通道
     */
    public static void close(AsynchronousSocketChannel channel) {
        boolean connected = true;
        try {
            channel.shutdownInput();
        } catch (IOException ignored) {
        } catch (NotYetConnectedException e) {
            connected = false;
        }
        try {
            if (connected) {
                channel.shutdownOutput();
            }
        } catch (IOException | NotYetConnectedException ignored) {
        }
        try {
            channel.close();
        } catch (IOException ignored) {
        }
    }
}
