package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.model.enums.BarracksTroopsEnum;
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

    public void selectTroopsCapacityByTypes(BarracksTroopsEnum type, Integer quantity) {
        logInfo("Select " + type.toString() + " with quantity: " + quantity + ". Capacity executing: " + type.getArmySpace() * quantity);
        for (WebElement input : quantityInputs) {
            if (input.getAttribute("id").equalsIgnoreCase(type.toString())) {
                input.sendKeys(quantity.toString());
            }
        }
    }

    public int getAvailableQuantityOfLightBarracks() {
        return Integer.parseInt(availableQuantityLightBarracks.getText().replace("−", "-"));
    }

}
