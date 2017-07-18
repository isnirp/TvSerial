package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Episodes;
import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.TvMazeRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetEpisodesList extends Interactor<List<Episodes>, Param> {
    private TvMazeRepository mRepository;

    public GetEpisodesList(TvMazeRepository repository, ThreadExecutor threadExecutor, Scheduler uiThread) {
        super(threadExecutor, uiThread);
        this.mRepository = repository;

    }

    @Override
    public Observable<List<Episodes>> buildInteractorObservable(Param p) {
        return mRepository.getShowEpisodesList(p.getId());
    }
}
