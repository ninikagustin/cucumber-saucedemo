package sauceDemo.stepDef;

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

public class ProductDetails {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login in saucedemo page")
    public void user_login_in_saucedemo_page_product() throws Exception {
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

    @When("user click product name")
    public void user_click_product_name() {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
    }

    @Then("details product page is displayed")
    public void details_product_page_is_displayed() {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("If Success Choose Product Detail " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + ", You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + " in Product Detail Page");
        driver.quit();
    }
}
