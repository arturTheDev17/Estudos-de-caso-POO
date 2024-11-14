package estudodecaso03;

/**
 * Essa classe serve executar as funções de verificação da máquina.
 * @author Artur Neves Höpner
 */

import java.util.Scanner;

public class MaquinaCadastro {

	public static void main ( String [] args , Dados dados ) {
		
		Maquina maquina1 = new Maquina();
		Scanner sc = new Scanner ( System.in );
		
		do { System.out.print ( "Insira o nome: " ); } while ( !maquina1.setNome ( sc.nextLine() ) );
		do { System.out.print ( "Insira o tipo: " ); } while ( !maquina1.setTipo ( sc.nextLine() ) );
		do { System.out.print ( "Insira o status: " ); } while ( !maquina1.setStatus ( sc.nextLine() ) );	
		
		String ativ , inativ;
		do {
			do { 
				System.out.println ( "Tempos de atividade e inatividade devem ser juntos iguais a 24h" );
				System.out.print ( "Insira o tempo de atividade: " ); 
				ativ = sc.nextLine();
				
			} while ( !maquina1.setTempoDeAtividade ( ativ ) );	
			do { 
				System.out.print ( "Insira o tempo de inatividade: " ); 
				inativ = sc.nextLine();
			} while ( !maquina1.setTempoDeInatividade ( inativ ) );
			
		} while ( Integer.parseInt( ativ ) + Integer.parseInt( inativ ) != 24 );
		
		System.out.println();
		
		do { System.out.print ( "Insira a taxa de produtividade: " ); } while ( !maquina1.setTaxaDeProdutividade ( sc.nextLine() ) );
		
		Producao linhas = null;
		do { 
			for ( Integer key : dados.linhasProducao.keySet() ) {
				System.out.println ( "Setor: " + dados.linhasProducao.get( key ).getSetor() );
			}
			System.out.print ( "Insira a linha na qual esta máquina está situada: " ); 
			
			boolean contem = false;
			while ( !contem ) {
				String linha = sc.nextLine();
				for ( Integer key : dados.linhasProducao.keySet() ) {
					if ( dados.linhasProducao.get( key ).getSetor().equals ( linha )  ) {
						linhas = dados.linhasProducao.get( key );
						contem = true;
					} 
				}
				if ( !contem ) {
					
					System.out.println ( "Esse nome não existe... Tente denovo." );
					
				}
			}
			
		} while ( !maquina1.setLinha ( linhas ) );
		/*
		 * Guarda o id como o próprio tamanho do HashMap, ou seja, autoIncrement.
		 */
		
		maquina1.setMaquinaID ( (Integer) dados.maquinas.size() );
		dados.inserirMaquina ( dados.maquinas.size() , maquina1 );
	
	}
}