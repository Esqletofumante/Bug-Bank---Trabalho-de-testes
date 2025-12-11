package Framework.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class AccountData {

    private static final String fileName = "accounts";
    private static final FakersGeneration faker = new FakersGeneration();

    // Gera email e senha e salva 
    public static void generateBaseAccounts() {

        Map<String, String> map = new HashMap<>();

        // Conta 1
        map.put("email1", faker.generateEmail());
        map.put("password1", faker.generatePassword());
        map.put("accountNumber1", ""); 

        // Conta 2
        map.put("email2", faker.generateEmail());
        map.put("password2", faker.generatePassword());
        map.put("accountNumber2", ""); 

        FileOperations.setProperties(fileName, map);
    }

    
    public static void salvarNumeroConta(String numero) {

        Properties prop = FileOperations.getProperties(fileName);

        if (prop.getProperty("accountNumber1") == null || prop.getProperty("accountNumber1").isEmpty()) {

            FileOperations.setProperty(fileName, "accountNumber1", numero);

        } else if (prop.getProperty("accountNumber2") == null || prop.getProperty("accountNumber2").isEmpty()) {

            FileOperations.setProperty(fileName, "accountNumber2", numero);
        }
    }

    // Métodos de leitura
    public static String getEmail1()        { return FileOperations.getProperties(fileName).getProperty("email1"); }
    public static String getPassword1()     { return FileOperations.getProperties(fileName).getProperty("password1"); }
    public static String getAccountNumber1(){ return FileOperations.getProperties(fileName).getProperty("accountNumber1"); }

    public static String getEmail2()        { return FileOperations.getProperties(fileName).getProperty("email2"); }
    public static String getPassword2()     { return FileOperations.getProperties(fileName).getProperty("password2"); }
    public static String getAccountNumber2(){ return FileOperations.getProperties(fileName).getProperty("accountNumber2"); }
}
