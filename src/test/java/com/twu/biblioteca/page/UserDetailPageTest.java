package com.twu.biblioteca.page;

import com.twu.biblioteca.AccountService;
import com.twu.biblioteca.framework.Session;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UserDetailPageTest {
    @Test
    public void shouldShowUserDetail() throws Exception {
        //given
        AccountService accountService = mock(AccountService.class);
        UserDetailPage userDetailPage = new UserDetailPage(accountService, mock(PrintStream.class));
        Session session = new Session();
        String account = "123-4567";
        session.setAccount(account);

        //when
        userDetailPage.execute(session);

        //then
        verify(accountService, times(1)).userDetail(account);
    }
}