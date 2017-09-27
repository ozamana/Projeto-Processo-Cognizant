package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaInicial extends Page {

	public PaginaInicial(WebDriver driver) {
		super(driver);
	}

	public String getUrlIndex() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getSelecionaEstado(String estado) {
		return getElement(".//li[a = '" + estado + "']//a");
	}

	public void clickSelecionaEstado(WebElement elemento) {
		elemento.click();
	}
}
