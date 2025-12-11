package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Browser.Waits;
import Framework.Utils.AccountData;
import Framework.Utils.TirarFoto;
import PageObjects.BugBankHomePage;
import PageObjects.HomePage;
import Validacao.ValidacaoLogin;

public class BugBankExtratoTask {

    private WebDriver driver;
    private HomePage homePage;
    private BugBankHomePage bugBankHomePage;
    private Waits waits;
    private ValidacaoLogin validacaoLogin;
    

    public BugBankExtratoTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        bugBankHomePage = new BugBankHomePage(this.driver);
        validacaoLogin = new ValidacaoLogin(this.driver);
        waits = new Waits(this.driver);
        
    }

    public void acessarExtratoConta2() throws InterruptedException {

        // Dados da segunda conta
        String email = AccountData.getEmail2();
        String password = AccountData.getPassword2();

        // Login
        TirarFoto.stepComFoto(driver, "Realizando Login da conta 2");
        waits.loadElement(homePage.getCampoEmail());
        homePage.getCampoEmail().sendKeys(email);

        waits.loadElement(homePage.getCampoSenha());
        homePage.getCampoSenha().sendKeys(password);

        homePage.getBotaoAcessar().click();  // Botão "Acessar"
        validacaoLogin.validarLoginRealizado();

        // Espera o carregamento da página da conta
        waits.loadElement(bugBankHomePage.getBotaoExtrato());

        // Abrir o extrato
        TirarFoto.stepComFoto(driver, "Realizando a verificação do extrato");
        bugBankHomePage.getBotaoExtrato().click();

        
        Thread.sleep(3000);
    }
}
