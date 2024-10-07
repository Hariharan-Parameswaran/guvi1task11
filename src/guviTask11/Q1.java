package guviTask11;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		// Maximize browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Navigate to the URL
		driver.get("https://the-internet.herokuapp.com/windows");
		// Click the "Click Here" link to open a new window
		driver.findElement(By.linkText("Click Here")).click();
		// Store the original window handle
		String OriginalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		Iterator<String> iterat = allWindows.iterator();
		while (iterat.hasNext()) {
			String NewWindow = iterat.next();
			if (!OriginalWindow.equalsIgnoreCase(NewWindow)) {
				// Switch to the new window
				driver.switchTo().window(NewWindow);
				String newText = driver.findElement(By.tagName("h3")).getText();
				Thread.sleep(2000);
				// Verify that the text "New Window" is present
				if (newText.equals("New Window")) {
					System.out.println("Text verification Successfully.");
				} else {
					System.out.println("Text verification failed. ");
				}
				// Close the new window
				driver.close();
			}
		}
		// Switch back to the original window
		driver.switchTo().window(OriginalWindow);
		String originalTitle = driver.getTitle();
		// Verify that the original window is active
		if (originalTitle.equals("The Internet")) {
			System.out.println("Original window is active.");
		} else {
			System.out.println("Original window is not active.");
		}
		// Close the browser instance
		driver.quit();
	}

}
