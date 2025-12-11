package Framework.Utils;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class TirarFoto {

    public static void step(String message) {
        Allure.step(message);
    }

    public static void tirarFoto(WebDriver driver, String name) {
        try {
            byte[] foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new String(foto, StandardCharsets.ISO_8859_1), "png");
        } catch (Exception e) {
            System.out.println("Erro ao tirar screenshot: " + e.getMessage());
        }
    }

    public static void stepComFoto(WebDriver driver, String message) {
        step(message);
        tirarFoto(driver, message);
    }
}
