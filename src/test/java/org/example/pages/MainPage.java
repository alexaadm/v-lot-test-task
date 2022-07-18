package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    /**
     * Конструктор класса, занимающийся инициализацией полей класса
     */

    public WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * локатор кнопки "Каталог"
     */
    @FindBy(xpath = "//a[contains(text(),'Каталог')]/parent::li[contains(@class,'header')]")
    private WebElement catalogButton;


    /**
     * метод для нажатия на кнопку "Каталог"
     */

    public void clickCatalog(){
        catalogButton.click();
    }
}