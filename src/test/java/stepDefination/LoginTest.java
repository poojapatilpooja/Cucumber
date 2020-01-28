package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginTest 
{
	public static WebDriver driver;
	PageObjects po;
@Given("^Navigate to Home page$")
public void navigate_to_home_page() throws Throwable
{
	System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	po = new PageObjects(driver);

}

@When("^user enters username and password$")
public void user_enters_username_and_password() throws Throwable
{
	po.SignIn.click();
	po.userName.sendKeys("lalitha");
	po.password.sendKeys("Password123");
	po.Login.click();


}
@Then("^user logged in successfully$ ")
public void user_logged_in_successfully() throws Throwable
{
	System.out.println("user login successfully");
}
@When("^Larry searches below products in the search box:$")
public void larry_searches_below_products_in_the_search_box(DataTable dt)
{
	List<String> product = dt.asList(String.class);
	for(String s : product)
	{
		driver.findElement(By.name("products")).sendKeys(s);
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();

	}
	}
@Then("^product should be added in the cart if available$ ")
public void product_should_be_added_in_the_cart_if_available()
{
	
}

@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void entersunamepwd(String uname, String pwd) {
po.SignIn.click();
po.userName.sendKeys(uname);
po.password.sendKeys(pwd);
po.Login.click();

}
}