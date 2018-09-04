package com.psh.pigeon.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * rpc线程池以后可以定制
 * @author PSH
 * Date: 2018/8/31
 */
public class RpcThreadPool {
    private static final int DEFAULT_CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int MAXIMUM_POOL_SIZE = DEFAULT_CORE_POOL_SIZE * 2 + 1;
    private static final BlockingQueue<Runnable> queue =  new LinkedBlockingQueue<>(5000);

    public static ExecutorService getDefaultExecutor () {
       return RpcThreadPool.getDefaultExecutor(DEFAULT_CORE_POOL_SIZE, MAXIMUM_POOL_SIZE);
    }

    public static ExecutorService getDefaultExecutor (final int corePoolSize, final int maxPoolSize) {
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0, TimeUnit.MICROSECONDS, queue, new PigeonThreadFactory() , new AbortPolicyHandler());
    }


}
