package classesEDCV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InversorFrequenciaCadastro {

	public static InversorFrequencia CadastroProduto ( ) {
		
		JLabel 	nome = new JLabel ( "Insira o nome: " ) , 
				preco = new JLabel( "Insira o preço do produto: " ),
				potencia = new JLabel ( "Insira a potência: " ),
				tensao = new JLabel ( "Insira a tensão (V): " ),
				capacidadeFrequencia = new JLabel ( "Insira a capacidade de frequência: " ),
				numeroFases = new JLabel ( "Insira a quantidade de fases: " );
		
		JTextField 	tfNome = new JTextField (), 
					tfPreco = new JTextField () , 
					tfPotencia = new JTextField() , 
					tfCapacidadeFrequencia = new JTextField(),
					tfNumeroFases = new JTextField(),
					tfTensao = new JTextField();
		
		Object juntador [] = 
			{ nome , tfNome , preco , tfPreco , potencia , tfPotencia , capacidadeFrequencia, 
			  tfCapacidadeFrequencia, numeroFases, tfNumeroFases , tensao , tfTensao };
		
		int teste = 0;
		
		while ( teste != -1 && ( tfNome.getText().isBlank() || !tfPreco.getText().matches( "^[0-9]+$" ) || 
				!tfPotencia.getText().matches( "^[0-9]+$" ) || !tfTensao.getText().matches( "^[0-9]+$" ) || 
				!tfCapacidadeFrequencia.getText().matches( "^[0-9]+$" ) || !tfNumeroFases.getText().matches( "^[0-9]+$" ) ) ) {
			
			teste = JOptionPane.showConfirmDialog
					( null , juntador , "Cadastrar Inversor de Frequência WEG®" , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );
			
			
		}

		if ( teste == -1 ) {
			return null;
		}
		
		
		InversorFrequencia produto = new InversorFrequencia ( 
				tfNome.getText() , 
				"Inversor de Frequência",
				Float.parseFloat( tfPotencia.getText() ), 
				Float.parseFloat( tfTensao.getText() ),
				Float.parseFloat( tfPreco.getText() ) , 
				Float.parseFloat( tfCapacidadeFrequencia.getText() ),
				Integer.parseInt( tfNumeroFases.getText() )
				);
		
		return produto;
	}

}
