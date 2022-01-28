package vetormatriz;

import java.util.Scanner;

/*1. Faça um programa que crie um vetor por leitura com 5 valores de pontuação de uma
atividade e o escreva em seguida. Encontre após a maior pontuação e a apresente.*/

public class VetorMatriz01 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in); 
		
		double notas[] = new double[5];
		double maior = 0;
		
		System.out.println("Digite as 5 notas do aluno: ");
		
		for(int i = 0; i < notas.length; i++) {
			
			System.out.println((i+1) + "º do aluno: ");
			notas[i] = entrada.nextDouble();
			if(notas[i] > maior) {
			maior = notas[i];
		}
		}	
		System.out.println("Maior nota: " + maior );
	}

}
