import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignement3_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("learning");
		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();

		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class=\"modal-body\"] p")));
		System.out.println(driver.findElement(By.cssSelector("div[class=\"modal-body\"] p")).getText());
		driver.findElement(By.xpath(
				"//div[@class=\"modal-content\"]//div[@class=\"modal-footer justify-content-center\"]//button[@id=\"okayBtn\"]"))
				.click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector("div[class=\"form-group\"] select[class=\"form-control\"]")));
		WebElement dropDown = driver
				.findElement(By.cssSelector("div[class=\"form-group\"] select[class=\"form-control\"]")); // select[class=\"form-control\"]
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input[id=\"terms\"]")).click();
		driver.findElement(By.id("signInBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"list-group\"]")));

		// iphone X Samsung Note 8 Nokia Edge Blackberry
		String[] itemsToAdd = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class=\"card-title\"] a"));
		for (int i = 0; i < products.size(); i++) {

			String product = products.get(i).getText();
			List itemsNeededList = Arrays.asList(itemsToAdd);
			if (itemsNeededList.contains(product)) {
				j++;
				driver.findElements(By.xpath("//div[@class=\"card-footer\"]//button[@class=\"btn btn-info\"]")).get(i)
						.click();
				if (j == itemsToAdd.length) {
					break;
				}
			}
		}

	}

}
