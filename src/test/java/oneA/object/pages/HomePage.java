package oneA.object.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.object.BaseFunc;

import java.util.function.Consumer;

public class HomePage {

    private final By MENU  = By.xpath(".//a[contains(@class,'submenu-lvl1__link')]");

    private BaseFunc baseFunc;
    private Actions action;
    private WebDriver driver;

    //Edit: there may have been a typo in the '- >' expression (I don't really want to add this comment but SO insist on ">6 chars edit"...
    Consumer<By> hover = (By by) -> {
        action.moveToElement(driver.findElement(by))
                .perform();
    };

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public void menuShow() {

        WebElement getmenu = driver.findElement(By.xpath(".//a[contains(@class,'submenu-lvl1__link')]")); //xpath the parent

        Actions act = new Actions(driver);
        act.moveToElement(getmenu).perform();

        //Thread.sleep(3000);
        WebElement clickElement= driver.findElement(By.linkText("Datortehnika, preces birojam"));//xpath the child
        act.moveToElement(clickElement).click().perform();

    }

    public void hoverTest() {

        hover.accept(By.linkText("Datortehnika, preces birojam"));
    }



}
