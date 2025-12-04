package baseTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pageObjectModels.BasePage;
import utils.WebDriverFactory;

public class BaseTest {

    //------------ сервер ------------//

    private static final String SERVER = "https://stellarburgers.education-services.ru/";


    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome"); // дефолт
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(SERVER);

        basePage = new BasePage(driver);
        basePage.waitForVisibleStep(basePage.getButtonLogo());

        RestAssured.baseURI = SERVER;

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
