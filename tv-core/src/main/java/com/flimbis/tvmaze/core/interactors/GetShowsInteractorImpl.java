package com.flimbis.tvmaze.core.interactors;

import com.flimbis.tvmaze.core.entity.Shows;
import com.flimbis.tvmaze.core.repository.TvMazeRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Fifi on 5/19/2017.
 */

public class GetShowsInteractorImpl extends Interactor {
    TvMazeRepository repository;

    public GetShowsInteractorImpl(TvMazeRepository repository) {
        super(repository);
        this.repository = repository;
    }

  /*  public Observable<List<Shows>> getShowsPagination(final String page) {

        //return repository.getShowsListByPage(page);

        return Observable.defer(new Func0<Observable<List<Shows>>>() {
            @Override
            public Observable<List<Shows>> call() {
                return Observable.just(repository.getShowsListByPage(page));
            }
        });
    }*/
}