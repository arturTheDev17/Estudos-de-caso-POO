package classesEDCV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Classe para cadastro dos atributos de um objeto MotorEletrico
 * @author artur_hopner
 *
 */
public class MotorEletricoCadastro {
	/**
	 * Classe para atribuiçao de valores a um objeto MotorEletrico
	 * @return retorna objeto MotorEletrico com os atributos cadastrados
	 */
	public static MotorEletrico CadastroProduto ( ) {	
		JLabel 	nome = new JLabel ( "Insira o nome: " ) , 
				preco = new JLabel( "Insira o preço do produto: " ),
				potencia = new JLabel ( "Insira a potência: " ),
				tensao = new JLabel ( "Insira a tensão (V): " ),
				tipoEnrolamento = new JLabel ( "Insira o tipo de enrolamento: " ),
				eficiencia = new JLabel ( "Insira a eficiência do motor: " );
		
		JTextField 	tfNome = new JTextField (), 
					tfPreco = new JTextField () , 
					tfPotencia = new JTextField() , 
					tfTipoEnrolamento = new JTextField(),
					tfEficiencia = new JTextField(),
					tfTensao = new JTextField();
		
		Object juntador [] = 
			{ nome , tfNome , preco , tfPreco , potencia , tfPotencia , tipoEnrolamento, 
				tfTipoEnrolamento, eficiencia, tfEficiencia , tensao , tfTensao };
		
		int teste = 0;
		
		while ( teste != -1 && ( tfNome.getText().isBlank() || !tfPreco.getText().matches( "^[0-9]+$" ) || 
				!tfPotencia.getText().matches( "^[0-9]+$" ) || !tfTensao.getText().matches( "^[0-9]+$" ) || 
				tfTipoEnrolamento.getText().isBlank() || !tfEficiencia.getText().matches( "^[0-9]+$" ) ) ) {
			
			teste = JOptionPane.showConfirmDialog
					( null , juntador , "Cadastrar Motor elétrico WEG®" , JOptionPane.DEFAULT_OPTION , JOptionPane.DEFAULT_OPTION );
		}

		if ( teste == -1 ) {
			return null;
		}
		
		
		MotorEletrico produto = new MotorEletrico ( 
				tfNome.getText() , 
				"Motor Elétrico",
				Float.parseFloat( tfPotencia.getText() ), 
				Float.parseFloat( tfTensao.getText() ),
				Float.parseFloat( tfPreco.getText() ) , 
				tfTipoEnrolamento.getText(),
				Float.parseFloat( tfEficiencia.getText() )
				);
		
		return produto;
	}
}
