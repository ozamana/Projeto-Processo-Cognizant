package funcionalidades;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.BuscandoProdutoPage;
import util.Navegacao;

public class BuscandoProdutoFuncionalidade {
	WebDriver driver;
	BuscandoProdutoPage buscandoProdutoPage;

	public BuscandoProdutoFuncionalidade() {
		driver = Navegacao.getChromeDriver();
		buscandoProdutoPage = new BuscandoProdutoPage(driver);
	}

	public void realizaBusca(String produto) {
		try {
			buscandoProdutoPage.setCampoBuscar(produto);
			buscandoProdutoPage.clickBotaoBuscar();
			driver.wait(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void imprimindoResultadosGrid(int numeroLinha) {
		List<WebElement> listaElementos = buscandoProdutoPage.getGridResultadosBusca();
		int cont = 1;
		System.out.println("**********Resultados da grid**********\n");
		for (WebElement webElement : listaElementos) {
			System.out.println("Titulo: " + buscandoProdutoPage.getTituloProduto(webElement).getText() + "\n");

			WebElement precoProduto = buscandoProdutoPage.getValorProduto(webElement);
			if (precoProduto != null) {
				System.out.println("O Valor do produto é : " + precoProduto.getAttribute("innerText") + "\n");
			}
			
			if (cont == numeroLinha) {
				break;
			}
			cont++;
		}
	}

	public void realizaPaginacao(String pag) {
		try {
			buscandoProdutoPage.clickPaginacao(pag);
			driver.wait(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}

}
