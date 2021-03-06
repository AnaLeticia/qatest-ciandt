package br.com.ciandt.features.browse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BuscaNoBrowse {

	WebDriver driver;
	
	public BuscaNoBrowse(SharedWebDriver sharedWebDriver) {
		this.driver = sharedWebDriver.getDriver();
		
	}

	// Cenario Busca por Questões inexistentes

	@Dado("que navego para a página de busca do banco de questões")
	public void navegar() {

		driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
		driver.findElement(By.id("query")).click();
	}

	@E("digito 'Science: Computers' no campo de busca")
	public void digitar() {

		driver.findElement(By.id("query")).click();
		driver.findElement(By.id("query")).sendKeys("Science: Computers");
	}

	@Quando("clico no botão de buscar")
	public void clicar() {

		driver.findElement(By.cssSelector(".btn")).click();
	}

	@Entao("visualizo uma mensagem de erro com o texto 'No questions found.")
	public void visualizar() {

		driver.findElement(By.cssSelector(".container:nth-child(3)")).click();
		assertThat(driver.findElement(By.cssSelector(".alert")).getText()).isEqualTo("No questions found.");
		driver.findElement(By.id("page-top")).click();

	
	}

	// Cenário Busca por Categoria

	@Dado("que navego para a página de busca do banco de categoria")
	public void navegarc() {

		driver.manage().window().setSize(new Dimension(1936, 1056));
		driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
		driver.findElement(By.id("type")).click();
		{
			WebElement dropdown = driver.findElement(By.id("type"));
			dropdown.findElement(By.xpath("//option[. = 'Category']")).click();
		}
	}

	@Entao("verifico uma listagem de questões com {int} itens")
	public void quantidade(int quantidadeItensEsperados) {

		int tableRowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println("rowConunt(size)" + tableRowCount);

		assertThat(tableRowCount).isEqualTo(quantidadeItensEsperados);
	}

	@E("verifico o controle de paginação")
	public void paginacao() {

		driver.findElement(By.cssSelector(".pagination")).isDisplayed();

	}

	// Cenário Busca por Usuário

	@Dado("que navego para a página de busca do banco de usuário")
	public void navegaru() {

		driver.manage().window().setSize(new Dimension(1552, 840));
		driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
		driver.findElement(By.id("type")).click();
		{
			WebElement dropdown = driver.findElement(By.id("type"));
			dropdown.findElement(By.xpath("//option[. = 'User']")).click();
		}
		driver.findElement(By.id("query")).click();

	}

	@E("digito 'DrAwesome' no campo de busca")
	public void digitaru() {

		driver.findElement(By.id("query")).sendKeys("DrAwesome");
		driver.findElement(By.cssSelector(".btn")).click();
	}

	@Entao("visualizo uma listagem de questões realizadas pelo usuário")
	public void quantidadeu() {

		driver.findElement(By.cssSelector(".table-bordered")).isDisplayed();

		{
			List<WebElement> elements = driver.findElements(By.cssSelector("td:nth-child(6)"));
			assert (elements.size() > 0);
		}

	}

}
