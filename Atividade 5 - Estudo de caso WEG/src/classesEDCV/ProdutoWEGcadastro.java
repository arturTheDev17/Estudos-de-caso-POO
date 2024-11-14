package classesEDCV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Classe para cadastro dos atributos de um objeto ProdutoWEG
 * @author artur_hopner
 *
 */
public class ProdutoWEGcadastro {
	/**
	 * Classe para atribuiçao de valores a um objeto InversorFrequencia
	 * @return retorna objeto InversorFrequencia com os atributos cadastrados
	 */
	public static ProdutoWEG CadastroProduto ( ) {
		
		JLabel 	nome = new JLabel ( "Insira o nome: " ) , 
				preco = new JLabel( "Insira o preço do produto: " ),
				potencia = new JLabel ( "Insira a potência: " ),
				tensao = new JLabel ( "Insira a tensão (V): " );
		
		JTextField 	tfNome = new JTextField (), 
					tfPreco = new JTextField () , 
					tfPotencia = new JTextField(),
					tfTensao = new JTextField(); 
		
		Object juntador [] = 
			{ nome , tfNome , preco , tfPreco , potencia , tfPotencia , tensao , tfTensao };
		
		int teste = 0;
		
		while ( teste != -1 && ( tfNome.getText().isBlank() || !tfPreco.getText().matches( "^[0-9]+$" ) || 
				!tfPotencia.getText().matches( "^[0-9]+$" ) || !tfTensao.getText().matches( "^[0-9]+$" ) ) ) {
			teste = JOptionPane.showConfirmDialog
			( null , juntador , "Cadastrar outro produto WEG®" , JOptionPane.DEFAULT_OPTION , JOptionPane.DEFAULT_OPTION );
		}

		if ( teste == -1 ) {
			return null;
		}
		
		ProdutoWEG produto = new ProdutoWEG ( 
				tfNome.getText() , 
				"Produto",
				Float.parseFloat( tfPreco.getText() ) , 
				Float.parseFloat( tfPotencia.getText() ), 
				Float.parseFloat( tfTensao.getText() ) );
		
		return produto;
	}

}
