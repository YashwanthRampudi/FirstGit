import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.Select;

public class Assignment6_qaclickacademy {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		// Open the QAClickAcademy page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Select any check box
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
		String label = driver.findElement(By.cssSelector("label[for=\"benz\"]")).getText();
		System.out.println("The label is: " + label);
		// Select the same label text in the drop down
		WebElement dd = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dd);
		option.selectByVisibleText(label);
		// Enter the text in Enter your name tab
		driver.findElement(By.xpath("//fieldset[@class=\"pull-right\"]/input[@id=\"name\"]")).sendKeys(label);
		// Click on Alert and verify if the label is present in the alert message
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		driver.switchTo().alert().getText().split(" ")[1].split(",")[0].equals(label);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.close();

	}

}
