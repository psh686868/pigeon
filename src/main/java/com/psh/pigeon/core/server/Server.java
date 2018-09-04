package com.psh.pigeon.core.server;

import com.psh.pigeon.core.config.ServerConfig;

/**
 * @author PSH
 * Date: 2018/9/4
 * rpc service
 *
 */
public interface Server {

    /**
     * 服务端初始化
     */
    void init (ServerConfig config);

    /**
     * 服务端启动
     */
    void start ();

    /**
     * 是否启动
     * @return true 启动了 ,false 为启动
     *
     */
    Boolean isStarted ();

    /**
     * 停止
     */
    void stop ();


}
