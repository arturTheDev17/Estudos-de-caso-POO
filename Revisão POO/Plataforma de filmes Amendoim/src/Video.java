/**
 * Classe abstrata que representa um vídeo, com um código e um título.
 */
public abstract class Video {
    private static int geradorCodigo = 1;
    private int codigo;
    private String titulo;

    /**
     * Construtor que inicializa um vídeo com um título.
     *
     * @param titulo O título do vídeo.
     */
    public Video(String titulo) {
        codigo = geradorCodigo;
        geradorCodigo++;
        this.titulo = titulo;
    }

    /**
     * Retorna o código único do vídeo.
     *
     * @return O código do vídeo.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o título do vídeo.
     *
     * @return O título do vídeo.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define o título do vídeo.
     *
     * @param titulo O novo título do vídeo.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método abstrato que deve ser implementado por subclasses para retornar a duração do vídeo.
     *
     * @return A duração do vídeo em minutos.
     */
    protected abstract int getDuracao();

    /**
     * Retorna uma representação em string do vídeo, incluindo seu código, título e duração.
     *
     * @return A representação em string do vídeo.
     */
    @Override
    public String toString() {
        return "\n" + codigo + ". " + titulo.toUpperCase() + "\n" + "Duração: " + getDuracao() + " min." + "\n";
    }
}
