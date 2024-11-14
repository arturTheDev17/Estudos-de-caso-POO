package atividade4;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Essa classe serve para guardar os dados da nossa indústria.
 * @author Artur Neves Höpner
 */

public class Dados {
	
	public static Map < Integer , Operario > operarios = new HashMap < Integer , Operario >();
	
	/**
	 * Criação dos HashMaps para guardar os diversos dados.
	 */

	/**
	 * Esse atributo serve apenas para garantir que não sejam inseridos dados duplicados.
	 */
	
	/**
	 *  Essa função serve para guardar os dados no banco de dados.
	 * @param args
	 * @param escolha
	 */
	public static void main ( String [] args, char escolha ) {
		
		
		if ( escolha == '3' ) {
			
			for ( Integer chave : operarios.keySet() ) {
				
				JLabel nomeOperario = new JLabel ( " Nome : " + operarios.get( chave ).getNome() );
				JLabel salarioOperario = new JLabel ( " Salário: R$ " + operarios.get(chave).getSalario() );
				JLabel habilidadesOperario = new JLabel ( " Habilidades: " +  operarios.get(chave).getHabilidade() );
				
				Object [] componentes = new Object [] { nomeOperario , salarioOperario , habilidadesOperario };
				JOptionPane.showMessageDialog( null , componentes );
				
			}
		
		}
		
	}

	/**
	 * Essa função serve para inserir dados de teste no banco de dados.
	 */
	
	public static void inserirDados ( boolean inserido ) {
		if ( inserido ) {
			
			System.out.println ( "Os valores já foram inseridos." );
			
		} else {
			
			Operario operario1 = new Operario();
			Operario operario2 = new Operario();
		
			operario1.setHabilidade ( "Esperto" );
			operario1.setId ( 88 );
			operario1.setNome ( "Gabriel" );
			operario1.setSalario ( "1400" );
			
			operario2.setHabilidade ( "Sagaz" );
			operario2.setId ( operarios.size() );
			operario2.setNome ( "Eduardo" );
			operario2.setSalario ( "2000" );
			
			operarios.put ( operario1.getId() , operario1 );
			operarios.put ( operario2.getId() , operario2 );
			
		}
		
	}
	
	/**
	 * Essas funções servem para guardar os dados nos respectivos banco de dados.
	 * @param cod
	 * @param maquina
	 */
		
	public static void inserirOperario ( Integer cod, Operario operario ) {
		operarios.put ( cod, operario );
	
	}
	
}