package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {
    private LibraryService libraryService;

    @Before
    public void initLibraryService() {

        libraryService = new LibraryService();
    }

    @Test
    public void canShowMainMenuForCustomerTest() {
        String welcomeMessage = "----------   Main  Menu of BIBLIOTECA  ----------\n" +
                "[0] Quit Biblioteca System\n" +
                "[1] List Books of Library\n" +
                "[2] List Movies of Library\n" +
                "[3] Show Your Own Information\n" +
                "\nPlease Enter Your Choice :";
        assertEquals(welcomeMessage, libraryService.showMainMenuForCustomer());
    }

}
