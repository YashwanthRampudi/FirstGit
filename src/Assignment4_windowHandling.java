import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;

public class Assignment4_windowHandling {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		List<WebElement> linkElements = driver.findElements(By.tagName("li"));
		System.out.println(linkElements.size());
		driver.findElement(By.xpath("//ul/li/a[text()=\"Multiple Windows\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"example\"]/a[text()=\"Click Here\"]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div[@class=\"example\"]/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div[class=\"example\"] h3")).getText());
		driver.quit();
	}

}
