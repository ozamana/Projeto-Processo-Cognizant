package steps;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import funcionalidades.BuscandoProdutoFuncionalidade;
import funcionalidades.PaginaInicialFuncionalidade;

public class BuscandoProdutosStep {
	PaginaInicialFuncionalidade paginaInicialStep = new PaginaInicialFuncionalidade();
	BuscandoProdutoFuncionalidade buscandoProduto = new BuscandoProdutoFuncionalidade();

	@Dado("^selecionar estado da busca$")
	public void selecionarEstadoDaBusca(DataTable credenciais) throws Throwable {
		for (Map<String, String> map : credenciais.asMaps(String.class, String.class)) {
			paginaInicialStep.selecionarEstado(map.get("Estado"));
		}
	}

	@Quando("^realizar busca de um produto$")
	public void realizarBuscaDeUmProduto(DataTable credenciais) throws Throwable {
		for (Map<String, String> map : credenciais.asMaps(String.class, String.class)) {
			buscandoProduto.realizaBusca(map.get("Busca"));
		}
	}

	@Entao("^e apresentado resultado da busca do \"([^\"]*)\" resultado$")
	public void eApresentadoResultadoDaBusca(int quantidade) throws Throwable {
		buscandoProduto.imprimindoResultadosGrid(quantidade);
	}

	@Quando("^realizar paginacao$")
	public void realizarPaginacao(DataTable credenciais) throws Throwable {
		for (Map<String, String> map : credenciais.asMaps(String.class, String.class)) {
			buscandoProduto.realizaPaginacao(map.get("Pagina"));
		}
	}
}
