package stepDefintion.servicenow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateChange extends MyBaseTest {
	String chNumber;
	
	/*
	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("Load URL {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}
	*/
	
	@Given("Type username as {string}")
	public void typeUserName(String username) {
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(username);
	}

	@And("Type password as {string}")
	public void typepassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}
	
	@When("Click Login Button")
	public void clickLogin() throws InterruptedException {
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
	}

	@Then("Verify Login is successful")
	public void isSuccess() throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		String welcomeMessage = driver.findElement(By.xpath("//div[text()='Get Started']")).getText();
		if(welcomeMessage.contains("Get Started")) {
			System.out.println("Successfully Logged In");
		}
		driver.switchTo().defaultContent();
	}
	
	@Given("Enter the Change in Filter Navigation and click Enter")
	public void enterChangeText() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("Change", Keys.ENTER);
		Thread.sleep(5000);
	}
	
	@When("Click Create New button")
	public void clickNewButtonChange() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Change']/following::div[text()='Create New'])[1]")).click();
		Thread.sleep(2000);
	}
	
	@And("Click Normal Change")
	public void clicknormalChange() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='change-model-card-component'])[2]")).click();
		Thread.sleep(3000);
	}
	
	@Given("Capture the Created change number")
	public void captureCreatedChangenum() throws InterruptedException {
		chNumber = driver.findElement(By.id("change_request.number")).getAttribute("value");
		System.out.println("The Created Change number is : " + chNumber);
	}
	

	@And("Enter Short Description {string}")
	public void entershortDescChange(String ShortDesc) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("change_request.short_description")).clear();
		driver.findElement(By.id("change_request.short_description")).sendKeys(ShortDesc);
	}
	
	@When("Click Submit button")
	public void clickSubmitChange() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(3000);
	}
	
	@And("Click Open button")
	public void clickOpenChange() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Change']/following::div[text()='Open']")).click();
		Thread.sleep(3000);
	}
	
	@Given("Enter the Change number")
	public void enterChangeNumber() throws InterruptedException {
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		// Enter the Change number  and validate whether it is created or not
		WebElement searchDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select srchDropdown = new Select(searchDropDown); 
		srchDropdown.selectByVisibleText("Number");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(chNumber, Keys.ENTER);
		Thread.sleep(2000);
	}
	
	@Then("Validate the Create change Number")
	public void validateChangeNum() throws InterruptedException {
		String changeNumberCreated = driver.findElement(By.xpath("//table[@id='change_request_table']//tbody[1]//tr[1]//td[3]")).getText();
		System.out.println(changeNumberCreated);
		if (chNumber.equals(changeNumberCreated)) {
			System.out.println("New Change number should be created successfully");
		} else {
			System.out.println("New chNumber number not created");

		}

	}
	
}

