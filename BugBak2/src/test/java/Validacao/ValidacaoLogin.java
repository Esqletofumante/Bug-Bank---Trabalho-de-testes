package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import Framework.Utils.TirarFoto;
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
            TirarFoto.stepComFoto(driver, "Validando login do usuário");

            String numeroConta = bugBankHomePage.getTextoNumeroConta().getText();

            Assertions.assertTrue(
                numeroConta != null && !numeroConta.isEmpty(),
                "ERRO: Login falhou — número da conta não apareceu!"
            );

            TirarFoto.stepComFoto(driver, "Login validado com sucesso");

        } catch (AssertionError e) {
            TirarFoto.tirarFoto(driver, "Erro: login não foi validado corretamente");
            throw e;

        } catch (Exception e) {
            TirarFoto.tirarFoto(driver, "Erro inesperado durante validação de login");
            throw e;
        }
    }
}
