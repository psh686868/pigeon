package com.psh.pigeon.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PSH
 * Date: 2018/8/31
 */
public class PigeonThreadFactory implements ThreadFactory {

    private static final String THREAD_PREFIX = "pigeon-thread-";
    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, THREAD_PREFIX + count.getAndIncrement());
        return thread;
    }


}
