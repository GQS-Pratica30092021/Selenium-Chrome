/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumchrome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement; 
import java.util.Scanner;

public class seleniumChrome_Google {
    public static void main(String[] args) {
        abrirGoogle();
    }

    private static void abrirGoogle() {
        File file = new File("C:\\Users\\jessica.kenia\\Desktop\\Selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        String pesquisa;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o que deseja pesquisar no Google");
        pesquisa = input.next();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(pesquisa+"\n");
        System.out.println(pesquisa);
        //driver.close();
    }
}

