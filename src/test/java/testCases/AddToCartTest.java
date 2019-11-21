package testCases;

import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AddToCartPage;

public class AddToCartTest extends TestBase {


    @BeforeTest
    public void setup(){
        startChromeBrowser();
    }


    @Test
    public void addToCartTest() {

        AddToCartPage ad = new AddToCartPage();
        ad.addItemToCart();
    }
}
