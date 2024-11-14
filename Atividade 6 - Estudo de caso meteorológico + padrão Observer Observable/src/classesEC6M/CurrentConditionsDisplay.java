package classesEC6M;

import javax.swing.*;

/**
 * Essa classe serve para mostrar as telas de dados atuais na leitura de uma estação
 * @author artur_hopner
 */
public class CurrentConditionsDisplay extends PadraoMostrar {

    @Override
    public void mostrar ( PadraoStation padraoStation ) {

        JLabel texto = new JLabel( " Mudança na leitura atual da estação " + padraoStation.getNome() );
        JLabel temperatura = new JLabel( "Temperatura: " + padraoStation.getDados().getTemperatura() );
        JLabel umidade = new JLabel( "Umidade: " + padraoStation.getDados().getUmidade() );
        JLabel pressao = new JLabel( "Pressão: " + padraoStation.getDados().getPressao() );

        Object [] components = new Object[] { texto , temperatura , umidade , pressao };

        JOptionPane.showConfirmDialog
                ( null , components , "NOTIFICAÇÃO!" , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );

    }

    public void verDados ( PadraoStation padraoStation ) {

        JLabel temperatura = new JLabel( "Temperatura: " + padraoStation.getDados().getTemperatura() );
        JLabel umidade = new JLabel( "Umidade: " + padraoStation.getDados().getUmidade() );
        JLabel pressao = new JLabel( "Pressão: " + padraoStation.getDados().getPressao() );

        Object [] components = new Object[] { temperatura , umidade , pressao };

        JOptionPane.showConfirmDialog
                ( null , components , "Leitura atual da estação: " + padraoStation.getNome() , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );

    }

}

