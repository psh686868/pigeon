package com.psh.pigeon.core.config;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author PSH
 * Date: 2018/9/4
 *
 * 这些配置以后可以让用户自定义，这里先写死。
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerConfig extends AbstractConfig implements Serializable {
    private static final long  serialVersionUID = 1L;

    @Builder.Default
    private Boolean useEpoll = false;

    /**
     * 核心线程池
     */
    @Builder.Default
    private int coreThread = 4;

    /**
     *  最大线程数
     */
    @Builder.Default
    private int maxThread = 4;

    /**
     * 线程的回收时间
     */
    @Builder.Default
    private int keepAlive = 0;

    /**
     * 序列化的方式
     */
    @Builder.Default
    private String serialization = "";


}
