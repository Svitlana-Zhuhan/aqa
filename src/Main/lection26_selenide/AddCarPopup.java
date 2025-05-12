package lection26_selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AddCarPopup {
    private SelenideElement brandDropdown = $("#addCarBrand");
    private SelenideElement modelDropdown = $("#addCarModel");
    private SelenideElement mileageInput = $("#addCarMileage");
    private SelenideElement addButton = $(By.xpath("//button[contains(@class, 'btn-primary') and normalize-space(text())='Add']"));

    public void selectBrand(String brand) {
        brandDropdown.selectOption(brand);
    }

    public void selectModel(String model) {
        modelDropdown.selectOption(model);
    }

    public void enterMileage(String mileage) {
        mileageInput.sendKeys(mileage);
    }

    public GaragePage clickAddButton() {
        addButton.click();
        return page(GaragePage.class);
    }
}
