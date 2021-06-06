package PageModels;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseModel  {
    public BaseModel(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    WebDriver webDriver;
    By txtSearchArea = By.id("searchData");
    By siteIcon = By.className("logo  home");
    By txtComputerProduct = By.className("productName");
    By next = By.xpath("//a[text()='2']");
    By basket = By.className("btnAddBasket");
    By count = By.cssSelector(".basket-item-count");
    By delete = By.cssSelector("btn-delete");
    By deletmesage = By.xpath("//*[@id='empty-cart-container']/div[1]/div[1]/div/div[2]/h2");
    By checklist1 = By.id("774810028");
    By checklist2 = By.id("774810029");
    By checklist3 = By.id("774810030");

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.n11.com/");
        WebElement closeButton = webDriver.findElement(By.className("seg-popup-close"));
        closeButton.click();
    }
    public void shouldLogin() {
        webDriver.findElement(By.className("btnSignIn")).click();
        webDriver.findElement(By.id("email")).sendKeys("hanayrecep@gmail.com");
        webDriver.findElement(By.id("password")).sendKeys("15711571203h");
        webDriver.findElement(By.id("loginButton")).click();
    }

    public void setSearchTextModel(String value){
        webDriver.findElement(txtSearchArea).sendKeys(value + Keys.ENTER);
    }
    public  void nextpage(){
        webDriver.findElement(next).click();
    }
    public void clickComputerProduct(){
        webDriver.findElements(txtComputerProduct).get(0).click();
    }
    public void sekmelist(){
        webDriver.findElement(checklist1).sendKeys("8 GB" + Keys.ENTER);
    }
    public void sekmelist2(){
        webDriver.findElement(checklist2).sendKeys("128 GB" + Keys.ENTER);
    }
    public void sekmelist3(){
        webDriver.findElement(checklist3).sendKeys("1600x900" + Keys.ENTER);
    }


   public void clicktBasket(){
        webDriver.findElement(basket).click();

   }
   public String clickcount(){
        return webDriver.findElement(count).getText();

   }
    public void clickBasketButton(){
        webDriver.findElement(count).click();

    }
   public void deleteProduct(){
      webDriver.findElement(delete).click();
   }
   public String deleteMesage(){
        return webDriver.findElement(deletmesage).getText();
   }

    public void quitWebBrowser(){
        webDriver.quit();
    }


}

