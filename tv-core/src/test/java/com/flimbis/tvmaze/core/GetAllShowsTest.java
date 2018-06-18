package com.flimbis.tvmaze.core;

import com.flimbis.tvmaze.core.interactors.GetAllShows;
import com.flimbis.tvmaze.core.repository.ShowsRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;

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

    }

    @Test
    public void getAllShows(){
        fail("Test not yet implemented");
    }
}
