package estudodecaso03;

/**
 * Essa classe serve para executar as funções de verificação do operarío.
 * @author Saymon Oliveira de Castro
 */

import java.util.Scanner;

public class OperarioCadastro {
	
	public static void main ( String [] args, Dados dados ) {
		
		Operario operario1 = new Operario ();
		
		Scanner sc = new Scanner ( System.in );
		
		do { System.out.println( " Insira o Nome do operador " ); } while (!operario1.setNome(sc.nextLine()));
		
		do { System.out.println( " Insira o salário do operador " ); } while (!operario1.setSalario(sc.nextLine()));
		
		char choice;
		
		do { 
			
			/*
			 * Laço de repetição que serve para inserir n habilidades em um atributo arraylist no objeto operário1.
			 */
			
			System.out.println ( " Insira as habilidades " ); 
			operario1.setHabilidade ( sc.next() );
			System.out.println( " Gostaria de inserir mais uma habilidade ? 'n' para não" );
			
			choice =  sc.next().charAt (0); 
			
		} while ( choice != 'n' );
		
		operario1.setId ( ( Integer ) dados.operarios.size() );
		
		/*
		 * Guarda o id como o próprio tamanho do HashMap, ou seja, autoIncrement.
		 */
		
		dados.inserirOperario ( dados.operarios.size() , operario1 );
		System.out.println( " Operário cadastrado com sucesso. " );
	}
	
	public static void mudarEstadoLinha () {
		
		Scanner sc = new Scanner ( System.in );

		if ( Dados.linhasProducao.size () == 0 ) {
			
		} else {
		System.out.println ( "Insira o setor da linha de produção que desejas parar/ativar" );
		for ( Integer chave : Dados.linhasProducao.keySet() ) {
			System.out.println ( "Setor : " + Dados.linhasProducao.get(chave).getSetor() );
			System.out.println ( "Ativa? " +Dados.linhasProducao.get(chave).getAtiva() );
		}
		
		String linha = sc.nextLine();
		boolean conteve = false;
		do {
			
			for ( Integer chave : Dados.linhasProducao.keySet() ) {
				
				/*
				 * Essa parte usa um for:Each para comparar o nome da linha inserida com todas as registrados, e se
				 * existir tal operário, aprovar o registro dele na manutenção.
				 */
				
				if ( Dados.linhasProducao.get( chave ).getSetor().equals ( linha ) ) {
					if ( Dados.linhasProducao.get(chave).getAtiva() ) {
						Dados.linhasProducao.get(chave).setAtiva(false);
					} else {
						Dados.linhasProducao.get(chave).setAtiva(true);
					}
					
					conteve = true;
				
				}
			}
			
			if ( !conteve ) {
				System.out.println ( "Linha não encontrada." );
			}
		
		} while ( !conteve );
		
		conteve = false;
		}
	}
}