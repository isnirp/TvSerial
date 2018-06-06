package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.ShowEntity;
import com.flimbis.tvmaze.core.repository.ShowsRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 5/19/2017.
 */

public class GetAllShows extends UseCase<List<ShowEntity>, Integer> {
    private ShowsRepository mRepository;

    public GetAllShows(ShowsRepository repository, Scheduler uiThread) {
        super( uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<List<ShowEntity>> buildObservable(Integer page) {
        return mRepository.getAll(page);
    }

}