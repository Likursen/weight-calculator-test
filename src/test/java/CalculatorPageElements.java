import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPageElements {
    private final WebDriver driver;

    public CalculatorPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.xpath("//input[@name='name']"))
                .sendKeys(name);
    }

    public void enterHeight(String height) {
        driver.findElement(By.xpath("//input[@name='height']"))
                .sendKeys(height);
    }

    public void enterWeight(String weight) {
        driver.findElement(By.xpath("//input[@name='weight']"))
                .sendKeys(weight);
    }

    public void chooseGender(Gender gender) {
        if (gender == Gender.MALE) {
            driver.findElement(By.xpath("//input[@name='gender'][@value='m']"))
                    .click();
        }
        if (gender == Gender.FEMALE) {
            driver.findElement(By.xpath("//input[@name='gender'][@value='f']"))
                    .click();
        }
    }

    public void submitForm() {
        driver.findElement(By.xpath("//input[@type='submit'][@value='Рассчитать']"))
                .click();
    }

    public void validateInvalidNameError() {
        Assert.assertEquals("Не указано имя.", driver.findElement(By.xpath("//b[text()='Не указано имя.']"))
                .getText());
    }

    public void validateGenderNotSelectedError() {
        Assert.assertEquals("Не указан пол.", driver.findElement(By.xpath("//b[text()='Не указан пол.']"))
                .getText());
    }

    public void validateSuccessCalculating() {
        Assert.assertEquals("Слишком малая масса тела", driver.findElement(By.xpath("//td[text()='Слишком малая масса тела']"))
                .getText());
    }
}
