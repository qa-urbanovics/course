package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import page.object.BaseFunc;

import static org.openqa.selenium.By.*;

public class ArticlePage {

    private final By TITLE = xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS = xpath(".//a[contains(@class, 'd-print-none')]");

    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title");

        return baseFunc.getText(TITLE).trim();
    }

    public CommentsPage openComments() {
        LOGGER.info("Try to open comments page");

        baseFunc.click(COMMENTS);
        return new CommentsPage(baseFunc);
    }
}
