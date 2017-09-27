package steps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import funcionalidades.PaginaInicialFuncionalidade;

public class PaginaInicialStep {
	static PaginaInicialFuncionalidade paginaInicialFuncionalidade = new PaginaInicialFuncionalidade();

	@Dado("^que estou na pagina inicial$")
	public void queEstouNaPaginaInicial() throws Throwable {
		paginaInicialFuncionalidade.goToLogin();
	}

	@Entao("^e exibida o site OLX$")
	public void eExibidaOSiteOLX() throws Throwable {
		paginaInicialFuncionalidade.isPaginaInicial();
	}
}
