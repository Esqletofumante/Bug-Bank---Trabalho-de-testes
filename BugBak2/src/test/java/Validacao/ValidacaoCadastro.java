package Validacao;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

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
            String mensagem = homePage.getMensagemModalCadastro().getText();
            Assertions.assertTrue(
                mensagem.contains("foi criado com sucesso"),
                "ERRO: A mensagem do modal não confirma o cadastro!"
            );
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
