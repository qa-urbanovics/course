package oneA.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class BaseFunc {

    private WebDriver driver;
    private WebDriverWait wait;


    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }

    public void openPage(String url) {
        LOGGER.info("Trying to open page:" + url);

        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        driver.get(url);
    }

    public void click(WebElement element) {
        wait.until(elementToBeClickable(element));
        element.click();
    }

    /*
    builder.moveToElement(hoverElement).perform();
    By locator = By.id("clickElementID");
    driver.click(locator);
    */


}
