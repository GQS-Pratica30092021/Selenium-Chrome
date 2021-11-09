package seleniumchrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class SeleniumChrome {

    public static void main(String[] args) {
        abrirChrome();
    }

    private static void abrirChrome() {
        File file = new File("C:\\Users\\jessica.kenia\\Desktop\\Selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("http://devmedia.com.br");
        String i = driver.getCurrentUrl();
        System.out.println(i);
        driver.close();
    }
}


