package page.object.test;

import org.junit.jupiter.api.Test;
import page.object.BaseFunc;

public class PageObjectTests {
    @Test
    public void pageObjectTest(){
        BaseFunc baseFunc = new BaseFunc(); //new - it's copy object (create construction)
        baseFunc.openPage("delfi.lv");
    }
}
