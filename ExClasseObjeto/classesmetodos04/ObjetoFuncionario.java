package classesmetodos04;

public class ObjetoFuncionario {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		
		f1.nome = "Joana";
		f1.idade = 30;
		f1.sexo = "Feminino";
		f1.cargo = "Gerente";
		
		f1.apresentar();
		System.out.println("Nome: " + f1.nome);
		System.out.println("Idade: " + f1.idade);
		System.out.println("Sexo: " + f1.sexo);
		System.out.println("Cargo: " + f1.cargo);

	}

}
