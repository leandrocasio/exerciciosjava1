package lista02;

import java.util.Scanner;

/*Fa�a um programa que receba tr�s inteiros e diga qual deles � o maior.*/

public class Exerc01 {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int maior;
		
		System.out.println("Escreva 1� numero: ");
		n1 = leia.nextInt();
		
		System.out.println("Escreva 2� numero");
		n2 = leia.nextInt();
		
		System.out.println("Escreva 3� numero");
		n3 = leia.nextInt();
		
		if(n1 > n2 && n1 > n3) {
			maior = n1;
			System.out.println("O maior numero �: " + maior);
		}
		else if(n2 > n3 && n2 > n1) { 
			maior = n2;
			System.out.println("O maior numero �: " + maior);
		}			
		else { 
			maior = n3;
			System.out.println("O maior numero �: " + maior);	
		}
	
	}

}
