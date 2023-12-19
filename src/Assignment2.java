import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.Select;
public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Yash");
		driver.findElement(By.name("email")).sendKeys("ghkk@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("werh");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(gender);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("04-04-2000");
		driver.findElement(By.className("btn-success")).click();

	}

}
