package com.flimbis.tvmaze.core;

import com.flimbis.tvmaze.core.interactors.GetAllShows;
import com.flimbis.tvmaze.core.repository.ShowsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

/**
 * Created by Fifi on 6/18/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetAllShowsTest {
    private GetAllShows shows;
    @Mock
    ShowsRepository repository;
    @Before
    public void setUp() throws Exception {
        shows = new GetAllShows(repository, Schedulers.single());
    }

    @Test
    public void shouldReturnShows(){
        //fail("Test not yet implemented");
        //when()
        assertNull(shows.buildObservable(1));
    }
}
