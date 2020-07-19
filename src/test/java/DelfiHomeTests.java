import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DelfiHomeTests {

    private WebDriver driver;

    @BeforeEach
    public void precondition(){
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test
    public void FirstSiteTitle(){

        String text = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
        System.out.println("Delfi last article title is:" + text);

        String comment = driver.findElement(By.xpath(".//a[contains(@class,'comment-count text-red-ribbon')]")).getText();
        comment = comment.replace("(", "").replace(")", "");
        System.out.println("Comment count:" + comment);

        String title = new String("Dmitrijs from QA GURU WIN one mln EUR!!!");

        assertEquals(title,text);

    }
    @AfterEach
    private void closeBrowser() {
        driver.close();
    }
}
