package br.unibh.tp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumUnitTest {

    private final String WEBDRIVER_PATH = "D:\\selenium\\95\\msedgedriver.exe";
    private final String WEBSITE_URL = "https://www.sejaamakha.com.br/";

    void ValidateField(String fieldName, String value, String assertValue) {
        WebDriver driver = new EdgeDriver();
        driver.get(WEBSITE_URL);
        driver.findElement(By.name(fieldName)).sendKeys(value);
        driver.findElement(By.name(fieldName)).sendKeys(Keys.TAB);
        assertEquals(driver.findElement(By.className("invalid-feedback")).getText(), assertValue);
        driver.close();
    }

    @BeforeEach
    void Setup() {
        File file = new File(WEBDRIVER_PATH);
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
    }

    @Test
    void CheckFederalIdFromForm() {
        ValidateField("cpfCnpj", "98765434565", "CPF/CNPJ Inválido");
    }

    @Test
    void CheckTelephoneNumber() {
        ValidateField("phone.number", "31", "Digite seu telefone com DDD");
    }

    @Test
    void CheckEmailAddress() {
        ValidateField("email", "email@invalido", "E-mail inválido");
    }

}
