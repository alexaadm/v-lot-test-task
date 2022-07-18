package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {

    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */

    public WebDriver driver;
    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * локатор кнопки "Отобразить списком "
     */

    @FindBy(xpath = "//span[contains(@class, 'button_content')]/child::span[text()='Списком']")
    private WebElement listButton;

    /**
     * локатор третьего имущества в списке
     */

    @FindBy(xpath = "(//div[contains(@class,'lot-card_price')])[3]/child::div[1]")
    private WebElement priceLotField;

    /**
     * Метод для нажатия отображения каталога списком
     */

    public void displayListCatalog(){
        listButton.click();
    }

    /**
     * метод для получения текущей цены третьего имущества в списке
     */

    public String getLotPrice(){
        String lotPrice = priceLotField.getText();
        String formattedLotPrice = lotPrice.replaceAll("\\D","");
        return formattedLotPrice;
    }
}