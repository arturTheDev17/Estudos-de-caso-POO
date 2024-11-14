package classesEC6M;

import javax.swing.*;

/**
 * Essa classe serve para mostrar as telas de dados estatísticos de uma estação
 * @author artur_hopner
 */
public class StatisticsDisplay extends PadraoMostrar {

    @Override
    public void mostrar ( PadraoStation padraoStation ) {
        float somaTemperatura = 0;
        float somaUmidade = 0;
        float somaPressao = 0;

        for (int i = 0; i < padraoStation.getDadosArmazenados().size() ; i++) {
            somaTemperatura = somaTemperatura + padraoStation.getDadosArmazenados().get(i).getTemperatura();
            somaUmidade = somaUmidade + padraoStation.getDadosArmazenados().get(i).getUmidade();
            somaPressao = somaPressao + padraoStation.getDadosArmazenados().get(i).getPressao();
        }

        float mediaTemperatura = somaTemperatura / padraoStation.getDadosArmazenados().size();
        float mediaUmidade = somaUmidade / padraoStation.getDadosArmazenados().size();
        float mediaPressao = somaPressao / padraoStation.getDadosArmazenados().size();

        JLabel texto = new JLabel( " Mudança nas estatísticas da estação " + padraoStation.getNome() );
        JLabel temperatura = new JLabel( "Temperatura média: " + mediaTemperatura );
        JLabel umidade = new JLabel( "Umidade média: " + mediaUmidade );
        JLabel pressao = new JLabel( "Pressão média: " + mediaPressao );

        Object [] components = new Object[] { texto , temperatura , umidade , pressao };

        JOptionPane.showConfirmDialog
                ( null , components , "NOTIFICAÇÃO!" , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );

    }

    public void verDados ( PadraoStation padraoStation ) {
        float somaTemperatura = 0;
        float somaUmidade = 0;
        float somaPressao = 0;

        for (int i = 0; i < padraoStation.getDadosArmazenados().size() ; i++) {
            somaTemperatura = somaTemperatura + padraoStation.getDadosArmazenados().get(i).getTemperatura();
            somaUmidade = somaUmidade + padraoStation.getDadosArmazenados().get(i).getUmidade();
            somaPressao = somaPressao + padraoStation.getDadosArmazenados().get(i).getPressao();
        }

        float mediaTemperatura = somaTemperatura / padraoStation.getDadosArmazenados().size();
        float mediaUmidade = somaUmidade / padraoStation.getDadosArmazenados().size();
        float mediaPressao = somaPressao / padraoStation.getDadosArmazenados().size();

        JLabel temperatura = new JLabel( "Temperatura média: " + mediaTemperatura );
        JLabel umidade = new JLabel( "Umidade média: " + mediaUmidade );
        JLabel pressao = new JLabel( "Pressão média: " + mediaPressao );

        Object [] components = new Object[] { temperatura , umidade , pressao };

        JOptionPane.showConfirmDialog
                ( null , components , "Estatísticas da estação " + padraoStation.getNome() , JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE );

    }


}