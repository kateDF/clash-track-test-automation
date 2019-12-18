package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.karpuk.clashtrack.core.listener.TestListener.logError;
import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class WarWeightCalculatorPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'slider-tick custom')]")
    private List<WebElement> levelSliderButtons;

    @FindBy(xpath = "//div[@class='col-xs-6 col-md-6 col-lg-3' and not(@style='display: none;' or @style='display:none')]//input")
    private List<WebElement> storageInputs;

    @FindBy(xpath = "//a[@id='calc_button']")
    private WebElement calculateButton;

    @FindBy(xpath = "//span[@id='weight_result']")
    private WebElement calculatedWeightResult;

    public void selectTownHallLevel(TownHallLevelsEnum levelEnum) {
        int level = levelEnum.getValue();
        if (level > 3 && level < 13) {
            logInfo("Select town hall level: " + level);
            levelSliderButtons.get(level - 3).click();
        } else {
            logError("Unsupported town hall level");
        }
    }

    public void selectGoldInStorage(int storageNumber, int gold) {
        if (storageInputs.size() >= storageNumber) {
            logInfo("Select " + gold + " gold amount in the storage number " + storageNumber);
            storageInputs.get(storageNumber - 1).clear();
            storageInputs.get(storageNumber - 1).sendKeys(String.valueOf(gold));
        } else {
            throw new UnsupportedOperationException("Invalid storage number for selected level");
        }
    }

    public void calculateWarWeight() {
        logInfo("Start war weight calculation");
        calculateButton.click();
    }

    public double getCalculatedWarWeight() {
        return Double.parseDouble(calculatedWeightResult.getText());
    }

    public int getNumberOfStorage() {
        return storageInputs.size();
    }

}
