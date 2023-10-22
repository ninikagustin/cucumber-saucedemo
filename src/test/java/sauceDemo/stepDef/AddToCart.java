package sauceDemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class AddToCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login in saucedemo page")
    public void user_login_in_saucedemo_page_cart() throws Exception{
        WebDriverManager.edgedriver().setup();
        EdgeOptions opt = new EdgeOptions();

        driver = new EdgeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click button add to cart")
    public void user_click_button_add_to_cart() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("user click icon cart")
    public void user_click_icon_cart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("cart page displays user-selected product")
    public void cart_page_displays_user_selected_product() {
        Assert.assertEquals("Sauce Labs Backpack", driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario: Adding product to cart");
        System.out.println("If Success Add Product to Cart " + driver.findElement(By.xpath("///div[@class='inventory_item_name']")).getText() + " , You can see title Product name " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in Cart Page");
        driver.quit();
    }

}
