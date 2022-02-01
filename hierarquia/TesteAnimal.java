package hierarquia;

public class TesteAnimal {

	public static void main(String[] args) {
		
		Cavalo c1 = new Cavalo();
		c1.setNome("Pé de pano");
		c1.setIdade(10);
		
		System.out.println("Nome do cavalo: " + c1.getNome());
		System.out.println("Idade do cavalo: " + c1.getIdade()); 
		c1.andar();
		c1.relinchar();
		
		Cachorro co1 = new Cachorro();
		co1.setNome("Pluto");
		co1.setIdade(15);
		
		System.out.println("Nome do Cachorro: " + co1.getNome());
		System.out.println("Idade do Cachorro: " + co1.getIdade()); 
		co1.andar();
		co1.latir();
		
		Preguica p1 = new Preguica();
		p1.setNome("Preguis");
		p1.setIdade(20);
		
		System.out.println("Nome da preguiça: " + p1.getNome());
		System.out.println("Idade da preguiça: " + p1.getIdade()); 
		p1.andar();
		p1.dormir();
		

	}

}
