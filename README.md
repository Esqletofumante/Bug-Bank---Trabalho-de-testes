# AutomaçãoWebFundatec TI 27

## Descrição
O **AutomaçãoWebFundatec** é um projeto de automação desenvolvido para treinar processos de teste utilizando o site BugBank como referência.

O fluxo automatizado executa todas as etapas essenciais de um cenário real de uso do sistema:

1. Acessa o site via URL fornecida.  
2. Cria uma nova conta com dados gerados aleatoriamente.  
3. Salva o código da primeira conta.  
4. Faz logout.  
5. Cria uma segunda conta.  
6. Realiza uma transferência da segunda conta para a primeira.  
7. Retorna para a primeira conta.  
8. Valida se a transferência foi concluída.  
9. Armazena screenshots durante o processo.

Todo o ciclo é realizado automaticamente, garantindo repetibilidade e padronização do teste.

---

## Funcionalidades

- Acessar o site via URL configurada no projeto.  
- Identificar, interagir e validar elementos da interface web.  
- Preencher formulários com informações geradas pelo próprio código.  
- Criar automaticamente duas contas no BugBank.  
- Realizar transferência de saldo entre contas.  
- Validar o recebimento da transferência.  
- Capturar screenshots das etapas relevantes.  
- Estrutura organizada em métodos bem definidos para facilitar manutenção.

---

## Tecnologias Utilizadas

- Java  
- Selenium WebDriver  
- Maven  
- IntelliJ IDEA Community Edition  
- Allure (para relatórios e visualização de screenshots)

Dependências do Projeto
- Selenium WebDriver
- WebDriverManager
- JUnit 5
- JUnit Platform Suite
- Java Faker
- Allure Report
- Maven

As informações utilizadas são geradas dinamicamente e descartadas ao final da execução.

---

## Como Executar o Projeto

1. Acesse o repositório no GitHub.  
2. Baixe o projeto em formato ZIP.  
3. Extraia e abra o projeto em uma IDE (IntelliJ recomendado).  
4. Aguarde o Maven baixar as dependências necessárias.  
5. Navegue até o método principal.  
6. Execute o teste clicando em "Run".

---

## Requisitos

- IDE Java instalada.  
- Java configurado no ambiente.  
- Maven funcionando corretamente.  
- Allure instalado para leitura dos relatórios.

---

## Estrutura do Projeto
src
├── main
│   ├── java
│   │   └── Framework
│   │       ├── Browser
│   │       │   ├── DriverManager.java
│   │       │   ├── TypeBrowser.java
│   │       │   └── Waits.java
│   │       └── Utils
│   │           ├── AccountData.java
│   │           ├── FakersGeneration.java
│   │           ├── FileOperations.java
│   │           ├── TirarFoto.java
│   │           └── TestBase.java
│   └── resources
│       └── Properties
│           ├── accounts.properties
│           └── url.properties
│
└── test
    └── java
        ├── PageObjects
        │   ├── BugBankHomePage.java
        │   ├── BugBankTransferPage.java
        │   ├── HomePage.java
        │   └── RegisterPage.java
        │
        ├── Tasks
        │   ├── BugBankExtratoTask.java
        │   ├── RegisterAndLoginTask.java
        │   └── TransferTask.java
        │
        ├── TestCases
        │   └── FazerTesteLogin.java
        │
        ├── TestSuites
        │   └── TestaTudo.java
        │
        └── Validacao
            ├── ValidacaoCadastro.java
            ├── ValidacaoLogin.java
            └── ValidacaoTransferencia.java

---

## Autores

Antoni Prestes
Stephanie Cruz
Thomas Albeche


---

## Licença
Este projeto é destinado a fins educacionais e demonstrativos.
