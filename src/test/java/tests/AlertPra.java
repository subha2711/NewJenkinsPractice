package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPra {

	@Test
	public void practiceAlert() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qavalidation.com/demoalerts/");
//		WebElement alertButton = driver.findElement(By.linkText("Alerts"));
//		alertButton.click();

		//driver.get("https://qavalidation.com/demoalerts/");
		WebElement commit = driver.findElement(By.name("commit"));
		
		commit.click();
;
		Alert alert = driver.switchTo().alert();
			alert.accept();
			
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		
		alert.sendKeys("Hello Subha");
		Thread.sleep(4000);
		alert.accept();
		Thread.sleep(4000);

		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.click();
		alert.dismiss();
		
	}

}
