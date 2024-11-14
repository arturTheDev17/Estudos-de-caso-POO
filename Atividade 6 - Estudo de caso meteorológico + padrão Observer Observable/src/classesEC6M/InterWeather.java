package classesEC6M;

/**
 * Essa interface serve como um padrão para inscrever, notificar e desinscrever telas de display a uma estação meteorológica
 * @author artur_hopner
 */
public interface InterWeather {
    public void inscrever(Display display);
    public void notificarDisplays();
    public void desinscrever(Display display);

}
