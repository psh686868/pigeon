package com.psh.pigeon.common;

import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PSH
 * Date: 2018/8/30
 * 处理当线程池无法接受任务时处理逻辑
 */

@Slf4j
public class AbortPolicyHandler extends ThreadPoolExecutor.AbortPolicy{

    /***
     * 当一个线程池创建后 when task submit 如果任务任务小于核心线程池或者队列满了后切小于maximumPoolSize创建thread ，
     * 当线程数等于 maximumPoolSize 并且队列 queue 满后或者线程池关闭后则会 抛出rejected 异常 largestPoolSize：出现的最大线程池的数量因为
     * 线程池启动后maximumPoolSize可以动态条状
     * @param r a task when rejected
     * @param e executor
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        String threadInfo = String
            .format("thread [ active : %d, core: %d, max: %d, largest: %d, task is %d, complete is %d, ] ",
                e.getActiveCount(), e.getCorePoolSize(), e.getMaximumPoolSize(), e.getLargestPoolSize(),
                e.getTaskCount(), e.getCompletedTaskCount());

        log.error(threadInfo);

        e.shutdown();
    }
}
