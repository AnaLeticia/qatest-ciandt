package br.com.ciandt.features.browse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuscaNoBrowse {

	static {
		WebDriverManager.chromedriver().setup();
	}

	WebDriver driver = new ChromeDriver();
 
   	//Cenario Busca por Questões inexistentes
	
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
		
		driver.close();
	}
	

	// Cenário Busca por Categoria

	@Dado("que navego para a página de busca do banco de categoria")
	public void navegarc() {
		System.out.println("Abrindo o browser na pagina de busca de categoria");
		
		driver.get("https://opentdb.com/");
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
		System.out.println("Visualizando listagem com as quantidades de questões");
		
		int tableRowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();
		System.out.println("rowConunt(size)"+tableRowCount);
		
		assertThat(tableRowCount).isEqualTo(quantidadeItensEsperados);		
	}

	@E("verifico o controle de paginação")
	public void paginacao() {
		System.out.println("controle de paginação está ativo");
		
		driver.findElement(By.cssSelector(".pagination")).isDisplayed();
		
		driver.close();
	}

	// Cenário Busca por Usuário

	@Dado("que navego para a página de busca do banco de usuário")
	public void navegaru() {
		System.out.println("Abrindo o browser na pagina de busca de usuário");
		
		driver.get("https://opentdb.com/");
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
		System.out.println("Digitanto no campo de busca de usuário");
		
		 driver.findElement(By.id("query")).sendKeys("DrAwesome");
		 driver.findElement(By.cssSelector(".btn")).click();
	}


	@Entao("visualizo uma listagem de questões realizadas pelo usuário")
	public void quantidadeu() {
		System.out.println("Visualizando listagem de questões realizadas");
		
		driver.findElement(By.cssSelector(".table-bordered")).isDisplayed();
		
		{
		      List<WebElement> elements = driver.findElements(By.cssSelector("td:nth-child(6)"));
		      assert(elements.size() > 0);
		    }
	
		
		driver.close();
	}

}


