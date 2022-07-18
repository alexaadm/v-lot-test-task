package org.example.test;

import org.example.pages.CatalogPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CatalogTest {

    public static CatalogPage catalogPage;
    public static MainPage mainPage;
    public static WebDriver driver;
    private static final String mainPageUrl = "https://v-lot.ru";
    private static final String expectedLotPrice = "480015000";

    /**
     * осуществление первоначальной настройки
     */

        @BeforeAll
        public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/aleksandra/Documents/chromedriver");


        driver = new ChromeDriver();
        catalogPage = new CatalogPage(driver);
        mainPage = new MainPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(mainPageUrl);
    }

    /**
     * Тест на проверку соответствия актуальной цены и текущей (на сайте) имущества в каталоге
     */

        @Test
        public void propertyPriceCheck() {
            //нажимаем на блок "Каталог"
            mainPage.clickCatalog();
           // нажимаем отобразить каталог списком
            catalogPage.displayListCatalog();
            //получаем текущую цену третьего имущества в списке
            catalogPage.getLotPrice();
            assertEquals(catalogPage.getLotPrice(), expectedLotPrice);

        }

        @AfterAll
        public static void closeBrowser(){
           driver.close();
        }
    }