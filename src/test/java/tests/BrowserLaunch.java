package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicArrowButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	@Test
	public void init() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qavalidation.com/demo/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("Subhashini");
		driver.findElement(By.id("email")).sendKeys("Subhashini@abc.com");
		driver.findElement(By.id("tel")).sendKeys("1234567890");
		// driver.findElement(By.linkText("Selenium Tutorial!")).click();
		driver.findElement(By.name("experience")).click();
//		driver.findElement(By.xpath("//input[@value='manualtesting']")).click();
//		driver.findElement(By.xpath("//input[@value='automationtesting']")).click();
//		driver.findElement(By.xpath("//input[@value='java']")).click();
//		driver.findElement(By.xpath("//input[@value='html']")).click();
		WebElement el = driver.findElement(By.id("submit"));

		System.out.println(el.getAttribute("type"));
		System.out.println(driver.getCurrentUrl());
		int s = driver.findElements(By.tagName("input")).size();
		System.out.println(s);
		List<WebElement> radio = driver.findElements(By.name("experience"));
		for (WebElement we : radio) {
			if (we.getAttribute("value").equalsIgnoreCase("four"))
				we.click();

		}
		boolean sel = driver.findElement(By.xpath("//*[@value='four']")).isSelected();
		System.out.println(sel);
		WebElement radiose = driver.findElement(By.xpath("//*[@value='four']"));
		String n = radiose.getAttribute("value");
		System.out.println(n);

		List<WebElement> checkbox = driver.findElements(By.name("language"));

		for (WebElement cb : checkbox) {
			cb.click();
		}

		WebElement multi = driver.findElement(By.xpath("//select[@id='tools']"));

		Select se = new Select(multi);
		se.selectByIndex(0);
		se.selectByIndex(1);
		se.selectByIndex(2);

		List<WebElement> selectedOption = se.getAllSelectedOptions();
		for (WebElement webElement : selectedOption) {
			String name =webElement.getText();
			System.out.println("selected options are: " + name);
		}

		WebElement s1 = driver.findElement(By.name("sgender"));
		Select ds = new Select(s1);
		ds.selectByIndex(1);
		System.out.println(ds.getFirstSelectedOption().getText());
		
		
		driver.findElement(By.linkText("Alerts")).click();
		// driver.close();
	}

}
