package exercicioEncapsulamento;

import java.util.Scanner;

public class ProdutosCadastro {

	private static Produto prod = new Produto();

	public static void main ( String [] args ) {
		Scanner sc = new Scanner( System.in );
				
		do {
			System.out.print ( "Insira o nome do produto: " );
		} while ( !prod.setNome ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira a descrição: " );
		} while ( !prod.setDescricao ( sc.nextLine() ) );
		
		do {
			System.out.print ( "Insira o preço: R$ " );
		} while ( !prod.setPreco ( sc.nextFloat() ) );
		
		
		System.out.println ( "Nome: " + prod.getNome() );
		System.out.println ( "Descrição: " + prod.getDescricao() );
		System.out.println ( "Preço: R$ " + prod.getPreco() );
	
	}
	public Produto getProduto () {
		return this.prod;
	}
	
}
