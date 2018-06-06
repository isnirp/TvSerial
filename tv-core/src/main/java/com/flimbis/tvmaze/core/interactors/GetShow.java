package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.ShowEntity;
import com.flimbis.tvmaze.core.repository.ShowsRepository;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetShow extends UseCase<ShowEntity, Long> {
    private ShowsRepository mRepository;

    public GetShow(ShowsRepository repository,  Scheduler uiThread) {
        super(uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<ShowEntity> buildObservable(Long id) {
        return mRepository.get(id).toObservable();
    }
}
