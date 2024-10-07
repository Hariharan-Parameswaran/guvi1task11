package guviTask11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Navigate to the URL
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		// Switch to the top frame
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);
		// Verify that there are three frames on the page
		List<WebElement> frameList = driver.findElements(By.tagName("frame"));
		int numOfFrames = frameList.size();
		System.out.println(numOfFrames);
		if (numOfFrames == 3) {
			System.out.println("There are 3 frames in the top frame.");
		} else {
			System.out.println("Verification failed! The number of frames found: " + numOfFrames);
		}
		// Switch to the left frame
		WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(leftFrame);
		// Verify the text in the left frame
		String leftFrameText = driver.findElement(By.xpath("/html/body")).getText();
		System.out.println(leftFrameText);
		if (leftFrameText.equals("LEFT")) {
			System.out.println("Verification successful: The left frame contains the text 'LEFT'.");
		} else {
			System.out.println("Verification failed: The left frame does not contain the text 'LEFT'.");
		}
		// Switch back to the top frame
		driver.switchTo().parentFrame();
		// Switch to the middle frame
		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleFrame);
		
		// Verify the text in the middle frame
		String middleFrameText = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(middleFrameText);
		if (middleFrameText.equals("MIDDLE")) {
			System.out.println("Verification successful: The middle frame contains the text 'MIDDLE'.");
		} else {
			System.out.println("Verification failed: The middle frame does not contain the text 'MIDDLE'.");
		}

		// Switch back to the top frame
		driver.switchTo().parentFrame();
		// Switch to the right frame
		WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightFrame);
		// Verify the text in the right frame
		String rightFrameText = driver.findElement(By.xpath("//body")).getText();
		System.out.println(rightFrameText);
		if (rightFrameText.equals("RIGHT")) {
			System.out.println("Verification successful: The right frame contains the text 'RIGHT'.");
		} else {
			System.out.println("Verification failed: The right frame does not contain the text 'RIGHT'.");
		}


		// Switch back to the default content
		driver.switchTo().defaultContent();
		// Switch to the bottom frame
		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomFrame);
		// Verify the text in the bottom frame
		String bottomFrameText = driver.findElement(By.xpath("//html")).getText();
		System.out.println(bottomFrameText);
		if (bottomFrameText.equals("BOTTOM")) {
			System.out.println("Verification successful: The bottom frame contains the text 'BOTTOM'.");
		} else {
			System.out.println("Verification failed: The bottom frame does not contain the text 'BOTTOM'.");
		}

		 // Switch back to the default content
		driver.switchTo().defaultContent();
		// Verify the page title
		String pageTitle = driver.getTitle();
		System.out.println("");
		System.out.println("The page title is : " + pageTitle);
		if (pageTitle.equals("Frames")) {
			System.out.println("Verification successful: The page title contains the text 'Frames'.");
		} else {
			System.out.println("Verification failed: The page title does not contain the text 'Frames'.");
		}
		driver.quit();

	}

}
