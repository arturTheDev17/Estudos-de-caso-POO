import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe que representa uma série de vídeos, estendendo a classe Video.
 */
public class Serie extends Video {
    private final ArrayList<Episodio> EPISODIOS = new ArrayList<>();

    /**
     * Construtor que cria uma série com um título especificado.
     *
     * @param titulo O título da série.
     */
    public Serie(String titulo) {
        super(titulo);
    }

    /**
     * Adiciona um episódio à série.
     *
     * @param nome O nome do episódio.
     * @param duracao A duração do episódio em minutos.
     * @param temporada O número da temporada do episódio.
     * @return true se o episódio foi adicionado com sucesso, false caso contrário.
     */
    public boolean addEpisodio(String nome, int duracao, int temporada) {
        return EPISODIOS.add(new Episodio(nome, duracao, temporada));
    }

    /**
     * Remove um episódio da série pelo nome.
     *
     * @param nome O nome do episódio a ser removido.
     * @return true se o episódio foi removido com sucesso, false caso contrário.
     */
    public boolean removeEpisodio(String nome) {
        return EPISODIOS.remove(buscarEpisodio(nome));
    }

    /**
     * Busca um episódio pelo índice e retorna seu título.
     *
     * @param id O índice do episódio na lista.
     * @return O título do episódio correspondente ou uma string vazia se não encontrado.
     */
    public String buscarEpisodio(int id) {
        for (int i = 0; i < EPISODIOS.size(); i++) {
            if (i == id) {
                return EPISODIOS.get(i).getTitulo();
            }
        }
        return "";
    }

    /**
     * Busca um episódio pelo nome.
     *
     * @param nome O nome do episódio a ser buscado.
     * @return O objeto Episodio correspondente ou null se não encontrado.
     */
    public Episodio buscarEpisodio(String nome) {
        for (Episodio episodio : EPISODIOS) {
            if (episodio.getTitulo().equals(nome)) {
                return episodio;
            }
        }
        return null;
    }

    /**
     * Retorna uma string com todos os episódios da série, ordenados por temporada.
     *
     * @return A lista de episódios como string.
     */
    public String verEpisodios() {
        StringBuilder episodios = new StringBuilder();
        EPISODIOS.sort(Comparator.comparingInt(Episodio::getTemporada));
        for (Episodio episodio : EPISODIOS) {
            episodios.append(episodio);
        }
        return episodios.toString();
    }

    /**
     * Retorna uma string com os episódios de uma temporada específica.
     *
     * @param temporada O número da temporada desejada.
     * @return A lista de episódios da temporada como string.
     */
    public String verEpisodios(int temporada) {
        StringBuilder episodios = new StringBuilder();
        for (Episodio episodio : EPISODIOS) {
            if (episodio.getTemporada() == temporada) {
                episodios.append(episodio);
            }
        }
        return episodios.toString();
    }

    /**
     * Retorna a duração total da série somando as durações de todos os episódios.
     *
     * @return A duração total da série em minutos.
     */
    protected int getDuracao() {
        int duracao = 0;
        for (Episodio episodio : EPISODIOS) {
            duracao += episodio.getDuracaoMin();
        }
        return duracao;
    }
}
