import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiTests {
    @Test

    public void firstDelfiTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rus.delfi.lv");
    }
}
