import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage {
    private final WebDriver driver;
    private final By nameField = By.xpath("//input[@name='name']");
    private final By heightField = By.xpath("//input[@name='height']");
    private final By weightField = By.xpath("//input[@name='weight']");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By resultText = By.xpath("(//td[@valign='top'])[2]");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPage enterName(String name) {
        enterStringValue(nameField, name);
        return this;
    }

    public CalculatorPage enterHeight(String height) {
        enterStringValue(heightField, height);
        return this;
    }

    public CalculatorPage enterWeight(String weight) {
        enterStringValue(weightField, weight);
        return this;
    }

    public CalculatorPage chooseGender(Gender gender) {
        String xpathValue = gender.getXpathValue();
        String genderXpathPattern = "//input[@name='gender' and @value='%s']";
        String xpath = String.format(genderXpathPattern, xpathValue);
        driver.findElement(By.xpath(xpath))
                .click();
        return this;
    }

    public CalculatorPage submitForm() {
        driver.findElement(submitButton)
                .click();
        return this;
    }

    public String getResultText() {
        return driver.findElement(resultText)
                .getText();
    }

    public boolean isElementWithTextDisplayed(String text) {
        String xpathPattern = "//*[text()='%s']";
        String xpath = String.format(xpathPattern, text);
        return Utils.isElementDisplayed(driver, By.xpath(xpath));
    }

    private void enterStringValue(By locator, String text) {
        driver.findElement(locator)
                .sendKeys(text);
    }
}