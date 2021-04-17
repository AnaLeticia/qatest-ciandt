package br.com.ciandt.features.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


 public class Login {

	 protected WebDriver driver;

	  public Login(SharedWebDriver sharedWebDriver) {
	    this.driver = sharedWebDriver.getDriver();
	  }

	  @Before("@Login")
	  public void setUp() {
	    // clica no botao de login da pagina inicial
	    driver.findElement(By.xpath("//body/nav[@id='mainNav']/div[1]/div[1]/ul[1]/li[5]/a[1]")).click();
	  }

	  @Dado("que eu preencho o login com credenciais invalidas")
	  public void queEuPreenchoOLoginComCredenciaisInvalidas() {
	    final WebElement usernameInput = driver.findElement(By.id("username"));
	    usernameInput.sendKeys("esseusuariotembaixissimaschancesdeexistir@2021");

	    final WebElement passwordInput = driver.findElement(By.id("password"));
	    passwordInput.sendKeys("hellodarkenessmyoldfriend");
	  }

	  @Quando("eu clico em Sign In")
	  public void euClicoEmSignIn() {
	    driver.findElement(By.cssSelector(".btn-primary[type=\"submit\"")).click();
	  }

	  @Entao("o sistema deve mostrar um alerta de login invalido")
	  public void oSistemaDeveMostrarUmAlertaDeLoginInvalido() {
	    final WebElement alertDanger = driver.findElement(By.className("alert-danger"));

	    assertThat(alertDanger.isDisplayed()).isTrue();
	    assertThat(alertDanger.getText()).isEqualTo("ERROR! Logging In Failed.");
	  }
	 
}
