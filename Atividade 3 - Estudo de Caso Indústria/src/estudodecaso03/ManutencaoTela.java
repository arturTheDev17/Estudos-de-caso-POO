package estudodecaso03;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class ManutencaoTela {

	public static void main ( String [] args ) {

		JComboBox<String> manutentor = new JComboBox<String>() , cbMaquina = new JComboBox<String>();
		
		manutentor.addItem( "João" );
		manutentor.addItem( "Pedro" );
		manutentor.addItem( "Gabriel" );
		manutentor.setSelectedIndex( 2 );
		
		cbMaquina.addItem( "Torno" );
		cbMaquina.addItem( "Fresadora" );
		cbMaquina.addItem( "Clic02" );

		JLabel 	operador = new JLabel( "Escolha o operador:" ), 
				maquina  = new JLabel( "Escolha a máquina:" ), 
				txData   = new JLabel( "Insira a data:" );


		JSpinner spinnerData = new JSpinner ( new SpinnerDateModel(  ) );
		JSpinner.DateEditor ded = new JSpinner.DateEditor ( spinnerData, "dd/MM/yyyy" );
		spinnerData.setEditor ( ded );
		
		
		//JPasswordField txSenha = new JPasswordField();
		//Agrupa os diferentes objetos
		
		Object componentes []  = new Object [] { operador , manutentor, maquina , cbMaquina , txData , spinnerData };
		JOptionPane.showMessageDialog( null , componentes );
		//Objeto da classe pessoa:
						  		
		Manutencao manut = new Manutencao ( manutentor.getSelectedItem().toString() , cbMaquina.getSelectedItem().toString() , spinnerData.getValue().toString() );
		
		System.out.println ( manut.getOperario() );
		System.out.println ( manut.getMaquina() );
		System.out.println ( manut.getData() );

	}

}
