package classesmetodos05;

public class ObjetoPatinete {

	public static void main(String[] args) {
		
		Patinete pat1 = new Patinete();
		
		pat1.setMarca("Scooter");
		pat1.setModelo("Unitoys");
		pat1.setCor("Rosa");
		pat1.setRodas(3);
		
		System.out.println("Marca: " + pat1.getMarca());
		System.out.println("Modelo: " + pat1.getModelo());
		System.out.println("Cor: " + pat1.getCor());
		System.out.println("Numero de rodas: " + pat1.getRodas());
		
	}

}
