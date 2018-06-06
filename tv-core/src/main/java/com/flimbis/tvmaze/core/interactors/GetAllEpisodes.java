package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.EpisodeEntity;
import com.flimbis.tvmaze.core.repository.EpisodesRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetAllEpisodes extends UseCase<List<EpisodeEntity>, Long> {
    private EpisodesRepository mRepository;

    public GetAllEpisodes(EpisodesRepository repository, Scheduler uiThread) {
        super(uiThread);
        this.mRepository = repository;

    }

    @Override
    public Observable<List<EpisodeEntity>> buildObservable(Long showId) {
        return mRepository.getAll(showId);
    }
}
