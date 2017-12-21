package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Show;
import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.ShowsRepository;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetShow extends UseCase<Show, Long> {
    private ShowsRepository mRepository;

    public GetShow(ShowsRepository repository,  Scheduler uiThread) {
        super(uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<Show> buildObservable(Long id) {
        return mRepository.getById(id);
    }
}
