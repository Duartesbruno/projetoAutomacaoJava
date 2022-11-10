package entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public String driverPath;
    public String url;
    public WebDriver driver;

    @BeforeClass
    public void preCond(){
        driverPath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        url = System.getProperty("user.dir")+"\\src\\main\\resources\\componentes.html";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @AfterClass
    private void after(){
        driver.quit();   //fechar o chrome aberto no gerenciador
    }
    public WebDriver getDriver() {
        return driver;
    }

}
