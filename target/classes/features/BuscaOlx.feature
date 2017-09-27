#language: pt
#Version: 1.0
#Encoding: iso-8859-1
Funcionalidade: Buscar conteudo

  Contexto: 
    Dado que estou na pagina inicial
    E selecionar estado da busca
      | Estado |
      | SP     |

  @ID1
  Cenario: Realizar uma pesquisa no site da OLX e imprimir somente titulo e valor dos cinco primeiros resultados
    Quando realizar busca de um produto
      | Busca |
      | casa  |
    Entao e apresentado resultado da busca do "5" resultado

  @ID2
  Cenario: Realizar uma pesquisa no site da OLX que contenha paginacao, tirar um print do primeiro anuncio da segunda pagina
    Quando realizar busca de um produto
      | Busca |
      | casa  |
    E realizar paginacao
      | Pagina |
      |      2 |
    Entao e apresentado resultado da busca do "1" resultado
