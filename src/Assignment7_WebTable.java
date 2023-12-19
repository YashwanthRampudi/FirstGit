import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment7_WebTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		// Open the QAClickAcademy page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Scroll down with Javascript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		// Scroll in table
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@class=\"left-align\"]/fieldset/table[@id=\"product\"]/tbody/tr"));
		System.out.println("Number of rows = " + rows.size());
		List<WebElement> columns = driver
				.findElements(By.xpath("//div[@class=\"left-align\"]/fieldset/table[@id=\"product\"]/tbody/tr[1]/th"));
		System.out.println("Number of columns = " + columns.size());
		// printing 3 row data
		List<WebElement> row_datas = driver
				.findElements(By.xpath("//div[@class=\"left-align\"]/fieldset/table[@id=\"product\"]/tbody/tr[4]/td"));
		System.out.println(
				row_datas.get(0).getText() + " " + row_datas.get(1).getText() + " " + row_datas.get(2).getText());

	}

}
