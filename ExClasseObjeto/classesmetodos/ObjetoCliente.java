package classesmetodos;

public class ObjetoCliente {

	public static void main(String[] args) {
		
			Cliente c1 = new Cliente();
			
			c1.nome = "Leandro";
			c1.idade = 25;
			
			c1.apresentar();
			System.out.println(c1.nome);
			System.out.println(c1.idade);
	}

}
