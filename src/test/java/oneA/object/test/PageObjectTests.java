package oneA.object.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.object.BaseFunc;
import page.object.pages.HomePage;

import java.util.function.Consumer;

public class PageObjectTests {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private Actions action;
    private WebDriver driver;
    //Edit: there may have been a typo in the '- >' expression (I don't really want to add this comment but SO insist on ">6 chars edit"...
    Consumer<By> hover = (By by) -> {
        action.moveToElement(driver.findElement(by))
                .perform();
    };

    @Test
    public void pageObjectTest() {
        LOGGER.info("This test buy notebook to 1a.lv shop :) ");

        BaseFunc baseFunc = new BaseFunc(); //new - it's copy object (create construction)
        baseFunc.openPage("1a.lv");

        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("2");
        WebElement menuHoverLink = driver.findElement(By.linkText("Datortehnika, preces birojam"));
        action.moveToElement(menuHoverLink);

        //LOGGER.info("2");
        //hover.accept(By.linkText("Datortehnika, preces birojam"));
        //resurs info https://www.codota.com/code/java/classes/org.openqa.selenium.interactions.Actions


    }

    public void menuShow() {
        LOGGER.info("2");
        WebElement getmenu = driver.findElement(By.xpath(".//a[contains(@class,'submenu-lvl1__link')]")); //xpath the parent

        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        //Thread.sleep(3000);
        WebElement clickElement= driver.findElement(By.linkText("Datortehnika, preces birojam"));//xpath the child
        act.moveToElement(clickElement).click().perform();

    }
/*
    public void hoverTest() {
        LOGGER.info("Pageobject TEST ");
        hover.accept(By.linkText("Datortehnika, preces birojam"));
    }

    public void hover_Product_Category(){
        Actions builder = new Actions(driver);
        builder.moveToElement(hover_Product_Category)
    }
*/


}
