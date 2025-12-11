package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import Framework.Utils.TirarFoto;
import PageObjects.HomePage;

public class ValidacaoCadastro {

    private WebDriver driver;
    private HomePage homePage;

    public ValidacaoCadastro(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void validarCadastroRealizado() {

        try {
            TirarFoto.stepComFoto(driver, "Validando criação de cadastro");

            String mensagem = homePage.getMensagemModalCadastro().getText();

            Assertions.assertTrue(
                mensagem.contains("foi criado com sucesso"),
                "ERRO: A mensagem do modal não confirma o cadastro!"
            );

            TirarFoto.stepComFoto(driver, "Cadastro validado com sucesso");

        } catch (AssertionError e) {
            TirarFoto.tirarFoto(driver, "Erro: cadastro não confirmado no modal");
            throw e;

        } catch (Exception e) {
            TirarFoto.tirarFoto(driver, "Erro inesperado durante validação de cadastro");
            throw e;
        }
    }
}
