package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import PageObjects.BugBankTransferPage;

public class ValidacaoTransferencia {

    private WebDriver driver;
    private BugBankTransferPage transferPage;

    public ValidacaoTransferencia(WebDriver driver){
        this.driver = driver;
        transferPage = new BugBankTransferPage(driver);
    }

    public void validarTransferenciaRealizada() {

        try {
            String mensagem = transferPage.getMensagemModalTransferencia().getText();

            Assertions.assertTrue(
                mensagem.contains("sucesso") || mensagem.contains("Transferência realizada"),
                "ERRO: O modal não confirmou a transferência!"
            );
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
