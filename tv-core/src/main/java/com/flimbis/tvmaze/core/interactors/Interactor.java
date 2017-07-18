package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fifi on 5/19/2017.
 */

public abstract class Interactor<T, Params extends Param> {
    private final Scheduler mUiThread;
    private final CompositeDisposable mCompositeDisposable;
    private ThreadExecutor mThreadExecutor;

    public Interactor(ThreadExecutor threadExecutor, Scheduler uiThread) {
        this.mThreadExecutor = threadExecutor;
        this.mUiThread = uiThread;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public abstract Observable<T> buildInteractorObservable(Params p);

    public void execute(DisposableObserver<T> disposableObserver, Params p) {
        if (disposableObserver == null) {
            throw new IllegalArgumentException("disposableObserver must not be null");
        }

        final Observable<T> observable = this.buildInteractorObservable(p)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mUiThread);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        mCompositeDisposable.add(observer);
    }

    public void dispose() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }
}
