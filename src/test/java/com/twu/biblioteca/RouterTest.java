package com.twu.biblioteca;

import com.twu.biblioteca.framework.Router;
import com.twu.biblioteca.framework.RouterBuilder;
import com.twu.biblioteca.framework.Session;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RouterTest {

    private Router router;
    private FirstPage firstPage;
    private SecondPage secondPage;
    private ThirdPage thirdPage;

    @Before
    public void setUp() throws Exception {
        RouterBuilder builder = new RouterBuilder();
        firstPage = spy(new FirstPage());
        secondPage = spy(new SecondPage());
        thirdPage = spy(new ThirdPage());
        router = builder
                .path("first", firstPage)
                .path("second", secondPage)
                .path("third", thirdPage)
                .defaultPath("first")
                .build();
    }

    @Test
    public void shouldJumpTheFirstPageWhenFirstTime() throws Exception {
        //given

        //when
        router.start();

        //then
        verify(firstPage, times(1)).execute(any(Session.class));
    }

    @Test
    public void shouldJumpSuccessfullyBetweenPage() throws Exception {
        //given

        //when
        router.start();

        //then
        verify(firstPage, times(1)).execute(any(Session.class));
        verify(secondPage, times(1)).execute(any(Session.class));
    }

    @Test
    public void shouldNotJumpToAnotherPageWhenLastPageReturnEmptyString() throws Exception {
        //given
        Session session = new Session();

        //when
        router.start();

        //then
        verify(firstPage, times(1)).execute(any(Session.class));
        verify(secondPage, times(1)).execute(any(Session.class));
        verify(thirdPage, never()).execute(any(Session.class));
    }
}