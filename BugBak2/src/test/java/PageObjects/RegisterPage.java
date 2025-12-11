package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCampoEmail() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='email']"));
    }

    public WebElement getCampoNome() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='name']"));
    }

    public WebElement getCampoSenha() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='password']"));
    }

    public WebElement getCampoConfirmacaoSenha() {
        return driver.findElement(By.xpath("//div[@class='style__ContainerFieldInput-sc-s3e9ea-0 gQAEIG input__child']/input[@name='passwordConfirmation']"));
    }

    public WebElement getBotaoToggleAddBalance() {
        return driver.findElement(By.id("toggleAddBalance"));
    }

    public WebElement getBotaoCadastrar() {
        return driver.findElement(By.xpath("//button[text()='Cadastrar']"));
    }
}
