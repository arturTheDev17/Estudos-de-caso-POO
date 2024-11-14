package exercicioEncapsulamento;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoCadastro {
	public static void main ( String [] args ) {
		Scanner sc = new Scanner ( System.in );
		Pedido pedi = new Pedido();
		PessoaCadastro pessCad = new PessoaCadastro();
		Pessoa pess = new Pessoa();
		ProdutosCadastro prodCad = new ProdutosCadastro();
		 ArrayList < Produto > produtos = new ArrayList< Produto >();	
		char resposta = ' ';
		PessoaCadastro.main ( args );
		pess = pessCad.getPessoa();
		pedi.setPessoa ( pess );
		pedi.setData();	
		
		do {
			prodCad.main ( args );
			produtos.add ( prodCad.getProduto() );			
			System.out.println ( "Gostaria de adicionar mais um produto ao carrinho? s/n" );
			resposta = sc.next().charAt(0);
		} while ( resposta != 's' && resposta != 'S' );
		
		
		/*System.out.println ( "Nome da pessoa: " + pedi.getPessoa().getNome() );
		System.out.println ( "CPF: " + pedi.getPessoa().getCpf() );
		System.out.println ( "RG: " + pedi.getPessoa().getRg() );*/
		
		System.out.println ( "Data do pedido: " + pedi.getData() );
		System.out.println ( "Número do pedido: " + pedi.getNumero() );
		System.out.println ( "Quantidade de itens no pedido: " + pedi.getQtdProdutos() );
		System.out.println ( "Valor Total: " + pedi.getValorTotal() );
	}
}
