import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiTests {
    @Test

    public void firstDelfiTest() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }
}
