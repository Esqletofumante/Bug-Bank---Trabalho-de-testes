package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBotaoRegistrar() {
        return driver.findElement(By.xpath("//button[text()='Registrar']"));
    }

    public WebElement getBotaoAcessar() {
        return driver.findElement(By.xpath("//button[text()='Acessar']"));
    }

    public WebElement getCampoEmail() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='email']"));
    }

    public WebElement getCampoSenha() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='password']"));
    }

    public WebElement getBotaoFecharModal() {
        return driver.findElement(By.id("btnCloseModal"));
    }
    public WebElement getMensagemModalCadastro() {
    return driver.findElement(By.id("modalText"));
}

}
