package atividade4;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Essa classe serve para executar o gerenciamento da produção.
 * @author Artur Neves Höpner
 */

public class Exec {
	
	
	public static void main ( String [] args ) {
		OperarioTela oTela = new OperarioTela();

		JLabel escolhas = new JLabel ( "3 - Menu Operador    q - Sair" );
		JTextField txEscolhas = new JTextField();
		
		Object componentesEscolha [] = new Object [] { escolhas , txEscolhas };
		
		JLabel escolhaOperario = new JLabel( "1 - Cadastrar operário       2 - Ver operários cadastrados." );  
		JTextField txOperario = new JTextField();
		
		Object componentesOperario [] = new Object [] { escolhaOperario , txOperario };
		
		boolean sair = false;
		
		do {			
			
			JOptionPane.showMessageDialog( null ,  "Menu de escolhas" );
			JOptionPane.showMessageDialog ( null, componentesEscolha );
			
			switch ( txEscolhas.getText() ) {
			
			case "3" : {

				JOptionPane.showMessageDialog( null , componentesOperario );
				
				if ( txOperario.getText().charAt(0) == '1' ) {
					
					oTela.cadastroOperario();
					
				} else if ( txOperario.getText().charAt(0) == '2' ) {
					
					Dados.main ( args , txEscolhas.getText().charAt(0) );
					
				} else {
					
					JOptionPane.showMessageDialog( null , "Valor Inválido." );
				
				}
				
				
			}
			
			break;
			
			case "q" : {
				sair = true;
			}
			break;
			
			default:
				JOptionPane.showMessageDialog ( null ,  "Valor Inválido." );			
			}
		
		} while ( !sair );
	}
}