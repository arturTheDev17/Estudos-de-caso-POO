package classesEC6M;

import javax.swing.*;

/**
 * Classe que serve para cadastrar uma estação usando {@link JOptionPane}
 * @author artur_hopner
 */
public class WeatherStationCadastro {
    public static WeatherStation cadastro () {
        JLabel 	nome = new JLabel ( "Insira o nome: " );


        JTextField tfNome = new JTextField ();

        Object juntador [] =
                { nome , tfNome };

        int teste = 0;

        while ( teste != -1 && tfNome.getText().isEmpty() ) {

            teste = JOptionPane.showConfirmDialog
                    ( null , juntador , "Cadastrar uma estação meteorológica" , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );


        }

        if ( teste == -1 ) {
            return null;
        }


        WeatherStation estacao = new WeatherStation ( tfNome.getText() );

        return estacao;
    }

}
