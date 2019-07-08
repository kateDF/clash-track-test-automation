package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class BasesCollectionPage extends BasePage {

    @FindBy(xpath = "//a[@data-tip='tooltips' and @class='btn btn-default btn-sm']")
    private List<WebElement> levelsButtons;

    @FindBy(xpath = "//a[@data-tip='tooltips' and @class='btn btn-default']")
    private WebElement allLevelsButton;

    @FindBy(xpath = "//span[@class='label label-danger']")
    private List<WebElement> baseLevelLabels;

    @FindBy(xpath = "//a[@rel='next']")
    private List<WebElement> nextBasesButton;

    public void selectTownHallLevel(TownHallLevelsEnum levelEnum) {
        Integer level = levelEnum.getValue();
        if (level == 0) {
            logInfo("Select all levels");
            allLevelsButton.click();
        } else {
            selectLevel(level.toString());
        }
    }

    private void selectLevel(String expectedLevel) {
        for (WebElement level : levelsButtons) {
            String title = level.getAttribute("title");
            String[] titleByWords = title.split(" ");
            if (expectedLevel.equals(titleByWords[2])) {
                logInfo("Select " + title);
                level.click();
                break;
            }
        }
    }

    public List<String> getListOfActualLevels() {
        List<String> actualLevels = new ArrayList<>();
        actualLevels.addAll(getLevelLabels());
        while (!nextBasesButton.isEmpty()) {
            nextBasesButton.get(0).click();
            actualLevels.addAll(getLevelLabels());
        }
        logInfo(actualLevels.size() + " results were found");
        return actualLevels;
    }

    public boolean matchLevelsResults(TownHallLevelsEnum expectedLevelEnum) {
        List<String> actualLevels = getListOfActualLevels();
        String expectedLevel = expectedLevelEnum.toString();
        for (String act : actualLevels) {
            if (!expectedLevel.equalsIgnoreCase(act)) {
                return false;
            }
        }
        return true;
    }

    private List<String> getLevelLabels() {
        List<String> actualLabels = new ArrayList<>();
        for (WebElement label : baseLevelLabels) {
            actualLabels.add(label.getText());
        }
        return actualLabels;
    }

}
