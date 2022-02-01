package classesmetodos02;

public class ObjetoAviao {

	public static void main(String[] args) {
		
		Aviao av1 = new Aviao();
		
		av1.modelo = "Airbus A 380";
		av1.passageiros = 800;
		av1.preco = 445.6;
		
		av1.apresentar();
		System.out.println("Modelo: " + av1.modelo);
		System.out.println("Numero de passageiros: " + av1.passageiros);
		System.out.println("Preço do avião em U$D: " + av1.preco);
		

	}

}
