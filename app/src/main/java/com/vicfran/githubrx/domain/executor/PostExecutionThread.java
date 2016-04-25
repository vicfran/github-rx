package com.vicfran.githubrx.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {

    Scheduler getScheduler();

}
