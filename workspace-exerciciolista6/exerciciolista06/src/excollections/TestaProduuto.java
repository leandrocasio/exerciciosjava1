package excollections;

import java.util.ArrayList;
import java.util.Scanner;

public class TestaProduuto {

	public static void main(String[] args) {
		
		Scanner entradaProduto = new Scanner(System.in);
		Scanner entradaQuantidade = new Scanner(System.in);
		ArrayList<Produuto> produtos = new ArrayList<>();
		
		System.out.println("Quantidade de produtos: ");
		int numeroProduto = entradaProduto.nextInt();
		entradaProduto.nextLine();
		
		for (int i = 0; i < numeroProduto; i++) {
			
			System.out.print("Nome do produto: ");
			String Produto = entradaProduto.nextLine();
			
			System.out.println("Quantidade estoque: ");
			int Estoque = entradaQuantidade.nextInt();
			
			produtos.add(new Produuto(Produto, Estoque));
		
		}
		
		for(int i = 0; i < produtos.size(); i++) {
			
			System.out.println("Estoque da loja: " + produtos.get(i));
			
		}
		
		System.out.println("Deseja remover algum item da lista? [ 1- SIM || 2- NÃO ]");
		numeroProduto = entradaProduto.nextInt();
		
		while(numeroProduto == 1) {
			
			for(int i = 0; i < produtos.size(); i++) {
				
				System.out.println((i+1) + "º " + produtos.get(i));
				
			}
			
			System.out.println("Qual produto você deseja remover?");
			int remove = entradaProduto.nextInt();
			produtos.remove(remove);
			
			System.out.println("Deseja remover algum outro item da lista? [ 1- SIM || 2- NÃO ]");
			numeroProduto = entradaProduto.nextInt();
			
		}
		
		System.out.println("Deseja alterar algum item da lista? [ 1- SIM || 2- NÃO ]");
		numeroProduto = entradaProduto.nextInt();
		
		for(int i = 0; i < produtos.size(); i++) {
			
			System.out.println("estoque da loja: "+  produtos.get(i));
			
		}
		
		entradaProduto.close();
		entradaQuantidade.close();

	}

}
