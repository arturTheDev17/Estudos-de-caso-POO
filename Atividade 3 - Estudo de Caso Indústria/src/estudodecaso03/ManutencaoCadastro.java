package estudodecaso03;

import java.util.Scanner;

/**
 * Essa classe serve para executar as funções de cadastro de manutenção.
 * @author Saymon Oliveira de Castro
 */

public class ManutencaoCadastro {
	
	public static void main ( String [] args, Dados dados  ) {
		
		Scanner sc = new Scanner ( System.in );
		
		Manutencao agendamento1 = new Manutencao ();
		
		if ( Dados.operarios.size () == 0 || Dados.maquinas.size () == 0 ) {
			
			System.out.println( " Não há operários ou máquinas cadastradas");
		
		} else 
			
			/*
			 * Essa função serve para se não haver operaríos ou máquinas cadastrados informar o usuário e parar a classe.
			 */
		
		{
		
		do {
			
			System.out.println( " Insira a data do agendamento " );
			
		} while ( !agendamento1.setData((sc.nextLine())));
		
		
		do {
			
			System.out.println( " Insira a hora do agendamento " );
			System.out.println( " EX : 10:50 " );
			
		} while ( !agendamento1.setHora((sc.nextLine())));
		
		/*
		 * A função dados.main recebe um número equivalente a um HashMap para mostrar os valores armazenados neste.
		 */
		
		Dados.main (  args, '3' );
		System.out.println( "Escolha o operador: " );

		String operario = sc.next();
		boolean conteve = false;
		
		do {
			
			for ( Integer chave : Dados.operarios.keySet() ) {
				
				/*
				 * Essa parte usa um for:Each para comparar o nome do operário inserido com todos os operários registrados, e se
				 * existir tal operário, aprovar o registro dele na manutenção.
				 */
				
				if ( Dados.operarios.get( chave ).getNome().equals ( operario ) ) {
					agendamento1.setManutentor ( Dados.operarios.get( chave ) );
					conteve = true;
				
				}
			}
			
			if ( !conteve ) {
				System.out.println ( "Operário não encontrado." );
			}
		
		} while ( !conteve );
		
		conteve = false;
		
		/*
		 * A função dados.main recebe um número equivalente a um HashMap para mostrar os valores armazenados neste.
		 */
		
		Dados.main (  args, '2' );
		System.out.println ( "Escolha a máquina: " );
		
		String maquina = sc.next();
		
		do {
			
			for ( Integer chave : Dados.maquinas.keySet() ) {
				
				/*
				 * Essa parte usa um for:Each para comparar o nome da máquina inserida com todas as máquinas registradas, e se
				 * existir tal máquinas, aprovar o registro desta na manutenção.
				 */
				
				if ( Dados.maquinas.get( chave ).getNome().equals ( maquina ) ) {
					agendamento1.setMaquinator ( Dados.maquinas.get( chave ) );
					conteve = true;
				
				}
			
			}
			
			if ( !conteve ) {
				
				System.out.println ( "Máquina não encontrada." );
				
			}
		
		} while ( !conteve );

		/**
		 * Guarda o id como o próprio tamanho do HashMap, ou seja, autoIncrement.
		 */
		
		agendamento1.setId ( ( Integer ) dados.manutencoes.size() );

		dados.inserirManutencao ( dados.manutencoes.size() , agendamento1 );
		
		System.out.println( " Agendamento registrado " );
		
		}
	}
}