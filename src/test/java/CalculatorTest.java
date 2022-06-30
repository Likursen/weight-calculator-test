import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {
    private final static String URL = "https://svyatoslav.biz/testlab/wt/";

    private final String validName = "Иван";
    private final String validHeight = "180";
    private final String validWeight = "66";
    WebDriver webDriver;
    CalculatorPageElements calculatorPageElements;

    @Before
    public void openConnection() {
        webDriver = new ChromeDriver();
        calculatorPageElements = new CalculatorPageElements(webDriver);
        webDriver.get(URL);
    }

    @Test
    public void validParametersTest() {
        calculatorPageElements.enterName(validName);
        calculatorPageElements.enterHeight(validHeight);
        calculatorPageElements.enterWeight(validWeight);
        calculatorPageElements.chooseGender(Gender.MALE);
        calculatorPageElements.submitForm();
        calculatorPageElements.validateSuccessCalculating();
        webDriver.quit();
    }

    @Test
    public void notChooseGenderTest() {
        calculatorPageElements.enterName(validName);
        calculatorPageElements.enterHeight(validHeight);
        calculatorPageElements.enterWeight(validWeight);
        calculatorPageElements.submitForm();
        calculatorPageElements.validateGenderNotSelectedError();
        webDriver.quit();
    }

    @Test
    public void spaceInsteadNameTest() {
        calculatorPageElements.enterName(" ");
        calculatorPageElements.enterHeight(validHeight);
        calculatorPageElements.enterWeight(validWeight);
        calculatorPageElements.chooseGender(Gender.MALE);
        calculatorPageElements.submitForm();
        calculatorPageElements.validateInvalidNameError();
    }

    @After
    public void afterTest() {
        webDriver.quit();
    }
}