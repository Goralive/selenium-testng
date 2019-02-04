import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleTest {



    private void googleExampleSearchFor(final String searchString) {
       // System.setProperty("webdriver.chrome.driver", "C:\\Work\\Java\\seleniumTestNG\\src\\test\\resources\\chromedriver.exe");
        final WebDriver driver = new ChromeDriver();
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

        driver.quit();
    }

    @Test
    public void googleCheeseExample () {
        googleExampleSearchFor("Cheese!");
    }

    @Test
    public void googleBMWExample () {
        googleExampleSearchFor("BMW");
    }
}
