package parallelExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelExecutionselenium {

	public static WebDriver driver;

	@Test
	public void Test1() {

		System.out.println("parallel Test1");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out
				.println(Thread.currentThread().getId() + ":  Test1 Thread Id");
		driver.quit();
	}

	@Test
	public void Test2() throws InterruptedException {
		System.out.println("parallel Test2");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(4000);

		System.out
				.println(Thread.currentThread().getId() + ":  Test2 Thread Id");
		driver.quit();

	}

	@Test
	public void Test3() throws InterruptedException {
		System.out.println("parallel Test3");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(8000);
		System.out
				.println(Thread.currentThread().getId() + ":  Test3 Thread Id");
		driver.quit();

	}

}
