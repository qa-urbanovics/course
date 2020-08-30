package page.object.test;

import org.junit.jupiter.api.Test;
import page.object.BaseFunc;
import page.object.pages.ArticlePage;
import page.object.pages.CommentsPage;
import page.object.pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class PageObjectTests {
    @Test
    public void pageObjectTest(){
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
