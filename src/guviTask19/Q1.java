package guviTask19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.guvi.in/register");

		// ID Locators
		driver.findElement(By.id("name"));
		driver.findElement(By.id("email"));
		driver.findElement(By.id("password"));
		driver.findElement(By.id("mobileNumber"));
		driver.findElement(By.id("signup-btn"));

		// ClassName Locators
		driver.findElement(By.className("form-control"));
		driver.findElement(By.className("form-control password-err"));
		driver.findElement(By.className("form-control countrycode-left"));
		driver.findElement(By.className("btn signup-btn"));

		// TagName Locators
		driver.findElement(By.tagName("input"));
		driver.findElement(By.tagName("button"));

		// CSS Selectors Locators
		driver.findElement(By.cssSelector("input#name"));
		driver.findElement(By.cssSelector("input#email"));
		driver.findElement(By.cssSelector("input[id='password']"));
		driver.findElement(By.cssSelector("input[id='mobileNumber']"));
		driver.findElement(By.cssSelector("a.btn.signup-btn"));

		// Xpath Locators
		driver.findElement(By.xpath("//input[@id='name']"));
		driver.findElement(By.xpath("//input[@id='email']"));
		driver.findElement(By.xpath("//input[@id='password']"));
		driver.findElement(By.xpath("//input[@id='mobileNumber']"));
		driver.findElement(By.xpath("//a[@id='signup-btn']"));
	}

}
