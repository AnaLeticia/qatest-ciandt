package br.com.ciandt.features.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Registrar {

	private WebDriver driver;

	public Registrar(SharedWebDriver sharedWebDriver) {
		this.driver = sharedWebDriver.getDriver();
	}

	@Quando("clico em Register")
	public void clicoEmRegister() {
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	}

	@Entao("o sistema deve mostrar um formulario de cadastro")
	public void oSistemaDeveMostrarUmFormularioDeCadastro() {
		final WebElement formRegister = driver.findElement(By.className("form-register"));

		assertThat(formRegister.isDisplayed()).isTrue();
	}
}
