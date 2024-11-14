package classesEC6M;

import java.util.Random;
import java.util.Scanner;

/**
 * Essa classe é utilizada para demonstrar o funcionamento das telas e atualizações com alguns testes
 * @author artur_hopner
 * @version 2.0
 */
public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String escolha = "";
        WeatherDataCentral weatherDataCentral = new WeatherDataCentral();
        do {
            System.out.println( "MENU" );
            System.out.println( "1. Cadastrar uma estação\n2. Atualizar a leitura de uma estação\n3. Ver dados atuais de uma estação" );
            escolha = sc.nextLine();

            switch ( escolha ) {
                case "1": {
                    WeatherStation weatherStation = new WeatherStation();
                    weatherStation = WeatherStationCadastro.cadastro();
                    weatherStation.inscrever(weatherDataCentral);
                    weatherDataCentral.addWeatherStation(weatherStation);
                    Random ran = new Random();
                    WeatherData data = new WeatherData(ran.nextInt(99) + 1, ran.nextInt(90) + 1, ran.nextInt(99) + 1);
                    weatherStation.addDadosArmazenados(data);
                    weatherStation.definirMedicoes(data);
                }
                break;

                case "2": {
                    System.out.println("Escolha uma das estações para atualizar:");
                    for (WeatherStation weatherStation : weatherDataCentral.getWeatherStations()
                    ) {
                        System.out.println(weatherStation.getNome());
                    }
                    String nome = sc.nextLine();
                    for (WeatherStation weatherStation : weatherDataCentral.getWeatherStations()
                    ) {
                        if (weatherStation.getNome().equals(nome)) {
                            Random ran = new Random();
                            WeatherData data = new WeatherData(ran.nextInt(99) + 1, ran.nextInt(90) + 1, ran.nextInt(99) + 1);
                            weatherStation.addDadosArmazenados(data);
                            weatherStation.definirMedicoes(data);
                        }
                    }
                }
                break;

                case "3": {
                    System.out.println("Escolha uma das estações para ver os dados:");
                    for (WeatherStation weatherStation : weatherDataCentral.getWeatherStations()
                    ) {
                        System.out.println(weatherStation.getNome());
                    }
                    String nome = sc.nextLine();
                    for (WeatherStation weatherStation : weatherDataCentral.getWeatherStations()
                    ) {
                        if (weatherStation.getNome().equals(nome)) {
                            weatherDataCentral.getCurrentConditionsDisplay().verDados(weatherStation);
                            weatherDataCentral.getStatisticsDisplay().verDados(weatherStation);

                        }
                    }
                }
                break;
            }
        } while ( escolha != "0" );


        WeatherStation weatherStation1 = new WeatherStation();




        System.out.print ( "Escolha um índice: " );
        int indice = sc.nextInt();
        System.out.println( weatherStation1.getDadosArmazenados().get(indice).getTemperatura() );
    }
}
