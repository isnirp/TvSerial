package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Shows;
import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.TvMazeRepository;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetShowDetails extends Interactor<Shows, Param> {
    private TvMazeRepository mRepository;

    public GetShowDetails( TvMazeRepository repository, ThreadExecutor threadExecutor, Scheduler uiThread) {
        super(threadExecutor, uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<Shows> buildInteractorObservable(Param p) {
        return mRepository.getSelectedShowById(p.getId());
    }
}
