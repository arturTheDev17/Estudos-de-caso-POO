package estudodecaso03;

import java.util.Scanner;

/**
 * Essa classe serve para executar as verificações dos dados dos produtos.
 * @author Saymon Oliveira de Castro
 */

public class ProdutoCadastro {

	public static void main ( String [] args, Dados dados ) {
		Produto produto1 = new Produto ();
		Scanner sc = new Scanner ( System.in );
	
	
		do { 
			
			System.out.println ( " Insira o Nome do produto " ); 
		
		} while ( !produto1.setNome(sc.nextLine()));
		
		System.out.println ( " Informe a descrição " ); produto1.setDescriçao ( sc.nextLine());
	
		 do { 
			 
			 System.out.println( " Insira o processo de fabricação " );
		
		 }  while ( !produto1.setProcesso(sc.nextLine()));
	
		 char choice;
	
	
		 do {
		
			 System.out.println( " Insira os componentes " );
			 System.out.println( "Confirme." ); 
			 sc.nextLine();
			 produto1.addComponente (sc.nextLine());
			 System.out.println( " Gostaria de inserir mais um componente ? Escreva ' s ' se sim " );
			 choice = sc.next().charAt (0);
			 
			 /**
			  * Insere inumeros componentes em um arraylist
			  */
	
		 } while ( choice == 's' );
	
	
		 dados.inserirProduto ( dados.produtos.size() , produto1 );
	
		 System.out.println( " Produto cadastrado com sucesso. " );
	
	}

	public static void atualizarProcesso ( ) {
		if ( Dados.produtos.size() == 0 ) {
			
			System.out.println ( "não há produtos cadastrados" );
		} 
		
		else
		
		{
		
			for ( Integer chave : Dados.produtos.keySet() ) {
			System.out.println ( Dados.produtos.get( chave ).getNome() );
			System.out.println ( Dados.produtos.get( chave ).getProcesso() );
		}
		
		System.out.println ( "Insira o nome do produto onde o processo será atualizado:" );
		Scanner sc = new Scanner ( System.in );
		String produto = sc.nextLine();
		for ( Integer chave : Dados.produtos.keySet() ) {
			if ( Dados.produtos.get( chave ).getNome().equals ( produto ) ) {
				Produto prod = Dados.produtos.get( chave );
				do { System.out.println( "Insira o novo processo de fabricação " );	}  while ( !prod.setProcesso(sc.nextLine()));
				Dados.produtos.replace ( Dados.produtos.get( chave ).getId() , prod );
			
			}
		
		}
		
		}
	
	}
}