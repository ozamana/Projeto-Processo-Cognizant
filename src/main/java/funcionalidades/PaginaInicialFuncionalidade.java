package funcionalidades;

import org.openqa.selenium.WebDriver;

import pageobjects.PaginaInicial;
import util.Navegacao;

public class PaginaInicialFuncionalidade {
	private WebDriver driver;
	private PaginaInicial paginaInicial;
	private String url = "http://www.olx.com.br/";

	public PaginaInicialFuncionalidade() {
		driver = Navegacao.getChromeDriver();
		paginaInicial = new PaginaInicial(driver);
	}

	public void goToLogin() {
		driver.get(url);
	}

	public boolean isPaginaInicial() {
		if (paginaInicial.getUrlIndex().contains("olx"))
			return true;
		return false;
	}
	
	public void selecionarEstado(String estado){
		try{
			paginaInicial.clickSelecionaEstado(paginaInicial.getSelecionaEstado(estado));
		}catch(Exception e){
			System.out.println(e.getMessage());
			driver.quit();			
		}
	}
	
}
