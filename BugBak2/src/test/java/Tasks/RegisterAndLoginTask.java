package Tasks;

import org.openqa.selenium.WebDriver;

import Framework.Utils.AccountData;
import Framework.Utils.TirarFoto;
import PageObjects.BugBankHomePage;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Validacao.ValidacaoCadastro;
import Validacao.ValidacaoLogin;

public class RegisterAndLoginTask {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private BugBankHomePage bugBankHomePage;
    private ValidacaoCadastro validacaoCadastro;
    private ValidacaoLogin validacaoLogin;

    public RegisterAndLoginTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        registerPage = new RegisterPage(this.driver);
        bugBankHomePage = new BugBankHomePage(this.driver);
        validacaoCadastro = new ValidacaoCadastro(this.driver);
        validacaoLogin = new ValidacaoLogin(this.driver);
    }

    
    public void cadastrarLogarSalvarContas() {

        // Gera emails e senhas base, sem número de conta
        AccountData.generateBaseAccounts();

        realizarCadastroLoginESalvarConta(
                AccountData.getEmail1(),
                AccountData.getPassword1()
        );

        realizarCadastroLoginESalvarConta(
                AccountData.getEmail2(),
                AccountData.getPassword2()
        );
    }

    
    private void realizarCadastroLoginESalvarConta(String email, String senha) {

        // Acessar tela de registro 
        homePage.getBotaoRegistrar().click();

        //  Preencher o cadastro 
        TirarFoto.stepComFoto(driver, "Realizando Cadastro das duas contas");
        registerPage.getCampoEmail().sendKeys(email);
        registerPage.getCampoNome().sendKeys("Usuário Teste");
        registerPage.getCampoSenha().sendKeys(senha);
        registerPage.getCampoConfirmacaoSenha().sendKeys(senha);

        // toggle (cria conta com saldo)
        registerPage.getBotaoToggleAddBalance().click();

        // botão cadastrar
        registerPage.getBotaoCadastrar().click();

        validacaoCadastro.validarCadastroRealizado();

        // Fecha o modal de confirmação 
        homePage.getBotaoFecharModal().click();

        // Preenche login na tela inicial 
        TirarFoto.stepComFoto(driver, "Realizando o Login");
        homePage.getCampoEmail().sendKeys(email);
        homePage.getCampoSenha().sendKeys(senha);
        homePage.getBotaoAcessar().click(); // aqui Acessar no modal
        validacaoLogin.validarLoginRealizado();

        //  Captura o número da conta 
        String numeroConta = bugBankHomePage.getTextoNumeroConta().getText();

        //  Salva no arquivo correto 
        AccountData.salvarNumeroConta(numeroConta);

        //  Faz logout 
        driver.findElement(org.openqa.selenium.By.id("btnExit")).click();
    }
}
