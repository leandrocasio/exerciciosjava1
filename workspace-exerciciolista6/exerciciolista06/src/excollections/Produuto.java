package excollections;
/*3- Crie uma um programa para trabalhar com estoque de uma loja, o programa deverá
trabalhar com Collection do tipo List do Java para manipular os dados desse estoque, o
programa deverá atender as seguintes funcionalidades:
Armazenar dados da List
Remover dados da list;
Atualizar dados da list.
Apresentar todos os dados da list.*/

public class Produuto {
	
	private String Produto;
	private Integer Estoque;
	
	public Produuto(String Produto, Integer Estoque) {
		
	}

	public Produuto() {
		super();
		this.Produto = Produto;
		this.Estoque = Estoque;
	}

	public String getProduto() {
		return Produto;
	}

	public void setProduto(String produto) {
		Produto = produto;
	}

	public Integer getEstoque() {
		return Estoque;
	}

	public void setEstoque(Integer estoque) {
		Estoque = estoque;
	}

	@Override
	public String toString() {
		return "Produuto [Produto=" + Produto + "| Estoque=" + Estoque + "]";
	}


}