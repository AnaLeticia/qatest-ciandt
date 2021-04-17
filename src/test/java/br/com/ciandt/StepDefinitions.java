package br.com.ciandt;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

	static {
		WebDriverManager.chromedriver().setup();
	}

	WebDriver driver = new ChromeDriver();

	@Dado("que navego para a página de busca do banco de questões")
	public void navegar() {
		System.out.println("Abrindo o browser na pagina de busca");

		driver.get("https://opentdb.com/");
		driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
		// driver.findElement(By.id("type")).click();
		driver.findElement(By.id("query")).click();
	}

	@E("digito 'Science: Computers' no campo de busca")
	public void digitar() {
		System.out.println("Digitanto no campo de busca");

		driver.findElement(By.id("query")).click();
		driver.findElement(By.id("query")).sendKeys("Science: Computers");
	}

	@Quando("clico no botão de buscar")
	public void clicar() {
		System.out.println("Clicando no botão Buscar");

		driver.findElement(By.cssSelector(".btn")).click();
	}

	@Entao("visualizo uma mensagem de erro com o texto 'No questions found.")
	public void visualizar() {
		System.out.println("Visualizando a mensagem");

		driver.findElement(By.cssSelector(".container:nth-child(3)")).click();
		assertThat(driver.findElement(By.cssSelector(".alert")).getText()).isEqualTo("No questions found.");
		driver.findElement(By.id("page-top")).click();
	}

	// Cenário Busca por Categoria

	@Dado("que navego para a página de busca do banco de categoria")
	public void navegarc() {
		System.out.println("Abrindo o browser na pagina de busca de categoria");
	}

//	@E("digito 'Science: Computers' no campo de busca")
//	public void digitarc() {
//		System.out.println("Digitanto no campo de busca de categoria");
//	}

//	@Quando("clico no botão de buscar")
//	public void clicarc() {
//		System.out.println("Clicando no botão Buscar de categoria");
//	}

	@Entao("verifico uma listagem de questões com {string} itens")
	public void quantidade(String numero) {
		System.out.println("Visualizando listagem com as quantidades de questões");
	}

	@E("verifico o controle de paginação")
	public void paginacao() {
		System.out.println("controle de paginação está ativo");
	}

	// Cenário Busca por Usuário

	@Dado("que navego para a página de busca do banco de usuário")
	public void navegaru() {
		System.out.println("Abrindo o browser na pagina de busca de usuário");
	}

	@E("digito 'DrAwesome' no campo de busca")
	public void digitaru() {
		System.out.println("Digitanto no campo de busca de usuário");
	}

//		@Quando("clico no botão de buscar")
//		public void clicarc() {
//			System.out.println("Clicando no botão Buscar de categoria");
//		}

	@Entao("visualizo uma listagem de questões com {string} itens")
	public void quantidadeu(String numero) {
		System.out.println("Visualizando listagem com as quantidades de questões");
	}

}
