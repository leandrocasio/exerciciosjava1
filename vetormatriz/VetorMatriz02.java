package vetormatriz;
/*Um dado é lançado 10 vezes e o valor correspondente é anotado. Faça um programa
que gere um vetor com os lançamentos, escreva esse vetor. A seguir determine e
imprima a média aritmética dos lançamentos, contabilize e apresente também
quantas foram as ocorrências da maior pontuação.*/

import java.util.Random;

public class VetorMatriz02 {

	public static void main(String[] args) {
		
		Random sorteia = new Random();
		
		int[] dado = new int[10];
		int maiorNum = 0;
		int media = 0;
		int vezesjogado = 0;
		
		System.out.println("Numeros sorteados: ");
		
		for(int i = 0; i < 10; i++) {
			dado[i] = sorteia.nextInt(5) + 1;
			media = media + dado[i];
			if(dado[i] > maiorNum) {
				maiorNum = dado[i];
		}
			System.out.println();	
			System.out.println((i + 1) + "ºnumero sorteado: " + dado[i]);
		}
		for(int i = 0; i < 10; i++) {
			if(dado[i] == maiorNum) {
				vezesjogado++;
			}
			System.out.println();
		}
			System.out.println("Maior numero: " + maiorNum);
			System.out.println("Media dos lançamentos: " + (media / 10));
	}

}
