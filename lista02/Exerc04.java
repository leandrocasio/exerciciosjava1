package lista02;

import java.util.Scanner;

public class Exerc04 {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		int num;
		double raiz, potencia;
		
		System.out.println("Digite um numero inteiro: ");
		num = leia.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("Par...........");
			raiz = Math.sqrt(num);
			System.out.println("Raiz quadrada: " + raiz);
		}
		else {
			System.out.println("Impar.......");
		}

	}

}

