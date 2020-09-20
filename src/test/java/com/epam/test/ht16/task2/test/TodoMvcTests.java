package com.epam.test.ht16.task2.test;

import com.epam.test.ht16.task2.pages.MainPage;
import com.epam.test.ht16.task2.pages.Pages;
import com.epam.test.ht16.task2.pages.TodoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoMvcTests {
    static WebDriver driver;
    static final String BASE_URL = "http://todomvc.com/";

    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().browserVersion("85").setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    void setUp(){
        driver.get(BASE_URL);
    }

    @Test
    void testOpenToDoPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openToDoPage(Pages.Dart);

        assertTrue(driver.getCurrentUrl().contains(Pages.Dart.toString()));
    }

    @Test
    void testCompleteItem(){
        final String FIRST_ITEM = "Write Hello World";
        final String SECOND_ITEM = "Write Calculator";
        final String THIRD_ITEM = "Become CEO of Microsoft";

        MainPage mainPage = new MainPage(driver);
        TodoPage todoPage = mainPage.openToDoPage(Pages.React);

        todoPage.addItem(FIRST_ITEM);
        todoPage.addItem(SECOND_ITEM);
        todoPage.addItem(THIRD_ITEM);

        todoPage.markAllItemsComplete();

        assertEquals(todoPage.getHowManyItemsAreCompleted(), 3);
    }
}
