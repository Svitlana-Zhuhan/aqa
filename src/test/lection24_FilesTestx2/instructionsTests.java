package lection24_FilesTestx2;

import lection24_Filesx2.GaragePage;
import lection24_Filesx2.InstructionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class instructionsTests {

    private WebDriver driver;
    private final String baseUrl = "https://guest:welcome2qauto@qauto.forstudy.space/";
    private String downloadPath = System.getProperty("user.dir") + "/downloads/";
    private final String CAR_LIST_FILENAME = "car_list.txt";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.xpath("//button[text()='Guest log in']")).click();
    }

    @Test
    public void testFileDownload() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage");

        GaragePage garagePage = new GaragePage(driver);
        garagePage.goToInstructions();

        InstructionsPage instructionsPage = new InstructionsPage(driver);
        instructionsPage.downloadPdf();

        Thread.sleep(3000);

        File file = new File(downloadPath + "Front windshield wipers on Audi TT.pdf");
        Assert.assertTrue(file.exists(), "PDF файл не завантажився!");
    }

    @Test
    public void testSaveAvailableCarsToFile() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/panel/garage"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/panel/garage"));

        GaragePage garagePage = new GaragePage(driver);
        garagePage.goToInstructions();

        InstructionsPage instructionsPage = new InstructionsPage(driver);
        instructionsPage.openCarSelection();

        List<String> actualCarsList = instructionsPage.getAvailableCarNames();
        List<String> expectedCarList = Arrays.asList("Audi", "Bmw", "Ford", "Porsche", "Fiat");
        System.out.println(actualCarsList);
        System.out.println(expectedCarList);

        Assert.assertEquals(actualCarsList.size(), 5, "Actual cars list size is not 5");
        Assert.assertEquals(expectedCarList.size(), 5, "Expected cars list size is not 5");


        instructionsPage.saveCarLIstToFile(actualCarsList, CAR_LIST_FILENAME);

        File carListFile = new File(CAR_LIST_FILENAME);
        Assert.assertTrue(carListFile.exists(), "File " + CAR_LIST_FILENAME + "does not found in project root.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
