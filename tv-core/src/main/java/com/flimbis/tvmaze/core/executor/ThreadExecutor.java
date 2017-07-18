package com.flimbis.tvmaze.core.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;

/**
 * Created by Fifi on 7/16/2017.
 */

public class ThreadExecutor implements Executor {
    private ThreadFactory threadFactory;
    private ThreadPoolExecutor executorPool;

    public ThreadExecutor(){
        threadFactory = Executors.defaultThreadFactory();
        executorPool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), threadFactory);
    }

    @Override
    public void execute(Runnable command) {
        executorPool.execute(command);
    }

}
