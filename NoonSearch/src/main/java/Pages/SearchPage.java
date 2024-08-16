package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver=driver;
    }
    public void searchItem(String itemName){
        driver.findElement(By.id("searchBar")).sendKeys(itemName);
    }
    public void clickEnter(){
        driver.findElement(By.id("searchBar")).sendKeys(Keys.ENTER);
    }
    public String getTextInSearchField(){
       return driver.findElement(By.id("searchBar")).getAttribute("value");
    }
    public void clickSortBy(String sortBy) throws InterruptedException {
         String sortByLower=sortBy.toLowerCase();
         driver.findElement(By.xpath("(//div[@data-qa='select-menu-btn-plp_sort'])[1]")).click();
         switch (sortByLower){
             case "price low to high":driver.findElement(By.cssSelector("li[data-value='price-asc']")).click();
             Thread.sleep(1000);
             break;

         }
    }
    public List<String> getResultsPrice(){
        List<WebElement> items=driver.findElements(By.className("amount"));
        List<String>itemPrice=new ArrayList<>();
        for (WebElement item:items){
            itemPrice.add(item.getText());
        }
        return itemPrice;
    }
    public List<String> getResultsNames(){
        List<WebElement> items=driver.findElements(By.cssSelector("div[data-qa='product-name']"));
        List<String>itemsName=new ArrayList<>();
        for (WebElement item:items){
            itemsName.add(item.getAttribute("title").toLowerCase());
        }
        return itemsName;
    }
    public void clickDell(){
        driver.findElement(By.cssSelector("label[data-qa=brand_DELL]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(.,'DELL')]"))));
    }

    public void returnHome(){
        driver.navigate().to("https://www.noon.com/egypt-en/");
    }
}
