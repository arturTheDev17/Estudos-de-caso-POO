package classesEC6M;


/**
 * Essa classe serve como um pacote que guarda as informações atuais de uma estação.
 * @author artur_hopner
 */
public class WeatherData {

    /**
     * representa a temperatura capturada mais recentemente pela estação
     */
    private float temperatura;
    /**
     * representa a umidade capturada mais recentemente pela estação
     */
    private float umidade;
    /**
     * representa a pressão capturada mais recentemente pela estação
     */
    private float pressao;

    public WeatherData ( float t , float u , float p ) {
        setTemperatura(t);
        setUmidade(u);
        setPressao(p);
    }

    public WeatherData (){

    }

    public void setTemperatura(float temperatura) {
        if ( temperatura > 0 ) {
            this.temperatura = temperatura;
        }
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setUmidade(float umidade) {
        if ( umidade <= 100 && umidade > 0 ) {
            this.umidade = umidade;
        }
    }
    public float getUmidade() {
        return umidade;
    }

    public void setPressao(float pressao) {
        if ( pressao > 0 ) {
            this.pressao = pressao;
        }
    }
    public float getPressao() {
        return pressao;
    }
}