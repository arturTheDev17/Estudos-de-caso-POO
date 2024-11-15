/**
 * Classe Episodio que representa um episódio de uma série.
 */
public class Episodio {

    //Atributos encapsulados
    private String titulo;
    private int duracaoMin;
    private int temporada;

    /**
     * Construtor da classe Episodio.
     *
     * @param titulo      O título do episódio.
     * @param duracaoMin  A duração do episódio em minutos.
     * @param temporada   O número da temporada do episódio.
     */
    public Episodio(String titulo, int duracaoMin, int temporada) {
        this.titulo = titulo;
        this.duracaoMin = duracaoMin;
        this.temporada = temporada;
    }

    /**
     * Retorna o título do episódio.
     *
     * @return O título do episódio.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna o número da temporada do episódio.
     *
     * @return O número da temporada.
     */
    public int getTemporada() {
        return temporada;
    }

    /**
     * Retorna a duração do episódio em minutos.
     *
     * @return A duração em minutos.
     */
    public int getDuracaoMin() {
        return duracaoMin;
    }

    /**
     * Retorna uma representação em string do episódio.
     *
     * @return Uma string com o título, duração e temporada do episódio.
     */
    @Override
    public String toString() {
        return "Nome Ep.: " + titulo +
                ", Duração: " + duracaoMin + " min" +
                ", Temporada: " + temporada + "\n";
    }
}
