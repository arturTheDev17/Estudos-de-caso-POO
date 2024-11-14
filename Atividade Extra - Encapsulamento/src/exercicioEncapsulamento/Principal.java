package exercicioEncapsulamento;

import java.util.Scanner;

public class Principal {

	public static void main ( String [] args ) {
		Scanner sc = new Scanner ( System.in );
		System.out.println ( "\n   BEM VINDO AO MENU SUPREMO!  " );
		System.out.println ( "╔══════════════════════════════╗" );
		System.out.println ( "║     1. Cadastrar pessoa      ║" );
		System.out.println ( "║     2. Cadastrar Pedido      ║" );
		System.out.println ( "║     3. Cadastrar Produto     ║" );
		System.out.println ( "║     q.      Sair             ║" );
		System.out.println ( "╚══════════════════════════════╝" );
		switch ( sc.next().charAt ( 0 ) ) {
		case '1' :
			PessoaCadastro.main   ( args );
			break;
		case '2' :
			ProdutosCadastro.main ( args );
			break;
		case '3' :
			PedidoCadastro.main   ( args );
			break;
		case 'q' :
			break;
		}
	}

}
