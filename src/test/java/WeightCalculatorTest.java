import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeightCalculatorTest {
    private final String URL = "https://svyatoslav.biz/testlab/wt/";
    private final String validName = "Иван";
    private final String validHeight = "180";
    private final String validWeight = "66";
    WebDriver webDriver;
    CalculatorPage calculatorPage;

    @Before
    public void openConnection() {
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        calculatorPage = new CalculatorPage(webDriver);
    }

    @Test
    public void validParametersTest() {
        String resultText = calculatorPage.enterName(validName)
                .enterHeight(validHeight)
                .enterWeight(validWeight)
                .chooseGender(Gender.MALE)
                .submitForm()
                .getResultText();
        Assert.assertEquals("Слишком малая масса тела", resultText);
    }

    @Test
    public void notChooseGenderTest() {
        boolean isElementWithTextDisplayed = calculatorPage.enterName(validName)
                .enterHeight(validHeight)
                .enterWeight(validWeight)
                .submitForm()
                .isElementWithTextDisplayed("Не указан пол.");
        Assert.assertTrue(isElementWithTextDisplayed);
    }

    @Test
    public void spaceInsteadNameTest() {
        boolean isElementWithTextDisplayed = calculatorPage.enterName(" ")
                .enterHeight(validHeight)
                .enterWeight(validWeight)
                .chooseGender(Gender.FEMALE)
                .submitForm()
                .isElementWithTextDisplayed("Не указано имя.");
        Assert.assertTrue(isElementWithTextDisplayed);
    }

    @After
    public void afterTest() {
        webDriver.quit();
    }
}