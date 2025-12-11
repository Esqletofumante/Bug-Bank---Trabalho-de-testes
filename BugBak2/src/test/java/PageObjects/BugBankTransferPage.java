package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugBankTransferPage {

    private WebDriver driver;

    public BugBankTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    // Campo número da conta
    public WebElement getCampoNumeroConta() {
        return driver.findElement(By.xpath("//input[@name='accountNumber']"));
    }

    // Campo dígito
    public WebElement getCampoDigito() {
        return driver.findElement(By.xpath("//input[@name='digit']"));
    }

    // Campo valor da transferência
    public WebElement getCampoValor() {
        return driver.findElement(By.xpath("//input[@name='transferValue']"));
    }

    // Campo descrição
    public WebElement getCampoDescricao() {
        return driver.findElement(By.xpath("//input[@name='description']"));
    }

    // Botão "Transferir agora"
    public WebElement getBotaoTransferirAgora() {
        return driver.findElement(By.xpath("//button[text()='Transferir agora']"));
    }

    public WebElement getBotaoFecharModal() {
        return driver.findElement(By.id("btnCloseModal"));
    }

    // Botão para sair
    public WebElement getBotaoSair() {
        return driver.findElement(By.id("btnExit"));
    }

    public WebElement getMensagemModalTransferencia() {
    return driver.findElement(By.id("modalText"));
}

}
