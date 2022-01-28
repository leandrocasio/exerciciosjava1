package vetormatriz;
/*Um dado � lan�ado 10 vezes e o valor correspondente � anotado. Fa�a um programa
que gere um vetor com os lan�amentos, escreva esse vetor. A seguir determine e
imprima a m�dia aritm�tica dos lan�amentos, contabilize e apresente tamb�m
quantas foram as ocorr�ncias da maior pontua��o.*/

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
			System.out.println((i + 1) + "�numero sorteado: " + dado[i]);
		}
		for(int i = 0; i < 10; i++) {
			if(dado[i] == maiorNum) {
				vezesjogado++;
			}
			System.out.println();
		}
			System.out.println("Maior numero: " + maiorNum);
			System.out.println("Media dos lan�amentos: " + (media / 10));
	}

}
