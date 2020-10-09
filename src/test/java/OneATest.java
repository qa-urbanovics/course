import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneATest {
    private final By MENU = By.xpath(".//div[contains(@class,'submenu-lvl1--index')]");
    private final By SUBMENU_LINK = By.xpath(".//a[@class = 'submenu-lvl2__list-item-link']");
    private final By PRICE = By.id("price");
    private final By FROM = By.xpath(".//div[@class = 'noUi-handle noUi-handle-lower']");
    private final By TO = By.xpath(".//div[@class = 'noUi-handle noUi-handle-upper']");
    private final By FILTER_BLOCK = By.xpath(".//div[@class = 'catalog-taxons-filter-tools']");


    private WebDriver driver;
    private Actions actions;

    @Test
    public void workingWithOneA() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actions = new Actions(driver);

        driver.get("http://1a.lv");

        selectSubCategory("Datortehnika, preces birojam","Klaviatūras");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700)");

        WebElement scroll = driver.findElement(PRICE);
        int width = scroll.getSize().width;
        int minValue = Integer.parseInt(scroll.getAttribute("data-min"));
        int maxValue = Integer.parseInt(scroll.getAttribute("data-max"));

        int difFrom = 90 * width / (maxValue - minValue);
        int difTo = (maxValue - 210) * width / (maxValue - minValue) * -1;

        actions.dragAndDropBy(driver.findElement(FROM),difFrom, 0).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FILTER_BLOCK));

        actions.dragAndDropBy(driver.findElement(TO), difTo, 0).build().perform();
    }

    private void selectSubCategory(String category, String subcategory) {

        WebElement menuItem = null;
        for (WebElement we : driver.findElement(MENU).findElements(By.tagName("li"))) {
            if (we.getText().equals(category)) {
                menuItem = we;
                break;
            }
        }

        actions.moveToElement(menuItem).build().perform();

        for (WebElement we : menuItem.findElements(SUBMENU_LINK)) {
            if (we.getText().equals(subcategory)) {
                we.click();
                break;
            }
        }
    }
}
