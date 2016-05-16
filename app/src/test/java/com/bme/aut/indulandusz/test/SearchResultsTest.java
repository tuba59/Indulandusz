package com.bme.aut.indulandusz.test;

import com.bme.aut.indulandusz.BuildConfig;
import com.bme.aut.indulandusz.SearchResults.SearchResultsPresenter;
import com.bme.aut.indulandusz.SearchResults.SearchResultsScreen;
import com.bme.aut.indulandusz.TestHelper;
import com.bme.aut.indulandusz.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SearchResultsTest {

    private SearchResultsPresenter searchResultsPresenter;
    private SearchResultsScreen searchResultsScreen;

    @Before
    public void setup() throws Exception {
        TestHelper.setTestInjector();
        searchResultsScreen = mock(SearchResultsScreen.class);
        searchResultsPresenter = SearchResultsPresenter.getInstance();
        searchResultsPresenter.attachView(searchResultsScreen);
    }

    @Test
    public void testSearch() {
        String term = "Móricz";
        searchResultsPresenter.showSearchResults(term);
        verify(searchResultsScreen).showSearchResults(term);
    }


    @After
    public void tearDown() {
        searchResultsPresenter.detachView();
    }

}