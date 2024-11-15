/**
 * Classe que representa um filme, estendendo a classe Video.
 */
public class Filme extends Video {
    private int duracaoMin;

    /**
     * Define a duração do filme em minutos.
     *
     * @param duracaoMin A duração do filme em minutos.
     */
    public void setDuracaoMin(int duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    /**
     * Construtor que cria um filme com um título e duração especificados.
     *
     * @param titulo O título do filme.
     * @param duracaoMin A duração do filme em minutos.
     */
    public Filme(String titulo, int duracaoMin) {
        super(titulo);
        this.duracaoMin = duracaoMin;
    }

    /**
     * Retorna a duração do filme em minutos.
     *
     * @return A duração do filme em minutos.
     */
    @Override
    protected int getDuracao() {
        return duracaoMin;
    }
}
