package com.karpuk.clashtrack.ui.core.page;

import com.karpuk.clashtrack.ui.core.model.enums.TownHallLevelsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.karpuk.clashtrack.core.listener.TestListener.logInfo;

public class BaseLayoutPage extends BasePage {

    @FindBy(xpath = "//section[@id='content']/div/span[@class='label label-danger']")
    private WebElement thLevelLabel;

    @FindBy(xpath = "//section[@id='content']/div/span[@class='label label-default']")
    private WebElement baseTypeLabel;

    @FindBy(xpath = "//li[@role='presentation' and not(@class='active')]/a")
    private WebElement backToBasesListButton;

    @FindBy(xpath = "//div[@class='row clan-website-list']//span[@class='label label-danger']")
    private List<WebElement> levelsOfProposedBases;

    public String getTHLevel() {
        return thLevelLabel.getText();
    }

    public String getBaseType() {
        return baseTypeLabel.getText();
    }

    public void backToBasesList() {
        logInfo("Back to list of bases.");
        backToBasesListButton.click();
    }

    public boolean matchLevelsOfProposedBases(TownHallLevelsEnum expectedLevelEnum) {
        List<String> levels = levelsOfProposedBases.stream()
                .map(level -> level.getText())
                .collect(Collectors.toList());
        String expectedLevel = expectedLevelEnum.toString();
        return levels.stream()
                .allMatch(expectedLevel::equalsIgnoreCase);
    }

}
