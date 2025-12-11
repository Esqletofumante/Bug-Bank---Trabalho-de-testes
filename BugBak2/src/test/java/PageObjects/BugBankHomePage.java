package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugBankHomePage {

    private WebDriver driver;

    public BugBankHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Captura o número da conta
    public WebElement getTextoNumeroConta() {
        return driver.findElement(By.id("textAccountNumber"));
    }

    // Botão para realizar transferência
    public WebElement getBotaoTransferencia() {
        return driver.findElement(By.id("btn-TRANSFERÊNCIA"));
    }

    // Botão para ver extrato
    public WebElement getBotaoExtrato() {
        return driver.findElement(By.id("btn-EXTRATO"));
    }

    // Botão para sair
    public WebElement getBotaoSair() {
        return driver.findElement(By.id("btnExit"));
    }
}
