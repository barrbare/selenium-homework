import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        if (message.getText().contains("It's enabled!")) {
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს");
        }

        WebElement disableButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']"))
        );
        if (disableButton.isDisplayed()) {
            System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");
        }

        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        inputField.sendKeys("Bootcamp");
        inputField.clear();


        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        int A = driver.findElement(By.id("column-a")).getLocation().getY();
        int B = driver.findElement(By.id("column-b")).getLocation().getY();

        if (A == B) {
            System.out.println("სვეტები A და B გასწორებულია");
        }

        driver.quit();
    }
}
