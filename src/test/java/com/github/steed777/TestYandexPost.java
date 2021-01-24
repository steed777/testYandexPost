package com.github.steed777;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestYandexPost {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

     @Before
    public void startDriver() {
        FirefoxOptions options = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void testyandex()  {
         try {
            driver.get("https://yandex.ru/");
            driver.findElement(By.cssSelector(".button_theme_gray")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
        }catch (Exception e) {
         }
     }

    @Test
    public void testyandexpost(){
try {
    driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
    element = driver.findElement(By.id("root"));
    element.findElement(By.cssSelector("[name=\"login\"]")).
            sendKeys("steed7773@yandex.ru");
    element.findElement(By.cssSelector("button.Button2")).click();

    element.findElement(By.cssSelector("[name=\"passwd\"]")).
            sendKeys("steed777");
    element.findElement(By.cssSelector(".Button2_view_action")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("__SVG_SPRITE_NODE__")));
}catch (Exception e){

}
    }
@After
    public void stopDriver(){
         driver.quit();
}
}
