package br.com.ciandt.features.questions;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AdicionandoQuestao {
	WebDriver driver;

	public AdicionandoQuestao(SharedWebDriver sharedWebDriver) {
		this.driver = sharedWebDriver.getDriver();
	}

	@Quando("eu clico em ADD NEW QUESTIONS")
	public void euClicoEmAddNewQuestion() {

		WebElement addNewQuestionButton = driver.findElement(By.cssSelector(".btn:nth-child(5)"));

		assertThat(addNewQuestionButton.getText()).isEqualTo("ADD NEW QUESTIONS");

		addNewQuestionButton.click();
	}

	@Entao("o sistema deve mostrar um alerta de erro")
	public void oSistemaDeveMostrarUmAlertaDeErro() {
		final WebElement alertDanger = driver.findElement(By.className("alert-danger"));

		assertThat(alertDanger.isDisplayed()).isTrue();
		assertThat(alertDanger.getText()).isEqualTo("ERROR! You must be logged in to submit a trivia question.");


	}
}