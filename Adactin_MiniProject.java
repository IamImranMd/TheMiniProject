package com.org.adactinproject;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Adactin_MiniProject {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\eclipse-workspace\\Sele_Java\\web\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("ImranToretto");
		driver.findElement(By.id("password")).sendKeys("Imran@1995");
		Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement location = driver.findElement(By.id("location"));
		Select s1 = new Select(location);
		s1.selectByIndex(1);
		Thread.sleep(1000);

		WebElement hotels = driver.findElement(By.id("hotels"));
		Select s2 = new Select(hotels);
		s2.selectByIndex(2);
		Thread.sleep(1000);

		WebElement room_type = driver.findElement(By.id("room_type"));
		Select s3 = new Select(room_type);
		s3.selectByIndex(4);
		Thread.sleep(1000);

		WebElement room_nos = driver.findElement(By.id("room_nos"));
		Select s4 = new Select(room_nos);
		s4.selectByIndex(1);
		Thread.sleep(1000);

		Robot r = new Robot();
		WebElement checkindate = driver.findElement(By.name("datepick_in"));
		checkindate.click();
		for (int i = 0; i < 11; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		checkindate.sendKeys("22/11/2021");
		Thread.sleep(1000);

		WebElement checkoutdate = driver.findElement(By.name("datepick_out"));
		checkoutdate.click();
		for (int i = 0; i < 11; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		checkoutdate.sendKeys("23/11/2021");
		Thread.sleep(1000);

		WebElement adult_room = driver.findElement(By.id("adult_room"));
		Select s5 = new Select(adult_room);
		s5.selectByIndex(2);
		Thread.sleep(1000);

		WebElement child_room = driver.findElement(By.id("child_room"));
		Select s6 = new Select(child_room);
		s6.selectByIndex(1);
		Thread.sleep(1000);

		driver.findElement(By.id("Submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("radiobutton_0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("first_name")).sendKeys("Mohamed");
		driver.findElement(By.id("last_name")).sendKeys("Imran");
		driver.findElement(By.id("address")).sendKeys("1st Street,India");
		driver.findElement(By.id("cc_num")).sendKeys("1234567891234567");

		WebElement cctype = driver.findElement(By.id("cc_type"));
		Select s7 = new Select(cctype);
		s7.selectByIndex(2);

		WebElement expmon = driver.findElement(By.id("cc_exp_month"));
		Select s8 = new Select(expmon);
		s8.selectByIndex(5);

		WebElement expyear = driver.findElement(By.id("cc_exp_year"));
		Select s9 = new Select(expyear);
		s9.selectByIndex(12);

		driver.findElement(By.id("cc_cvv")).sendKeys("321");
		driver.findElement(By.id("book_now")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement iter = driver.findElement(By.id("my_itinerary"));
		js.executeScript("arguments[0].scrollIntoView();", iter);
		Thread.sleep(1000);
		iter.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File f1 = ts.getScreenshotAs(OutputType.FILE);
		File f2 = new File("C:\\Users\\hp\\eclipse-workspace\\Sele_Java\\src\\com\\org\\miniproject\\adactin.png");
		FileHandler.copy(f1, f2);
	}

}
