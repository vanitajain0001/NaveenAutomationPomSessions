package tesntngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoOpentCartAssignmentTest extends BaseTest {
	
	@DataProvider()
	public Object[][] registerAccountData() {
		return new Object[][]  {
			{"name" ," test" ,  "test@gmail.com", "237655", "password"},
			{"name11" ," test11" ,  "test11@gmail.com", "23765511", "password1"},
		
			{"","","","",""}
					};	
					
	}

	
	@Test(dataProvider = "registerAccountData")
	public void doEnterDetailsTest(String name, String lastName,String email, String telNum, String password) {
		
		
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(name);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(telNum);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
	
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

		
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"content\"]/h1"))
				.isDisplayed());
	}
}
