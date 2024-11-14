package classesEC6M;


import java.util.ArrayList;

/**
 * Essa classe serve para implementar a interface e definir o funcionamento de diversos métodos, além de criar os atributos
 * @author artur_hopner
 *
 */
 public abstract class PadraoStation implements InterWeather {
    private ArrayList<Display> displays = new ArrayList<Display>();
    private WeatherData dados;
    private String nome;
    private ArrayList<WeatherData> dadosArmazenados = new ArrayList<WeatherData>();

    @Override
    public void inscrever(Display display) {
        if(display != null){
            this.displays.add(display);
        }
    }

    @Override
    public void notificarDisplays() {
        for ( Display display: displays ) {
            display.update(this);
        }
    }

    @Override
    public void desinscrever(Display display) {
        if (display != null){
            this.displays.remove(display);
        }
    }

    public void definirMedicoes( WeatherData dadosNovos ){
        this.dados = dadosNovos;
        this.notificarDisplays();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public WeatherData getDados() {
        return dados;
    }

    public ArrayList<WeatherData> getDadosArmazenados() {
        return dadosArmazenados;
    }

    public void addDadosArmazenados( WeatherData weatherData ) {
        dadosArmazenados.add(weatherData);
    }

}