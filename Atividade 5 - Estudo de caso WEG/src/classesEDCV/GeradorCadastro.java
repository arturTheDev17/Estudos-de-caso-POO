package classesEDCV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * Classe para cadastro dos atributos de um objeto Gerador
 * @author artur_hopner
 *
 */
public class GeradorCadastro {
	
	/**
	 * Classe para atribuiçao de valores a um objeto Gerador
	 * @return retorna objeto Gerador com os atributos cadastrados
	 */
	public static Gerador CadastroProduto ( ) {	
		JLabel 	nome = new JLabel ( "Insira o nome: " ) , 
				preco = new JLabel( "Insira o preço do produto: " ),
				potencia = new JLabel ( "Insira a potência: " ),
				tensao = new JLabel ( "Insira a tensão (V): " ),
				tipoCombustivel = new JLabel ( "Insira o tipo de combustível: " ),
				autonomia = new JLabel ( "Insira a autonomia do gerador: " );
		
		JTextField 	tfNome = new JTextField (), 
					tfPreco = new JTextField () , 
					tfPotencia = new JTextField() , 
					tfTipoCombustivel = new JTextField(),
					tfAutonomia = new JTextField() ,
					tfTensao = new JTextField();
		
		Object juntador [] = 
			{ nome , tfNome , preco , tfPreco , potencia , tfPotencia , tipoCombustivel, 
				tfTipoCombustivel, autonomia, tfAutonomia , tensao , tfTensao };
		
		int teste = 0;
		
		while ( teste != -1 && ( tfNome.getText().isBlank() || !tfPreco.getText().matches( "^[0-9]+$" ) || 
				!tfPotencia.getText().matches( "^[0-9]+$" ) || !tfTensao.getText().matches( "^[0-9]+$" ) || 
				tfTipoCombustivel.getText().isBlank() || !tfAutonomia.getText().matches( "^[0-9]+$" ) ) ) {
			
			teste = JOptionPane.showConfirmDialog
					( null , juntador , "Cadastrar um Gerador WEG®" , JOptionPane.DEFAULT_OPTION , JOptionPane.DEFAULT_OPTION );
			

		}

		if ( teste == -1 ) {
			return null;
		}
		
		
		Gerador produto = new Gerador ( 
				tfNome.getText() , 
				"Gerador",
				Float.parseFloat( tfPotencia.getText() ), 
				Float.parseFloat( tfTensao.getText() ),
				Float.parseFloat( tfPreco.getText() ) , 
				tfTipoCombustivel.getText(),
				Integer.parseInt( tfAutonomia.getText() )
				);
		
		return produto;
	}
}
