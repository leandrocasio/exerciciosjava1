package lista02;

import java.util.Scanner;

/*Ler 10 n�meros e imprimir quantos s�o pares e quantos s�o �mpares. (FOR)*/
public class ExercOpc02 {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int num, par = 0 , impar = 0, i;
		
		for(i = 1; i <= 5; i++) {
			
		System.out.println("Escreva " + i + "� numero: "); 
		num = leia.nextInt();
			if(num % 2 == 0) {
				par++;
			}
				else {	
				impar++;
			}	
		}
		System.out.println("Quantidade de pares: " + par);
		System.out.println("Quantidade de impares: " + impar);
	}

}
