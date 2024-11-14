package classesEDCV;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Classe para cadastro dos atributos de um objeto ServicoManutencao
 * @author artur_hopner
 *
 */
public class ServicoManuntencaoCadastro {
	/**
	 * Classe para atribuiçao de valores a um objeto ServicoManutencao
	 * @return retorna objeto ServicoManutencao com os atributos cadastrados
	 */
	public static ServicoManutencao CadastroServico() {
		
		JLabel 	descricao = new JLabel ( "Insira a descrição da manutenção: " ) , 
				custo = new JLabel( "Insira o custo: " );
				
		JTextField  tfDescricao = new JTextField (),
					tfCusto = new JTextField();
		
		Object juntador [] = 
			{ descricao , tfDescricao , custo , tfCusto };
		
		int teste = 0;
		
		while ( teste != -1 && ( tfDescricao.getText().isBlank() || !tfCusto.getText().matches( "^[0-9]+$" ) ) ) {
			teste = JOptionPane.showConfirmDialog
					( null , juntador , "Cadastrar Serviço de manutenção" , JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE );
				
		}

		if ( teste == -1 ) {
			return null;
		}
		
		ServicoManutencao servico = new ServicoManutencao ( 
				tfDescricao.getText() , 
				Float.parseFloat( tfCusto.getText() ) );
		
		return servico;
	}
}
