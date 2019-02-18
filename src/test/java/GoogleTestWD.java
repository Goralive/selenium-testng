import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleTestWD extends DriverFactory {



    private void googleExampleSearchFor(final String searchString) throws Exception  {

        WebDriver driver = DriverFactory.getDriver();
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchString);
        System.out.println("Page title is: " + driver.getTitle());
        searchField.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverObject){
                return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
            }
        });

        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void googleCheeseExample () {
        try {
            googleExampleSearchFor("Cheese!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void googleBMWExample () {
        try {
            googleExampleSearchFor("BMW");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
