package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Episode;
import com.flimbis.tvmaze.core.repository.EpisodesRepository;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by Fifi on 7/16/2017.
 */

public class GetEpisode extends UseCase<Episode,Long> {
    private EpisodesRepository mRepository;
    private int season;
    private int episode;

    public GetEpisode(EpisodesRepository repository, Scheduler uiThread) {
        super( uiThread);
        this.mRepository = repository;
    }

    @Override
    public Observable<Episode> buildObservable(Long id) {
        return mRepository.get(id, season, episode);
    }

    public void setSeason(int season){
        this.season = season;
    }
    public void setEpisode (int episode){
        this.episode = episode;
    }
}
