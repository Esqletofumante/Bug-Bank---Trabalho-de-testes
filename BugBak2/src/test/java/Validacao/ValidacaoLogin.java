package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import PageObjects.BugBankHomePage;

public class ValidacaoLogin {

    private WebDriver driver;
    private BugBankHomePage bugBankHomePage;

    public ValidacaoLogin(WebDriver driver) {
        this.driver = driver;
        bugBankHomePage = new BugBankHomePage(driver);
    }

    public void validarLoginRealizado() {

        try {
            String numeroConta = bugBankHomePage.getTextoNumeroConta().getText();

            Assertions.assertTrue(
                numeroConta != null && !numeroConta.isEmpty(),
                "ERRO: Login falhou — número da conta não apareceu!"
            );
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
