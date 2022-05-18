/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FlightAndHotel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 *
 * @author Bob
 */
public class SimpleFlightAndHotelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver","D:\\netbeansProjects\\LIB\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize(); 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.traveloka.com");
        driver.findElement(By.xpath("//*[.='Flights']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Destination']")).click();
        driver.findElement(By.xpath("//span[.='Singapore, Singapore']")).click();
        driver.findElement(By.xpath("//input[@aria-labelledby='flight_passengers']")).click();
        driver.findElement(By.xpath("//div[@data-testid='passengers-stepper-plus-adult']")).click();
        driver.findElement(By.xpath("//div[text()='Done']")).click();
        driver.findElement(By.xpath("//input[@data-testid='departure-date-input']")).click();
        Thread.sleep(3000);
        int today = Integer.parseInt(driver.findElement(By.xpath("//div[@data-testid='date-marker-today']//preceding-sibling::div")).getText());
        int date = today + 3;
        driver.findElement(By.xpath("//div[.='"+date+"']")).click();
        driver.findElement(By.xpath("//div[.='Return Date']")).click();
        driver.findElement(By.xpath("//input[@data-testid='return-date-input']")).click();
        int depDate = date + 3;
        driver.findElement(By.xpath("//div[@data-testid='return-date-calendar-container']//div[.='"+depDate+"']")).click();
        driver.findElement(By.xpath("//div[.='Economy']")).click();
        driver.findElement(By.xpath("//div[.='Business']")).click();
        driver.findElement(By.xpath("//div[.='Search Flights'][2]")).click();
        Thread.sleep(10000);
        if(driver.findElement(By.xpath("//h4[.='Jakarta → Singapore']")).isDisplayed()){
            driver.quit();
        }
    }
    
}
