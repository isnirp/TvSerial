package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.TvMazeRepository;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetEpisodeDetails extends Interactor<EpisodesEntity,Param> {
    private TvMazeRepository mRepository;

    public GetEpisodeDetails(TvMazeRepository repository, ThreadExecutor threadExecutor, Scheduler uiThread) {
        super(threadExecutor, uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<EpisodesEntity> buildInteractorObservable(Param p) {
        return mRepository.getSelectedEpisode(p.getId(), p.getQuerySeasonNumber(), p.getQueryEpisodeNumber());
    }
}
