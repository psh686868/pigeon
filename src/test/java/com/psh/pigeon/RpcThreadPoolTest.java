package com.psh.pigeon;


import com.psh.pigeon.common.RpcThreadPool;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PSH
 * Date: 2018/8/31
 */
public class RpcThreadPoolTest  {

    CountDownLatch latch = new CountDownLatch(1000);
    @Test(timeout = 5000)
    public void testGetDefaultExecutor () {
        ExecutorService defaultExecutor = RpcThreadPool.getDefaultExecutor();
        Assert.assertNotNull(defaultExecutor);
        IntStream.rangeClosed(0,10000).forEach((num) -> {
            defaultExecutor.submit(() -> {
                latch.countDown();
                System.out.println( "thread is " + Thread.currentThread().getName()  + " task is num = " + num);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

    }
}
