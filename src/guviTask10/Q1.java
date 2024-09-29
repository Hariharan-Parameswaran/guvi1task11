package guviTask10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {

	public static void main(String[] args) {
		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Navigate to the URL
		driver.navigate().to("https://jqueryui.com/datepicker/");
		// Switch to the iframe
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		// Click the datepicker input field
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();
		// Click the "Next" button to go to the next month
		WebElement nextMonthbtn = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		nextMonthbtn.click();
		// Select the '22' date from the datepicker
		WebElement selectDate = driver.findElement(By.xpath("//a[normalize-space()='22']"));
		selectDate.click();
		// Print the selected date to the console
		String getSelectValue = datePicker.getAttribute("value");
		System.out.println("Selected date : " + getSelectValue);
		
		driver.quit();
	}

}
