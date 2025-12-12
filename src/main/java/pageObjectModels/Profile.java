package pageObjectModels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
@NoArgsConstructor
public class Profile extends BasePage {

    public Profile(WebDriver driver) {
        super(driver);
    }

    //заголовок "Профиль"
    private final By headerProfile = By.xpath(".//*[text() = 'Профиль']");
    //кнопка "Выход"
    private final By buttonExit = By.xpath(".//*[text() = 'Выход']");
}
