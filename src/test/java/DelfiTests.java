import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiTests {

    private final By ARTICLE  = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");

    private WebDriver driver;

    @BeforeEach
    public void precondition(){
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }


    @Test

    public void firstDelfiTest() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        //String text = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
        //System.out.println(textes);
        List<WebElement> textes = driver.findElements(By.xpath(".//h1[contains(@class,'headline__title')]"));
        for (int i = 0; i < textes.size(); i++ ) {
            //System.out.println(textes.get(i).getText());
            //System.out.println(textes.size());
            System.out.println((i +1) + ":" + textes.get(i).getText());
        }

    }

    @Test
    public void workingWithLists() {
        List<String> studentNames = new ArrayList<String>();

        System.out.println(studentNames.isEmpty());

        studentNames.add("Zoja");
        studentNames.add("Petja");
        studentNames.add("Vovan");

        System.out.println(studentNames.isEmpty());
        System.out.println(studentNames.size());
        System.out.println(studentNames.get(1));

    }


    @Test
    public void titleTest() {
        final String TITLE_TO_FIND = "Северная Корея заявила о возможном первом случае случае заражения Covid-19";

        //get all articles
        List<WebElement> articles = driver.findElements(ARTICLE);

        //find given article by text
        boolean isFound = false;
        for (WebElement article : articles) {
            if (article.findElement(TITLE).getText().equals(TITLE_TO_FIND)){
                article.findElement(TITLE).click();
                isFound = true;
                break; // выйти из цикла
            }
        }
        Assertions.assertTrue(isFound, "Article is not found");
        //find article title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();



        //compare it

        Assertions.assertEquals(TITLE_TO_FIND,articlePageTitle, "Titles are not equal!!");


    }

    @AfterEach
    private void closeBrowser() {
        driver.close(); // or   quit
    }

}
