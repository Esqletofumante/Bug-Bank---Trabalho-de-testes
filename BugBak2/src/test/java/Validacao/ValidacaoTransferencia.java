package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import Framework.Utils.TirarFoto;
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
        TirarFoto.stepComFoto(driver, "Validando mensagem de transferência");

        String mensagem = transferPage.getMensagemModalTransferencia().getText();

        Assertions.assertTrue(
                mensagem.contains("sucesso") || mensagem.contains("Transferência realizada"),
                "ERRO: O modal não confirmou a transferência!"
        );

        TirarFoto.stepComFoto(driver, "Transferência validada com sucesso");

    } catch (AssertionError e) {

        // Screenshot no momento do erro
        TirarFoto.tirarFoto(driver, "Erro na validação de transferência");

        // Relançar para marcar o teste as failed
        throw e;

    } catch (Exception e) {
        TirarFoto.tirarFoto(driver, "Erro inesperado durante validação");
        throw e;
    }
}

}
