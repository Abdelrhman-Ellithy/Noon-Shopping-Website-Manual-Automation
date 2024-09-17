package Pages;
import Ellithium.Utilities.DriverActions;
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
        DriverActions.SendData(driver,By.id("searchBar"),itemName,3,200 );
    }
    public void clickEnter(){
        DriverActions.SendData(driver,By.id("searchBar"),Keys.ENTER,3,200 );
    }
    public String getTextInSearchField(){
       return driver.findElement(By.id("searchBar")).getAttribute("value");
    }
    public void clickSortBy(String sortBy) {
         String sortByLower=sortBy.toLowerCase();
         driver.findElement(By.xpath("(//div[@data-qa='select-menu-btn-plp_sort'])[1]")).click();
         switch (sortByLower){
             case "price low to high":
                 driver.findElement(By.cssSelector("li[data-value='price-asc']")).click();
                break;
             default:
                 break;
         }
    }
    public List<String> getResultsPrice() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//img[@alt='Loading' and @loading='lazy']"))));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("(//span[@data-qa='select-menu-btn-label'])[1]")),"PRICE: LOW TO HIGH"));
        List<WebElement> items=wait.until(ExpectedConditions.visibilityOfAllElements((driver.findElements(By.className("amount")))));
        List<String>itemPrice=new ArrayList<>();
        byte count=0;
        for (WebElement item:items){
            itemPrice.add(item.getText());
            count++;
            if (count>14){
                break;
            }
        }
        return itemPrice;
    }
    public List<String> getResultsNames(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//img[@alt='Loading' and @loading='lazy']"))));
        List<WebElement> items=wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("div[data-qa='product-name']"))));
        List<String>itemsName=new ArrayList<>();
        byte count=0;
        for (WebElement item:items){
            itemsName.add(item.getAttribute("title").toLowerCase());
            count++;
            if (count>14){
                break;
            }
        }
        return itemsName;
    }
    public void clickDell()  {
        driver.findElement(By.cssSelector("label[data-qa=brand_DELL]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//img[@alt='Loading' and @loading='lazy']"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(.,'DELL')]"))));
    }

    public void returnHome(){
        driver.navigate().to("https://www.noon.com/egypt-en/");
    }
}
