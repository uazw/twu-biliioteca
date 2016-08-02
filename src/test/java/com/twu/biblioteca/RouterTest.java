package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class RouterTest {

    @Test
    public void shouldJumpTheFirstPageWhenFirstTime() throws Exception {
        //given
        RouterBuilder builder = new RouterBuilder();
        Page firstPage = spy(new FirstPage());
        Router router = builder
                .path("first", firstPage)
                .defaultPath("first")
                .build();

        //when
        router.start();

        //then
        verify(firstPage, times(1)).execute();
    }
}