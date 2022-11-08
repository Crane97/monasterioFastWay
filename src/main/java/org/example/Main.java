package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");

        driver.manage().window().maximize();

        driver.findElement(By.id("L2AGLb")).click();

        driver.findElement(By.className("gb_A")).click();

        Thread.sleep(1000);

        driver.switchTo().frame("app");

        //Crear el webElement
        WebElement webElement = driver.findElement(By.xpath("//*[starts-with(@href,\"https://maps.google.es/maps\")]"));
        webElement.click();

        driver.findElement(By.xpath("//*[text()=\"Aceptar todo\"]/parent::*")).click();

        WebElement inputMaps = driver.findElement(By.id("searchboxinput"));
        inputMaps.sendKeys("Monasterio Sevilla, Calle Amor de Dios, Sevilla");
        driver.findElement(By.id("searchbox-searchbutton")).click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("//*[text()=\"Cómo llegar\"]/parent::button")).click();

        Thread.sleep(3000);

        WebElement inputLocation = driver.findElement(By.id("sb_ifc51"));
        WebElement inputLoc2 = inputLocation.findElement(By.className("tactile-searchbox-input"));

        inputLoc2.sendKeys("HUBR XIOR Sevilla - Residencia Universitaria, Av. de la Palmera, 17, 41013 Sevilla");

        WebElement inputOwnLocation = driver.findElement(By.id("directions-searchbox-0"));
        inputOwnLocation.findElement(By.className("mL3xi")).click();

        Thread.sleep(3000);

//        WebElement publicTransport = driver.findElement(By.cssSelector(".FsvUe"));
//        publicTransport.findElement(By.tagName("button")).click();

        driver.findElement(By.xpath("//*[@id=\"omnibox-directions\"]/div/div[2]/div/div/div/div[3]/button")).click();
    }
}