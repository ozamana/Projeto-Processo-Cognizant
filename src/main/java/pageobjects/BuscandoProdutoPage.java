package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscandoProdutoPage extends Page {

	public BuscandoProdutoPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getCampoBuscar() {
		return getElement(".//input[contains(@class, 'placeholder')]");
	}

	public void setCampoBuscar(String produto) {
		getCampoBuscar().sendKeys(produto);
	}

	public WebElement getBotaoBuscar() {
		return getElement(".//input[contains(@class, 'btn-search')]");
	}

	public void clickBotaoBuscar() {
		getBotaoBuscar().click();
	}

	public List<WebElement> getGridResultadosBusca() {
		List<WebElement> listaElementos;
		return listaElementos = driver
				.findElements(By.xpath(".//div[contains(@class, 'section_OLXad-list')]//ul/li/a"));
	}

	public WebElement getTituloProduto(WebElement elemento) {
		WebElement tituloProduto = elemento.findElement(By.xpath("div[2]//h3"));
		return tituloProduto;
	}

	public WebElement getValorProduto(WebElement elemento) {
		WebElement elementoValorProduto = null;
		try {
			elementoValorProduto = elemento.findElement(By.xpath("div[3]//p"));
		} catch (NoSuchElementException e) {
			elementoValorProduto = null;
			System.err.println("Anúncio sem valor.");

		}
		return elementoValorProduto;
	}

	public WebElement getPaginacao(String pag) {
		return getElement(".//li[@class = 'item number']//a[@title = '" + pag + "']");
	}

	public void clickPaginacao(String pag) {
		getPaginacao(pag).click();
	}
}
