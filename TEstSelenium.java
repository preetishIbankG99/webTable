package comm.dummytest;

import java.util.List;      //  //table[@id='customers']--->BaseTableXpath

//columns>>>>>>//table[@id='customers']//th
//All Rows within table>>>>>//table[@id='customers']//tr
//All data within table>>>>>//table[@id='customers']//td
//For Matching second column company>>>>//table[@id='customers']//tr//td[2]
//For Matching 4th column country>>>>>>//table[@id='customers']//tr//td[4]
//for traversing back to perform click action on checkbox >>>>//td[text()='Selenium']/preceding-sibling::td//input
//for traversing forward to perform click action on link>>>//td[text()='Ola']/following-sibling::td[3]/a
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TEstSelenium {
public static WebDriver driver;
	@Test
	public void verifyTable() {
		
	
System.setProperty("webdriver.chrome.driver", "../TestingTypes/Drivers/chromedriver.exe");
	driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.navigate().to("http://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
	 List<WebElement>allHeader=driver.findElements(By.xpath("//table[@id='customers']//th"));
	 System.out.println(allHeader.size());
	 Assert.assertEquals(allHeader.size(), 5,"Column count is not same");
	 boolean status=false;
	 for(WebElement ele:allHeader) {
		 String value=ele.getText();
		 System.out.println(value);
		 if(value.contains("Country")) {
			 status=true;
			 break;
		 }
	 }
	 Assert.assertTrue(status,"Header is not Present");
	
	System.out.println("==============================");
List<WebElement>numberofRows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
System.out.println("Total Count of rows "+numberofRows.size());
Assert.assertEquals(numberofRows.size(), 7,"Table Row count mismatch");
List<WebElement>allData=driver.findElements(By.xpath("//table[@id='customers']//td"));
boolean dataStatus=false;
for(WebElement ele:allData) {
	 String value=ele.getText();
	 System.out.println(value);
	 if(value.contains("Jenkins")) {
		 dataStatus=true;
		 break;
	 }
}
Assert.assertTrue(dataStatus,"DataRecord is not Present");
driver.findElement(By.xpath("//td[text()='Selenium']/preceding-sibling::td//input")).click();
driver.findElement(By.xpath("//td[text()='Ola']/following-sibling::td[3]/a")).click();

driver.close();
	}
}