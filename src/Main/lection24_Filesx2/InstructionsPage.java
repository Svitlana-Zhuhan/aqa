package lection24_Filesx2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InstructionsPage extends BasePage {
    public InstructionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='instruction-link_download' and @download and contains(@href, 'instructions/audi/tt/Front windshield wipers')]")
    private WebElement pdfLink;

    @FindBy(css = ".brand-select-dropdown_item")
    private List<WebElement> availableCars;

    @FindBy(css = ".brand-select-dropdown_toggle.dropdown-toggle")
    private WebElement selectBrandDropdown;

    public void downloadPdf() {

        pdfLink.click();
    }

    public void openCarSelection() {

        selectBrandDropdown.click();
    }

    public List<String> getAvailableCarNames() {
        return  availableCars.stream().map(WebElement::getText).toList();
    }

    public void saveCarLIstToFile(List<String> actualCars, String filePath) throws IOException {
        List<String> cars = getAvailableCarNames();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String car : cars) {
                writer.write(car);
                writer.newLine();
            }
        }
    }
}
