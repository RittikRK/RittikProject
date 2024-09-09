package Test02;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTestCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demo.dealsdray.com/");
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'chevron_right')]")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\atris\\Desktop\\Demo File\\demo-data.xlsx");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		driver.switchTo();
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		Alert alertpopup = driver.switchTo().alert();
		System.out.println(alertpopup.getText());
		alertpopup.accept();
		
		 TakesScreenshot screenshot = (TakesScreenshot) driver;
         File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
         File destFile = new File("./Test02ScreenshotFolder/Screenshot.jpeg");
         FileHandler.copy(srcFile, destFile);
         
         driver.quit();
         
         



		



		
		
	}

}

