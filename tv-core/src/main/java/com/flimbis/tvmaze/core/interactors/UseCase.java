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

public abstract class UseCase<T, Params> {
    private final Scheduler mUiThread;
    private final CompositeDisposable mCompositeDisposable;

    public UseCase(Scheduler uiThread) {
        this.mUiThread = uiThread;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public abstract Observable<T> buildObservable(Params p);

    public void execute(DisposableObserver<T> disposableObserver, Params p) {
        if (disposableObserver == null) {
            throw new IllegalArgumentException("disposableObserver must not be null");
        }

        final Observable<T> observable = this.buildObservable(p)
                .subscribeOn(Schedulers.io())
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
