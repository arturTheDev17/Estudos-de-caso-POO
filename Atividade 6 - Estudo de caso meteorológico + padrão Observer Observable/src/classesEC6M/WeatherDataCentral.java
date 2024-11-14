package classesEC6M;

import java.util.ArrayList;


/**
 * Essa classe serve para guardar as estações e dados atuais registradas
 * @author artur_hopner
 */
public class WeatherDataCentral implements Display {
    private WeatherData dadosAtuais = new WeatherData();
    private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
    private StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
    private static ArrayList<WeatherStation> weatherStations = new ArrayList<WeatherStation>();

    @Override
    public void update ( PadraoStation padraoStation ) {
        currentConditionsDisplay.mostrar( padraoStation );
        statisticsDisplay.mostrar( padraoStation );
    }

    public ArrayList<WeatherStation> getWeatherStations() {
        return weatherStations;
    }
    public void addWeatherStation( WeatherStation weatherStation ) {
        weatherStations.add( weatherStation );
    }

    public CurrentConditionsDisplay getCurrentConditionsDisplay() {
        return currentConditionsDisplay;
    }

    public StatisticsDisplay getStatisticsDisplay() {
        return statisticsDisplay;
    }
}