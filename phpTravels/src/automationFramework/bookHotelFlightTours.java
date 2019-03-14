package automationFramework;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

public class bookHotelFlightTours {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		// Initializing browser
		WebDriver driver = new ChromeDriver();

		// Opening the PHPTRAVELS homepage
		driver.get("https://phptravels.com/demo/");

		// Maximizing browser

		driver.manage().window().maximize();

		// Navigating to the PRICING page to be able to order the Standalone App
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/a"))
				.click();

		// Switching to the new window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Waiting for the first pop up on new window

		WebElement FirstPopUp = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"onesignal-popover-cancel-button\"]")));

		// Closing the first pop up

		FirstPopUp.click();

		// Waiting for the second pop up
		WebDriverWait wait2 = new WebDriverWait(driver, 10);

		// Closing the second pop up

		WebElement SecondPopUp = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"PopupSignupForm_0\"]/div[2]/div[1]")));
		SecondPopUp.click();

		// Scrolling Down to reach the Standalone Web Application ORDER NOW button

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)", "");

		WebDriverWait wait3 = new WebDriverWait(driver, 10);

		// Waiting for the OrderNow button to be visible
		WebElement OrderNow = wait3.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[2]/div[2]/div[1]/div/div/div[2]/div/div[1]/form/button")));

		// Clicking on the Order now button
		OrderNow.click();

		// Waiting for the 3rd window to be opened.
		Thread.sleep(7000);

		// Switching the control to the 3rd window
		String mainWindowHandle = driver.getWindowHandle();
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
			}
		}

		WebDriverWait wait4 = new WebDriverWait(driver, 10);

		// Waiting for the Continue button
		WebElement Continue = wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-boxes\"]/form/div[3]/button")));
		Continue.click();

		WebDriverWait wait5 = new WebDriverWait(driver, 10);

		// Waiting for the Checkoutbutton
		WebElement CheckOut = wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"order-boxes\"]/div[2]/div[2]/form/button")));

		// Clicking on CHECKOUT button to place the order
		CheckOut.click();

	}

}
