package test;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TP {

	public static void main(String[] args) {
		//second
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--headless");
		
		
		WebDriver driver=new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		
		driver.get("http://192.168.0.1");
		
		WebDriverWait wait=new WebDriverWait(driver,3000);
		
		driver.findElement(By.id("userName")).sendKeys("admin");
		
		driver.findElement(By.id("pcPassword")).sendKeys("admin");
		
		driver.findElement(By.id("loginBtn")).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("bottomLeftFrame")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Bandwidth Control']"))).click();
		
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainFrame")));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("down_bandWidth"))).clear();
		
		String input = JOptionPane.showInputDialog("Enter  download speed");
	
		
		driver.findElement(By.name("down_bandWidth")).sendKeys(input);
		
		driver.findElement(By.name("Save")).click();
		
		
		
		
		
		

	}

}
