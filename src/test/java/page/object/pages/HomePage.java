package page.object.pages;

import org.openqa.selenium.By;

public class HomePage {
    private final By ARTICLE  = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
}
