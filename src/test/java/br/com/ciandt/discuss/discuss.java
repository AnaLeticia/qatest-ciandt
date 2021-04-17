package br.com.ciandt.discuss;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.ciandt.utils.SharedWebDriver;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class discuss {

	private WebDriver driver;

	  public discuss(SharedWebDriver sharedWebDriver) {
	    this.driver = sharedWebDriver.getDriver();
	  }

	  @Quando("eu clico em {string}")
	  public void euClicoEmDiscuss(String buttonName) {
	    final WebElement discussButton = driver.findElement(By.xpath("//body/nav[@id='mainNav']/div[1]/div[1]/ul[1]/li[4]/a[1]"));

	    assertThat(discussButton.getText()).isEqualTo(buttonName);

	    discussButton.click();
	  }

	  @Entao("o sistema deve me redirecionar para a página {string}")
	  public void oSistemaDeveMeRedirecionarParaOutraPagina(String pagina) {
	    assertThat(driver.getCurrentUrl()).isEqualTo(pagina);
	  }
		
	
	
	
}

