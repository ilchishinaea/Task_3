package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    /**
     * Создаёт локальный WebDriver для указанного браузера.
     * @param browser Имя браузера: "chrome" или "yandex"
     * @return WebDriver
     */
    public static WebDriver createDriver(String browser) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        switch (browser.toLowerCase()) {
            case "chrome":
                break;
            case "yandex":
                options.setBinary("C:\\Users\\Katya\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                break;
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser);
        }
        return new ChromeDriver(options);
    }
}
