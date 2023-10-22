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

public class Sort {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login in saucedemo page")
    public void user_login_in_saucedemo_page() throws Exception {
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

    @When("user click Name \\(A to Z) feature")
    public void user_click_name_a_to_z_feature() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
    }


    @And("user choose low to high price")
    public void user_choice_low_to_high_price() {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
    }

    @Then("product will be sort low to high based on price")
    public void product_will_be_sort_low_to_high_based_on_price() {
        Assert.assertEquals("$7.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        System.out.println("Scenario: sorting price low to high)");
        System.out.println("If Success Sorting Price Low to High, You Can See Firt Product Will See Price " + driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
    }

}
