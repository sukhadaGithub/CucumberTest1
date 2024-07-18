package StepDefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class OrangeHrmTest {
	
	static WebDriver driver;
	String employeeId;
	
	@Given("Enter given username and password")
	public void enter_given_username_and_password() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@When("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	}

	@Then("Validate login title")
	public void validate_login_title() {
		 String hometitle=driver.getTitle();
		    Assert.assertEquals(hometitle, "OrangeHRM");

	}

	@When("validate title of Home fun")
	public void validate_title_of_home_fun() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Validate URL of Home fun")
	public void validate_url_of_home_fun() {
		 String hometitle=driver.getTitle();
		    Assert.assertEquals(hometitle, "OrangeHRM");

	}

	@Given("Click on PIM,click on Add employee")
	public void click_on_pim_click_on_add_employee() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
	}

	@When("Enter {string},{string},{string},Capture employee id")
	public void enter_capture_employee_id(String firstname, String lastname, String middlename) throws InterruptedException {
	   driver.findElement(By.name("firstName")).sendKeys(firstname);
	   driver.findElement(By.name("lastName")).sendKeys(lastname);
	   driver.findElement(By.name("middleName")).sendKeys(middlename);
	 
	   employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"))
				.getAttribute("value");
       System.out.println("Employee id"+employeeId);
		
		Thread.sleep(5000);
	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}

	@When("Enter {string} and Select {string},Click on Save Button")
	public void enter_and_select_click_on_save_button(String country, String gender) throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div/child::div")).click();
	   //driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label/span")).click();
	   Thread.sleep(5000);
	  List< WebElement> countryList=driver.findElements(By.xpath("//div[@class='oxd-select-option']/child::span"));
	   for (WebElement clist : countryList) {
			String actualResult = clist.getText();
			if (actualResult.equalsIgnoreCase(country)) {
				clist.click();
				break;
			}
	   }

	   List<WebElement> genderList=driver.findElements(By.xpath("//input[@type='radio']"));
	   for (WebElement glist : genderList) {
			String result = glist.getText();
			if (result.equalsIgnoreCase(gender))
			{
				glist.click();
				break;
			}

		}
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
  
	}

	@When("click on emplyoee list, enter employee id")
	public void click_on_emplyoee_list_enter_employee_id() throws InterruptedException {
		Thread.sleep(5000);
	   driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	   driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/child::input")).sendKeys(employeeId);
	   
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	}

	@Then("delete employee and confirm delete")
	public void delete_employee_and_confirm_delete() {
	    driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
	}


}
