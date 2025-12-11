package TestCases;

import Framework.TestBase;
import Tasks.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class FazerTesteLogin extends TestBase {

    private final WebDriver driver = getDriverManager();

    RegisterAndLoginTask login = new RegisterAndLoginTask(driver);
    TransferTask transfer = new TransferTask(driver);
    BugBankExtratoTask extrato = new BugBankExtratoTask(driver);

    @Test
    public void rodar(){

        try {

            login.cadastrarLogarSalvarContas();
            transfer.realizarTransferencia();
            extrato.acessarExtratoConta2();

        }catch (Exception e){
            e.getMessage();

        }

    }
}
