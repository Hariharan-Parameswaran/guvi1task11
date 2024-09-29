package guviTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Q3 {

	public static void main(String[] args) {
		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 // Launch the GUVI website
		driver.get("https://www.guvi.in/");
		 // Click on the 'Sign up' button
		WebElement signupbtn = driver.findElement(By.linkText("Sign up"));
		signupbtn.click();
		 // Fill in the signup form
		WebElement enterName = driver.findElement(By.id("name"));
		enterName.sendKeys("hari");
		WebElement enterEmail = driver.findElement(By.id("email"));
		enterEmail.sendKeys("hari7872@gmail.com");
		WebElement enterPassword = driver.findElement(By.id("password"));
		enterPassword.sendKeys("hari12365");
		WebElement enterMobileno = driver.findElement(By.id("mobileNumber"));
		enterMobileno.sendKeys("6458714527");
		// Click on the 'Sign up' button to submit the form
		WebElement signButton = driver.findElement(By.id("signup-btn"));
		signButton.click();
		  // Click on 'Later' button
		WebElement laterButton = driver.findElement(By.id("laterBtn"));
		laterButton.click();
		// Wait for the registration success message and verify it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Almost Done! Check Your Inbox!']")));
		String regText = message.getText();
		Assert.assertEquals(regText, "Almost Done! Check Your Inbox!");
		
		 // Navigate back to the homepage
		WebElement logobtn = driver.findElement(By.xpath("//a[@class = 'navbar-guvilogo-black']"));
		logobtn.click();
		// Click on the 'Login' button
		WebElement loginbtn = driver.findElement(By.id("login-btn"));
		loginbtn.click();
		  // Fill in the login form
		WebElement emailText = driver.findElement(By.id("email"));
		emailText.sendKeys("hariharanparameswaran05@gmail.com");
		WebElement passwordText = driver.findElement(By.id("password"));
		passwordText.sendKeys("s6ALgaZyPSK!!qF");
		 // Click on the 'Login' button to submit the form
		WebElement loginSubmit = driver.findElement(By.xpath("//a[@id='login-btn']"));
		loginSubmit.click();
		 // Wait for the title to confirm login and verify it
		wait.until(ExpectedConditions.titleIs("GUVI | courses"));
		String titleText  = driver.getTitle();
		if(titleText.equalsIgnoreCase("GUVI | courses")) {
			System.out.println(" User Login Successfully ");
		}else {
			System.out.println(" User Login unSuccessfully ");
		}
		 // Close the browser
		driver.close();
	}

}
