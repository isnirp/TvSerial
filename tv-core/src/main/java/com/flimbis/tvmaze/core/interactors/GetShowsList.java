package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.TvMazeRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 5/19/2017.
 */

public class GetShowsList extends Interactor<List<ShowsEntity>, Param> {
    private TvMazeRepository mRepository;

    public GetShowsList(TvMazeRepository repository, ThreadExecutor threadExecutor, Scheduler uiThread) {
        super(threadExecutor, uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<List<ShowsEntity>> buildInteractorObservable(Param param) {
        return mRepository.getShowsListByPage(param.getQueryPageNumber());
    }

}