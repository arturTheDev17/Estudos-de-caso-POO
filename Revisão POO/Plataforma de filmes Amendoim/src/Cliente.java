import java.util.ArrayList;

/**
 * Classe Cliente que representa um usuário do tipo cliente, permitindo
 * a adição e remoção de vídeos favoritos.
 */
public class Cliente extends Usuario {
    //Lista de vídeos favoritos do cliente (encapsulado)
    private ArrayList<Video> FAVORITOS = new ArrayList<>();

    /**
     * Construtor da classe Cliente.
     *
     * @param nome  O nome do cliente.
     * @param senha A senha do cliente.
     */
    public Cliente(String nome, String senha) {
        super(nome, senha); // Chama o construtor da classe pai (Usuario)
    }

    /**
     * Adiciona um vídeo à lista de favoritos do cliente.
     *
     * @param video O vídeo a ser adicionado aos favoritos.
     */
    public boolean addFavorito(Video video) {
        if (!FAVORITOS.contains(video)) {
            // Adiciona apenas se o vídeo não estiver na lista
            return FAVORITOS.add(video);
        } else {
            return false;
        }
    }

    /**
     * Remove um vídeo da lista de favoritos do cliente.
     *
     * @param video O vídeo a ser removido dos favoritos.
     * @return
     */
    public boolean removeFavorito(Video video) {
            return FAVORITOS.remove(video);
    }

    /**
     * Retorna uma string com todos os vídeos favoritos do cliente.
     *
     * @return Uma string contendo a lista de vídeos favoritos.
     */
    public String verFavoritos() {
        StringBuilder favoritos = new StringBuilder();
        for (Video favorito : FAVORITOS) {
            favoritos.append(favorito); // Adiciona cada favorito à string
        }
        return favoritos.toString(); // Retorna a lista de favoritos
    }

    /**
     * Busca um vídeo favorito pelo código.
     *
     * @param id O código do vídeo a ser buscado.
     * @return A string representando o vídeo favorito encontrado ou uma string vazia se não for encontrado.
     */
    public String buscarFavorito(int id) {
        for (Video video : FAVORITOS) {
            if (video.getCodigo() == id) {
                return video.toString(); // Retorna a representação do vídeo favorito
            }
        }
        return ""; // Retorna string vazia se o vídeo não for encontrado
    }
}
