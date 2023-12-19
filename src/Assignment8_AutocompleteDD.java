import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8_AutocompleteDD {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		// Open the QAClickAcademy page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		String s = "Ind";
		String s_required = "India";
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(s);
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.xpath(
				"//ul[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front\"]/li[@class=\"ui-menu-item\"]/div"));
		System.out.println(suggestions.size());
		for (int i = 0; i < suggestions.size(); i++) {
			System.out.println(suggestions.get(i));
			if (suggestions.get(i).getText().equals(s_required)) {
				Actions a = new Actions(driver);
				a.moveToElement(suggestions.get(i)).click(suggestions.get(i)).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		System.out.println(driver.findElement(By.cssSelector("input#autocomplete.inputs.ui-autocomplete-input"))
				.getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.cssSelector("input#autocomplete.inputs.ui-autocomplete-input"))
				.getAttribute("value"), s_required);

	}

}
