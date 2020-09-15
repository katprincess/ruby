package ruby;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class testing {

	@Test
	public void main() throws InterruptedException {
		// get the properties of chrome driver
		// link the driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\icest\\eclipse-workspace\\ruby\\driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		
		// maximizing the window
		d.manage().window().maximize();
		
		// setting the smart wait to 3 seconds
		// the system will decide if it wants to wait.
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// get the web site
		d.get("https://github.com/rails");
		
		// assert / verify the link is taking me to ruby on rails . github (validate
		// title)
		// expected - Ruby on Rails · GitHub
		// actual - make the system verify the title.
		String expected = "Ruby on Rails · GitHub";
		String actual = d.getTitle();
		Assert.assertEquals(actual, expected);
				
		// getting window handle before clicking
		String one = d.getWindowHandle();
		
		// click on rails
		d.findElement(By.linkText("rails")).click();
		
		// since the files in the rail is dynamic in nature i will use list to contain
		// it.
		// use an xpath of the list
		List<WebElement> list = d.findElements(
				By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div[2]/div[1]/div[2]/div[3]/div[1]"));
		
		// use advanced for loop, which will locate all the tags.
		// then get all the tags with syso and get text.
		for (WebElement list2 : list) {
			System.out.println(list2.getText());
		}
		
		// scrolling down
		JavascriptExecutor j = (JavascriptExecutor) d;
		j.executeScript("scroll(0,600)");
		
		// clicking the guides button
		d.findElement(By.id("09dd7000e9f9fa14141eea8ea8edc13c-a884af161106c91eed70bd50ffd9f9af2252a738")).click();
		
		// returning to the main page
		d.findElement(By.xpath("//*[@rel=\"author\"]")).click();
				
		// performing hover over / move over on why github?
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/summary")))
				.build().perform();
		
		// typing something in the search field
		d.findElement(By.name("q")).sendKeys("path");
		d.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		List<WebElement> list2a = d.findElements(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/nav[1]"));
		for (WebElement list3 : list2a) {
			System.out.println(list3.getText());
		}
		d.close();
		d.quit();
	}
}
