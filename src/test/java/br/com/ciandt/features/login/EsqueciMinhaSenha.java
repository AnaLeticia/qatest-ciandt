package br.com.ciandt.features.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class EsqueciMinhaSenha {

	private WebDriver driver;

	public EsqueciMinhaSenha(SharedWebDriver sharedWebDriver) {
		this.driver = sharedWebDriver.getDriver();
	}

	@Quando("clico em Forgot password")
	public void clicoEmForgotPassword() {
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password')]")).click();
	}

	@Entao("o sistema deve abrir um campo de email")
	public void oSistemaDeveAbrirUmCampoDeEmail() {
		final WebElement email = driver.findElement(By.id("email"));

		assertThat(email.isDisplayed()).isTrue();
	}

	@E("exibir o captcha")
	public void exibirOCaptcha() throws InterruptedException {
		final WebElement captcha = driver.findElement(By.className("g-recaptcha"));

		assertThat(captcha.isDisplayed()).isTrue();
	}

	@E("exibir o botao Send password reset email")
	public void exibirOBotaoSendPasswordResetEmail() {
		final WebElement buttonSubmit = driver.findElement(By.cssSelector(".btn-primary[type=\"submit\""));

		assertThat(buttonSubmit.isDisplayed()).isTrue();
		assertThat(buttonSubmit.getText()).isEqualTo("SEND PASSWORD RESET EMAIL");
	}

}
