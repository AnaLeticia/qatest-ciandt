## Teste de Automação para QA - CI&T

### Automação dos testes funcionais utilizando seleniumWebDriver + jUnit + cucumber +AssertJ

 * O Processo seguiu as segintes fases:
   >> Criação da automação de testes funcionais com base no cénario passado;
   >> 
   >> Criação dos cenários e automação da funcionaidade testada inicialmente;
   >> 
   >> Criação de alguns cenários que identifiquei importantes;
      
 * Critérios para escolha dos cenários: *Fluxo principal do site:* 

### Cenários
- [x] Buscas no Browse
- [x] Add New Questions
- [x] Opção: "Discuss"
- [x]  Opção: "API"
- [x]  Opção: "Login"

### Relatório dos Testes
 Para ver o relatorio no browser, abrir o arquivo: target/cucumber-report-html/cucumber-html-reports/feature-overview.html
 
### Para Execução dos Testes:
É preciso ter instalado na maquina: 
* Java 8
* Jdk 8
* Maven 3 
* Chrome 
   >> Ir até a raiz do projeto,via linha de comando digitar: "maven clean verify"
