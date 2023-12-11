package br.org.MateriaisEsportivos.view;

import java.util.Scanner;
import br.org.MateriaisEsportivos.dao.*;
import br.org.MateriaisEsportivos.model.*;

public class TelaMain {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		//instaciar um objeto aluno
		crudDAO inserir_produto = new crudDAO();
		//instaciar um objeto aluno
		Produto pd1 = new Produto();
		boolean valor = false;
		do{
				System.out.println("Escolha sua acao no BD de produtos da Loja NBB:" + "\nCriar-0" + "\nAtualizar-1" + "\nLerBD-2" + "\nDeletar-3" + "\nSair-4");
				int escolha = entrada.nextInt();
				switch (escolha) {
				case (0)://create
					//criar aluno
					System.out.println("Digite a categoria do produto:");
					pd1.setCategoria(entrada.next());
					System.out.println("Digite o nome do produto:");
					pd1.setNome(entrada.next());
					System.out.println("Digite o preco do produto:");
					pd1.setPreco(entrada.nextFloat());
					inserir_produto.create(pd1);
					System.out.println("Criado produto de Categoria: " + pd1.getCategoria() + " Nome: " + pd1.getNome() + " Preco: R$" + pd1.getPreco() + "\n...");
					break;
				case (1)://update
					//atualizar valoures 
					System.out.println("Digite a categoria do produto:");
					pd1.setCategoria(entrada.next());
					System.out.println("Digite o nome do produto:");
					pd1.setNome(entrada.next());
					System.out.println("Digite o preco do produto:");
					pd1.setPreco(entrada.nextFloat());
					System.out.println("Digite o Nip do produto desejado para update:");
					pd1.setNip(entrada.nextInt());
					inserir_produto.update(pd1);
					System.out.println("Categoria atualizada: " + pd1.getCategoria() + " Nome atualizado: " + pd1.getNome() + " Preco atualizado: R$" + pd1.getPreco()  + "\n...");
					break;
				case (2)://ler lista
					System.out.println("\nNip/Categoria/Nome/Preco");
					for (Produto vassoura : inserir_produto.read()) {
						System.out.println(vassoura.getNip() + " " + vassoura.getCategoria() + " " + vassoura.getNome() + " " + vassoura.getPreco());
					}
					System.out.println("\n...");
					break;
				case (3)://delete
					//excluir item da lista 
					System.out.println("Digite o Nip desejado para exclusao do produto:");
					inserir_produto.delete(entrada.nextInt());
					break;
				case (4):
					valor = true;
					System.out.println("saindo do programa!!!");
					break;
				}//fim switch
		}while(valor == false);
		
	}//fim main

}//fim telamain
