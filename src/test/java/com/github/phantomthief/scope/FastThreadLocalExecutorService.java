package com.github.phantomthief.scope;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lijie <lijie02@kuaishou.com>
 * Created on 2019-07-03
 */
public class FastThreadLocalExecutorService extends ThreadPoolExecutor {


    public FastThreadLocalExecutorService(int nThreads, String prefix) {
        super(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new WorkerThreadFactory(prefix));
    }
}

