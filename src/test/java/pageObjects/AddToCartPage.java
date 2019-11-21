package pageObjects;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends TestBase {

    Actions actions;
    //-------------------- elements --------------------------
    @FindBy(xpath = "(//a[@class='sf-with-ul'])[4]")
    private WebElement womenDressBtn;


    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement womenDressOne;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    private WebElement womenDressTwo;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")
    private WebElement womenDressThree;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[4]/div/div[1]/div/a[1]/img")
    private WebElement womenDressFour;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[5]/div/div[1]/div/a[1]/img")
    private WebElement womenDressFive;


    @FindBy(xpath = "(//a[@title='Add to cart'])[1]")
    private WebElement addToCartOne;
    @FindBy(xpath = "(//a[@class='button ajax_add_to_cart_button btn btn-default'])[2]")
    private WebElement addToCartTwo;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]")
    private WebElement addToCartThree;
    @FindBy(xpath = "(//a[@title='Add to cart'])[4]")
    private WebElement addToCartFour;
    @FindBy(xpath = "(//a[@title='Add to cart'])[5]")
    private WebElement addToCartFive;


    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement viewShoppingCart;

    @FindBy(xpath = "//*[@id=\"total_product_price_3_13_0\"]")
    private WebElement dressOnePrice;
    @FindBy(xpath = "//*[@id=\"total_product_price_4_16_0\"]")
    private WebElement dressTwoPrice;
    @FindBy(xpath = "//*[@id=\"total_product_price_5_19_0\"]")
    private WebElement dressThreePrice;
    @FindBy(xpath = "//*[@id=\"total_product_price_6_31_0\"]")
    private WebElement dressFourPrice;
    @FindBy(xpath = "//*[@id=\"total_product_price_7_34_0\"]")
    private WebElement dressFivePrice;

    @FindBy(xpath = "//*[@id=\"total_price\"]")
    private WebElement totalPrice;



    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
    private WebElement conShoppingBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
    private WebElement totalCartCount;


    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }


    //--------------------- Actions ----------------------------
    public void performMouseHover(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void waitTillClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(conShoppingBtn));
    }

    public boolean validateText(WebElement element, String expectedText){
        String actualText = element.getText();
        if (actualText.equals(expectedText)){
            return true;
        }
        return false;
    }



    public void addItemToCart() {
        womenDressBtn.click();

        performMouseHover(womenDressOne);
        addToCartOne.click();
        waitTillClickable(conShoppingBtn);
        conShoppingBtn.click();

        performMouseHover(womenDressTwo);
        addToCartTwo.click();
        waitTillClickable(conShoppingBtn);
        conShoppingBtn.click();

        performMouseHover(womenDressThree);
        addToCartThree.click();
        waitTillClickable(conShoppingBtn);
        conShoppingBtn.click();

        performMouseHover(womenDressFour);
        addToCartFour.click();
        waitTillClickable(conShoppingBtn);
        conShoppingBtn.click();

        performMouseHover(womenDressFive);
        addToCartFive.click();
        conShoppingBtn.click();

        viewShoppingCart.click();
        validateText(totalCartCount, "5");
        validateText(dressOnePrice, "$26.00");
        validateText(dressTwoPrice, "$50.99");
        validateText(dressThreePrice, "$28.98");
        validateText(dressFourPrice, "$30.50");
        validateText(dressFivePrice, "$16.40");
        validateText(totalPrice, "$154.87");



    }
}
