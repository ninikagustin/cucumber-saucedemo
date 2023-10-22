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

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

@Given("user is on saucedemo page")
public void user_is_on_saucedemo_page() throws Exception {
    WebDriverManager.edgedriver().setup();
    EdgeOptions opt = new EdgeOptions();

    driver = new EdgeDriver(opt);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);
}

@When("user input valid username and password")
public void user_input_valid_username_and_password() {
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
}

@And("user click button Login")
public void user_click_button_login() {
    driver.findElement(By.id("login-button")).click();
}

@Then("home page should be displayed")
public void home_page_should_be_displayed() {
    Assert.assertEquals("Products", driver.findElement(By.className("title")).getText());
    System.out.println("Scenario : Login as valid user");
    System.out.println("If Success Login, you can see title name " + driver.findElement(By.className("title")).getText());
    driver.quit();
}

@When("user input invalid username and password")
public void user_input_invalid_username_and_password() {
    driver.findElement(By.id("user-name")).sendKeys("standart_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
}

@Then("error message should be displayed")
public void error_message_should_be_displayed() {
    Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
    System.out.println("Scenario : Login as invalid user");
    System.out.println("If Failed Login, you can see error " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
    driver.quit();
}

}