package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.model.enums.LightBarracksTroopsEnum;
import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.karpuk.clashtrack.core.listener.TestListener.logError;
import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;
import static com.karpuk.clashtrack.ui.core.util.Waiters.waitForVisibility;

public class TroopCostCalculatorPage extends BasePage {

    @FindBy(xpath = "//span[@class='button js-settings-level']")
    private List<WebElement> levelButtons;

    @FindBy(xpath = "//select[@id='army-camps']")
    private WebElement armyCampDropDown;

    @FindBy(xpath = "//td[@class='js-col-light-quantity']/input[contains(@class,'js-comp-quantity')]")
    private List<WebElement> quantityInputs;

    @FindBy(xpath = "//span[@id='light-quantity']")
    private WebElement availableQuantityLightBarracks;

    @FindBy(xpath = "//span[contains(@class,' message_negative') and @id='light-exceeded']")
    private WebElement errorLightBarracks;

    @FindBy(xpath = "//span[@data-reset='light' and @data-scope='quantity']/i")
    private WebElement resetQuantityLightBarracks;

    @FindBy(xpath = "//span[@class='icon-favorite']")
    private WebElement saveArmyCompositionButton;

    @FindBy(xpath = "//td[@class='result js-col-light-quantity']/span[@class='text-middle']")
    private WebElement capacityResultInLightBarracks;

    @FindBy(xpath = "//div[@class='favorite__capacity']")
    private WebElement savedCompositionCapacity;

    public void selectTownHallLevel(TownHallLevelsEnum levelEnum) {
        Integer level = levelEnum.getValue();
        if (level > 0 && level < 12) {
            logInfo("Select town hall level: " + level);
            for (WebElement levelActual : levelButtons) {
                if (Integer.parseInt(levelActual.getText()) == level) {
                    levelActual.click();
                }
            }
        } else {
            logError("Do not support town hall level");
        }
    }

    public void selectArmyCapacity(Integer capacity) {
        logInfo("Select army capacity: " + capacity);
        waitForVisibility(armyCampDropDown);
        new Select(armyCampDropDown).selectByValue(capacity.toString());
    }

    public void selectTroopsCapacityByTypes(LightBarracksTroopsEnum type, Integer quantity) {
        logInfo("Select " + type.getTroopType() + " with quantity: " + quantity + ". Capacity executing: " + type.getArmySpace() * quantity);
        for (WebElement input : quantityInputs) {
            if (input.getAttribute("id").equalsIgnoreCase(type.getTroopType())) {
                input.sendKeys(quantity.toString());
            }
        }
    }

    public int getAvailableQuantityOfLightBarracks() {
        return Integer.parseInt(availableQuantityLightBarracks.getText().replace("−", "-"));
    }

    public String getErrorMessageLightBarracks() {
        return errorLightBarracks.getText();
    }

    public void resetQuantityLightBarracks() {
        logInfo("Reset quantity in light barracks");
        resetQuantityLightBarracks.click();
    }

    public void saveArmyComposition() {
        logInfo("Save army composition");
        saveArmyCompositionButton.click();
    }

    public String getCapacityResultInLightBarracks(){
        return capacityResultInLightBarracks.getText();
    }

    public String getSavedCompositionCapacity(){
        return savedCompositionCapacity.getText();
    }

}
