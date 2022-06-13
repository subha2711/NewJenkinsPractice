package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFramePract {
	
	@Test
	public void iframePractice() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qavalidation.com/demoiframe/");
		
		//to switch to ifram we can use by id, by frame number or by frame name
		
		//by web element
		
		WebElement frame1 = driver.findElement(By.id("Frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.linkText("SignUp Form")).click();
		driver.findElement(By.name("home")).click();
		driver.switchTo().parentFrame();
		
		
		//by id or name- here its id
		driver.switchTo().frame("Frame1");
		driver.findElement(By.linkText("SignUp Form")).click();
		driver.findElement(By.name("home")).click();
		driver.switchTo().defaultContent();
		
		//by index
		
		driver.switchTo().frame(1);
		driver.findElement(By.name("home")).click();
		driver.findElement(By.linkText("WebTable")).click();
		
		driver.switchTo().defaultContent();
		
		driver.quit();
		
	}

}
