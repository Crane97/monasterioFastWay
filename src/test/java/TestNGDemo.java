import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {

    //BeofreMethod se ejecuta una vez antes de cada método:
    //Si tenemos 10 métodos, el BeforeMethod se ejecutará 10 veces.
    //BeforeClass se ejecuta una vez antes de la clase

    WebDriver driver;

    @BeforeClass
    void setUpMethodClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpMethod(){
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    void tearOutMethod(){
        driver.quit();
    }

    @Test(dataProvider = "calc-data", dataProviderClass = TestData.class)
    void calcTest(String input, String expected){
        driver.findElement(By.id("L2AGLb")).click();

        WebElement webElement = driver.findElement(By.cssSelector(".gLFyf"));
        webElement.sendKeys(input);
        webElement.submit();

        WebElement result = driver.findElement(By.className("qv3Wpe"));
        Assert.assertEquals(result.getText(), expected);
    }

}
