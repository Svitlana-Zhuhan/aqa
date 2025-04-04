package lection17_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstSeleniumTest {
    public static void main(String[] args) {
        try {
            WebDriver browser = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(browser::quit));
            browser.get("https://guest:welcome2qauto@qauto.forstudy.space/");

            WebElement exchangeButton = browser.findElement(By.xpath("//button[contains(text(), 'Guest log in')]"));
            exchangeButton.click();
            Thread.sleep(3000);

            List<WebElement> menuItems = browser.findElements(By.cssSelector(".header_nav, d-flex, align-items-center"));

            for (WebElement item : menuItems) {
                System.out.println(item.getText());
            }

        } catch (Exception e) {

            System.out.println("was exception" + e.getMessage());

        }
        System.out.println("Finish");
    }

}
