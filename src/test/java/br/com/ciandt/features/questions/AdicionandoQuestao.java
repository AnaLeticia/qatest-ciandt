package br.com.ciandt.features.questions;

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

	public class AdicionandoQuestao {
		static {
			
			WebDriverManager.chromedriver().setup();
		}

		WebDriver driver = new ChromeDriver();

	
	@Quando("eu clico em ADD NEW QUESTIONS")
	public void euClicoEmAddNewQuestion() {
		
		driver.get("https://opentdb.com/");
		WebElement addNewQuestionButton = driver.findElement(By.cssSelector(".btn:nth-child(5)"));

		assertThat(addNewQuestionButton.getText()).isEqualTo("ADD NEW QUESTIONS");

		addNewQuestionButton.click();
	}

		@Entao("o sistema deve mostrar um alerta de erro")
		public void oSistemaDeveMostrarUmAlertaDeErro() {
		  final WebElement alertDanger = driver.findElement(By.className("alert-danger"));
		
		  assertThat(alertDanger.isDisplayed()).isTrue();
		  assertThat(alertDanger.getText()).isEqualTo("ERROR! You must be logged in to submit a trivia question.");
		  
		  driver.close();
		  
		}
}