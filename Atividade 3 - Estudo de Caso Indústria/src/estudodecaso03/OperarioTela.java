package estudodecaso03;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OperarioTela {
	public void cadastroOperario () {
		
		Operario operario1 = new Operario ();
		JLabel nome = new JLabel( "Informe o nome do operário:" ) , salario = new JLabel( "Insira o salário do operário:" );
		JTextField txNome = new JTextField() , txSalario = new JTextField();
		JLabel erro = new JLabel( "Valor inválido, tente novamente:" );
		erro.setForeground( Color.red );

		Object componentesNome [] = new Object [] { null , nome , txNome } ,  
			   componentesSalario [] = new Object [] { null , salario , txSalario },
			   componentes []  = new Object [] { componentesNome ,componentesSalario  };
		
		boolean valido = false;
		JOptionPane.showMessageDialog ( null , componentes );
		
		do {
			
			if ( !operario1.setNome ( txNome.getText() ) ) {
				componentesNome [ 0 ] = erro;
				JOptionPane.showMessageDialog ( null , componentesNome );
			}
			
			if ( !operario1.setSalario ( txSalario.getText() ) ) {
				componentesSalario [ 0 ] = erro;
				JOptionPane.showMessageDialog ( null , componentesSalario );
			}
			
			if ( operario1.setNome ( txNome.getText() ) && operario1.setSalario ( txSalario.getText() ) ) {
				valido = true;
			}
			
		} while ( !valido );
		
		JLabel habilidade = new JLabel( "Informe as habilidades. Coloque uma vírgula entre cada uma delas:" );
		JTextField txHabilidade = new JTextField();
		Object componentesHabilidade [] = new Object [] { null , habilidade , txHabilidade };
		
		JOptionPane.showMessageDialog ( null , componentesHabilidade );
		String habilidades [] = txHabilidade.getText().split( "," );
		
		for ( int i = 0 ; i < habilidades.length ; i++ ) {
			operario1.setHabilidade ( habilidades [ i ] );			
		}
				
		operario1.setId ( ( Integer ) Dados.operarios.size() );
		
		/*
		 * Guarda o id como o próprio tamanho do HashMap, ou seja, autoIncrement.
		 */
		
		Dados.inserirOperario ( Dados.operarios.size() , operario1 );
		System.out.println( " Operário cadastrado com sucesso. " );
		
	}

}
