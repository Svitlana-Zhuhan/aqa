package lection26_selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GaragePage {
    private SelenideElement addCarButton = $("button.btn.btn-primary");
    public SelenideElement addedCarTitle = $(".car_name.h2");
    public SelenideElement mileageUpdateParagraph = $("p.car_update-mileage");
    public SelenideElement mileageInput = $(".update-mileage-form_input.ng-untouched");
    public SelenideElement carLogoImage = $(".car_logo.car-logo img");

    public AddCarPopup clickAddCarButton() {
        addCarButton.click();
        return page(AddCarPopup.class);
    }
}
