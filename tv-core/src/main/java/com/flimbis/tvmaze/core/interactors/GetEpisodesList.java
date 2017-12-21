package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Episode;
import com.flimbis.tvmaze.core.executor.ThreadExecutor;
import com.flimbis.tvmaze.core.repository.EpisodesRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetEpisodesList extends UseCase<List<Episode>, Long> {
    private EpisodesRepository mRepository;

    public GetEpisodesList(EpisodesRepository repository, Scheduler uiThread) {
        super(uiThread);
        this.mRepository = repository;

    }

    @Override
    public Observable<List<Episode>> buildObservable(Long showId) {
        return mRepository.getAllPerShow(showId);
    }
}
