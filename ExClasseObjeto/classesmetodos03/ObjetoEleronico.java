package classesmetodos03;

public class ObjetoEleronico {

	public static void main(String[] args) {
		
		ProdutoEletronico pe1 = new ProdutoEletronico();
		
		pe1.tipo = "Celular";
		pe1.marca = "Samsung";
		pe1.modelo = "Galaxy S21 + ";
		pe1.cor = "Preto";
		pe1.valor = 5000.50;
		
		System.out.println("Tipo de eletronico: " + pe1.tipo);
		System.out.println("Marca do eletronico: " + pe1.marca);
		System.out.println("Modelo do eletronico: " + pe1.modelo);
		System.out.println("Cor do eletronico: " + pe1.cor);
		System.out.println("Valor do eletronico: " + pe1.valor);
		pe1.pesquisar();

	}

}
