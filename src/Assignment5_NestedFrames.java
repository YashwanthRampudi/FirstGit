import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment5_NestedFrames {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.cssSelector("a[href*='nested']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[@name=\"frame-top\"]")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frameset[@name=\"frameset-middle\"]/frame[@name=\"frame-middle\"]")));
		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
		driver.switchTo().defaultContent();
		driver.quit();

	}

}
