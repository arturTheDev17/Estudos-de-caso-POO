package estudodecaso03;

import java.util.Scanner;

/**
 * Essa classe serve para executar o gerenciamento da produção.
 * @author Artur Neves Höpner
 */

public class Exec {
	
	
	public static void main ( String [] args ) {
		
		OperarioTela oTela = new OperarioTela();
		//oTela.cadastroOperario();
		
		ControleDeAcesso controle = new ControleDeAcesso();
		Dados dados = new Dados ();
		Scanner sc = new Scanner( System.in );
		String login , senha;
		boolean inserido = false;

		/** Executa o teste de login e senha. */
		/*do {
			System.out.println ( "Insira o login" );
			login = sc.nextLine();
			System.out.println ( "Insira a senha" );
			senha = sc.nextLine();
		} while ( controle.acesso ( login , senha ) == false );*/
		
		char escolha = ' ' , escolhaMenor = ' ';
		System.out.println( "\nOlá! Bem vindo ao sistema, " + controle.getUserAcesso() );

		do {			
			
			System.out.println( " ┌──────────────────────────────────────────────┐ ");
			System.out.println( " |               MENU DE ESCOLHAS               | ");
			System.out.println( " |                                              | ");
			System.out.println( " |   1 - Menu produto     2 - Menu máquina      | ");
			System.out.println( " |   3 - Menu Operador    4 - Menu manutenção   | ");
			System.out.println( " |   5 - Menu produção    c - Adicionar preset  | ");
			System.out.println( " └──────────────────────────────────────────────┘ ");
			escolha = sc.next().charAt(0);
			
			switch ( escolha ) {
			
			case '1': {	
				
				System.out.println( " ┌──────────────────────────────────────────────┐ ");
				System.out.println( " |                MENU DE PRODUTO               | ");
				System.out.println( " |                                              | ");
				System.out.println( " |   1 - Cadastrar Produto.                     | ");
				System.out.println( " |   2 - Ver Produtos Cadastrados.              |" );
				System.out.println( " |   3 - Atualizar processo.                    |" );
				System.out.println( " └──────────────────────────────────────────────┘ ");
				
				escolhaMenor = sc.next().charAt(0);
				
				if ( escolhaMenor == '1' ) {
					System.out.println ( "Produto!" );
					ProdutoCadastro.main ( args , dados );	
				
				} else if ( escolhaMenor == '2' ) {
					Dados.main ( args , escolha );
				
				} else if ( escolhaMenor == '3' ) {
					ProdutoCadastro.atualizarProcesso();
				
				} else
				
				{
					System.out.println ( "Valor inválido..." );
				}
			
			}
			break;
		
			case '2' :
			
			{
				
				System.out.println( " ┌──────────────────────────────────────────────┐ ");
				System.out.println( " |                MENU DA MÁQUINA               | ");
				System.out.println( " |                                              | ");
				System.out.println( " |   1 - Cadastrar Máquina.                     | ");
				System.out.println( " |   2 - Ver Máquinas Cadastradas.              |" );
				System.out.println( " └──────────────────────────────────────────────┘ ");
				
				escolhaMenor = sc.next().charAt(0);
				if ( escolhaMenor == '1' ) {
					System.out.println ( "Máquina!" );
					MaquinaCadastro.main ( args , dados );
				}
				
				else if
				
				( escolhaMenor == '2' ) {
					Dados.main ( args , escolha );
				}
				
				else
				
				{
					System.out.println ( "Valor inválido..." );
				}
			}
			break;
			
			case '3' : {
				
				System.out.println( " ┌──────────────────────────────────────────────┐ ");
				System.out.println( " |                MENU DO OPERÁRIO              | ");
				System.out.println( " |                                              | ");
				System.out.println( " |   1 - Cadastrar Operário.                    | ");
				System.out.println( " |   2 - Ver Operários Cadastrados.             |" );
				System.out.println( " |   3 - Mudar estado da linha de produção.     |" );
				System.out.println( " └──────────────────────────────────────────────┘ ");
				escolhaMenor = sc.next().charAt(0);
				
				if ( escolhaMenor == '1' ) {
					System.out.println ( "Operário!" );
					oTela.cadastroOperario();
				} else if ( escolhaMenor == '2' ) {
					Dados.main ( args , escolha );
				} else if ( escolhaMenor == '3' ){
					OperarioCadastro.mudarEstadoLinha();
				} else {
					System.out.println ( "Valor inválido..." );
				}
				
			}
			break;
			case '4' : {
				
				System.out.println( " ┌──────────────────────────────────────────────┐ ");
				System.out.println( " |               MENU DE MANUTENÇÃO             | ");
				System.out.println( " |                                              | ");
				System.out.println( " |   1 - Agendar uma manutenção.                | ");
				System.out.println( " |   2 - Ver manutenções agendadas.             |" );
				System.out.println( " └──────────────────────────────────────────────┘ ");
				escolhaMenor = sc.next().charAt(0);
				
				if ( escolhaMenor == '1' ) {
					System.out.println ( "Manutenção!" );
					ManutencaoCadastro.main ( args , dados );
				} else if ( escolhaMenor == '2' ) {
					Dados.main ( args , escolha );
				} else {
					System.out.println ( "Valor inválido..." );
				}
				
			}
			break;
			case '5': {
				
				System.out.println( " ┌──────────────────────────────────────────────┐ ");
				System.out.println( " |                MENU DA PRODUÇÃO              | ");
				System.out.println( " |                                              | ");
				System.out.println( " |   1 - Cadastrar uma linha de produção.       | ");
				System.out.println( " |   2 - Ver uma linha cadastrada.              |" );
				System.out.println( " |   3 - Fazer um comentário.                   |" );
				System.out.println( " └──────────────────────────────────────────────┘ ");
				escolhaMenor = sc.next().charAt(0);
				
				if ( escolhaMenor == '1' ) {
					System.out.println ( "Produção!" );
					ProducaoCadastro.main ( args , dados );
				} else if ( escolhaMenor == '2' ) {
					Dados.main ( args , escolha );
				} else if ( escolhaMenor == '3' ) {
					ProducaoCadastro.fazerComentario();
				} else
				
				{
					System.out.println ( "Valor inválido..." );
				}
			
			}
			
			break;
			
			case 'c': {
			
				
				Dados.inserirDados( inserido );
				inserido = true;
			}
			
			break;
			
			default:
			
				System.out.println ( "Valor Inválido." );
			
			}
		
		} while ( escolha != 'q' );
	}
}