package br.com.ciandt.features.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Api {

	private WebDriver driver;

	public Api(SharedWebDriver sharedWebDriver) {
		this.driver = sharedWebDriver.getDriver();
	}

	@Quando("eu clico em API")
	public void clicoEmApi() {
		driver.findElement(By.xpath("//body/nav[@id='mainNav']/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
	}

	@Entao("o sistema deve abrir a pagina de API com as informações da documentação")
	public void oSistemaDeveAbrirAPaginaDeApi() {
		final WebElement triviaApi = driver.findElement(By.xpath("//body/div/h2"));

		assertThat(triviaApi.isDisplayed()).isTrue();
		assertThat(triviaApi.getText()).isEqualTo("Trivia API");
	}

}
