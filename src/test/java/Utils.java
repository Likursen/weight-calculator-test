import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (!elements.isEmpty()) {
            return elements.get(0)
                    .isDisplayed();
        }
        return false;
    }
}
