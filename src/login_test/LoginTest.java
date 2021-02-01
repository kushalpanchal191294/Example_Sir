package login_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
String actual_title_afterLogout = "Amicus Cloud";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nidhy\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://cloud.amicusattorney.com/");
		
		driver.findElement(By.id("tbEmail")).sendKeys("jdee@ggqaj1.1law.pro");
		driver.findElement(By.id("tbPwd")).sendKeys("Password123$");
		
		WebElement rememberMe =  driver.findElement(By.id("cbRememberMe"));
		WebElement keepMeLogin =  driver.findElement(By.id("cbTimeToLive"));
		rememberMe.click();
		keepMeLogin.click();
		
		Select selection = new Select(driver.findElement(By.id("ddTimeToLive")));
		selection.selectByVisibleText("2 days");
	
		driver.findElement(By.id("btLogin")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if(!driver.findElements(By.id("lkLogout")).isEmpty()) {
			System.out.println("user is successfully login");
			
		}
		else if(!driver.findElements(By.xpath("//span[text()='Continue To Login Anyway']")).isEmpty()) {
				driver.findElement(By.xpath("//span[text()='Continue To Login Anyway']")).click();
				if(driver.findElement(By.id("lkLogout")).isDisplayed()) {
					System.out.println("user is successfully login");	
				}		
		}
		js.executeScript("arguments[0].click();",driver.findElement(By.id("lkLogout")));
		if(driver.getTitle().equals(actual_title_afterLogout)) {
			System.out.println("user successfully logout.");
		}
		
	}
	
		

}
