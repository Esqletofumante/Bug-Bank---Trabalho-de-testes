package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.AccountData;
import PageObjects.BugBankHomePage;
import PageObjects.BugBankTransferPage;
import PageObjects.HomePage;
import Validacao.ValidacaoLogin;
import Validacao.ValidacaoTransferencia;

public class TransferTask {

    private WebDriver driver;
    private HomePage homePage;
    private BugBankHomePage bugBankHomePage;
    private BugBankTransferPage transferPage;
    private ValidacaoLogin validacaoLogin;
    private ValidacaoTransferencia validacaoTransferencia;

    public TransferTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        bugBankHomePage = new BugBankHomePage(this.driver);
        transferPage = new BugBankTransferPage(this.driver);
        validacaoLogin = new ValidacaoLogin(this.driver);
        validacaoTransferencia = new ValidacaoTransferencia(this.driver);
    }


    public void realizarTransferencia() {

        
        // Login com conta 1
        
        homePage.getCampoEmail().sendKeys(AccountData.getEmail1());
        homePage.getCampoSenha().sendKeys(AccountData.getPassword1());
        homePage.getBotaoAcessar().click(); // botão "Acessar"

        
        // Acessa tela de transferência
        
        bugBankHomePage.getBotaoTransferencia().click();
        validacaoLogin.validarLoginRealizado();

        
        // Pegar número e dígito da conta 2
        
        String conta2 = AccountData.getAccountNumber2();  // Ex: 12345-6

        String numeroConta = conta2.split("-")[0];  // 12345
        String digitoConta = conta2.split("-")[1];  // 6

        
        // Preencher dados da transferência
        
        transferPage.getCampoNumeroConta().sendKeys(numeroConta);
        transferPage.getCampoDigito().sendKeys(digitoConta);
        transferPage.getCampoValor().sendKeys("100");  // valor fixo ou variável
        transferPage.getCampoDescricao().sendKeys("Transferência automática");

        transferPage.getBotaoTransferirAgora().click();
        validacaoTransferencia.validarTransferenciaRealizada();
        
        // Fechar modal de sucesso
        
        transferPage.getBotaoFecharModal().click();
        

        
        // Logout
        
        transferPage.getBotaoSair().click();
    }
}
