package page.object.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import page.object.BaseFunc;
import page.object.pages.ArticlePage;
import page.object.pages.CommentsPage;
import page.object.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectTests {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void pageObjectTest(){
        LOGGER.info("This test will check article title on home page, artcile and comments");

        BaseFunc baseFunc = new BaseFunc(); //new - it's copy object (create construction)
        baseFunc.openPage("delfi.lv");

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(2);
        ArticlePage articlePage = homePage.openArticle(2);

        assertEquals(homePageTitle, articlePage.getTitle(), "Wrong title on article page");

        CommentsPage commentsPage = articlePage.openComments();

        assertEquals(homePageTitle, commentsPage.getTitle(), "Wrong title on comment page");

        //ArticlePage articlePage = new ArticlePage(baseFunc);
    }

}
