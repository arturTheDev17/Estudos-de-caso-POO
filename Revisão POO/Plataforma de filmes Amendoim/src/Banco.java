import java.util.ArrayList;

/**
 * Classe Banco que gerencia usuários e vídeos.
 */
public class Banco {
    //ArrayLists que servem como um "banco de dados" de usuários e vídeos
    private static final ArrayList<Usuario> USUARIOS = new ArrayList<>();
    private static final ArrayList<Video> VIDEOS = new ArrayList<>();

    /**
     * Adiciona um usuário à lista de usuários.
     *
     * @param usuario O usuário a ser adicionado.
     */
    private static void addUsuario(Usuario usuario) {
        USUARIOS.add(usuario);
    }

    /**
     * Remove um vídeo da lista de vídeos.
     *
     * @param video O vídeo a ser removido.
     */
    public static void removerVideo(Video video) {
        VIDEOS.remove(video);
    }

    public static boolean removerUsuario(Usuario usuario) {
        return USUARIOS.remove(usuario);
    }

    /**
     * Adiciona um vídeo à lista de vídeos.
     *
     * @param video O vídeo a ser adicionado.
     */
    private static void addVideo(Video video) {
        VIDEOS.add(video);
    }

    /**
     * Cria um usuário cliente e o adiciona à lista de usuários.
     *
     * @param nome  O nome do cliente.
     * @param senha A senha do cliente.
     */
    public static void criarCliente(String nome, String senha) {
        Cliente c = new Cliente(nome, senha);
        addUsuario(c);
    }

    /**
     * Cria um administrador e o adiciona à lista de usuários.
     *
     * @param nome  O nome do administrador.
     * @param senha A senha do administrador.
     */
    public static void criarAdmin(String nome, String senha) {
        Admin a = new Admin(nome, senha);
        addUsuario(a);
    }

    /**
     * Cria um filme e o adiciona à lista de vídeos.
     *
     * @param titulo       O título do filme.
     * @param duracaoMin  A duração do filme em minutos.
     */
    public static void criarFilme(String titulo, int duracaoMin) {
        Filme f = new Filme(titulo, duracaoMin);
        addVideo(f);
    }

    public static void editarVideo( Video video , String titulo, int duracaoMin) {
        if ( video instanceof Filme filme ) {
            filme.setTitulo( titulo );
            filme.setDuracaoMin( duracaoMin );
        }
    }

    public static void editarVideo( Video video ,String titulo) {
        if ( video instanceof Serie serie ) {
            serie.setTitulo(titulo);
        }
    }

    /**
     * Cria uma série e a adiciona à lista de vídeos.
     *
     * @param titulo O título da série.
     */
    public static void criarSerie(String titulo) {
        Serie s = new Serie(titulo);
        addVideo(s);
    }

    /**
     * Busca um usuário pelo nome.
     *
     * @param nome O nome do usuário a ser buscado.
     * @return true se o usuário for encontrado, false caso contrário.
     */
    public static boolean buscarUsuario(String nome) {
        for (Usuario usuario : USUARIOS) {
            if (usuario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca um usuário pelo nome e senha.
     *
     * @param nome  O nome do usuário a ser buscado.
     * @param senha A senha do usuário a ser buscado.
     * @return O usuário encontrado ou null se não for encontrado.
     */
    public static Usuario buscarUsuario(String nome, String senha) {
        for (Usuario usuario : USUARIOS) {
            if (usuario.login(nome, senha)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Busca um vídeo (filme/série) pelo título.
     *
     * @param nome O título do vídeo a ser buscado.
     * @return O vídeo encontrado ou null se não for encontrado.
     */
    public static Video buscarVideo(String nome) {
        for (Video video : VIDEOS) {
            if (video.getTitulo().equalsIgnoreCase(nome)) {
                return video;
            }
        }
        return null;
    }

    /**
     * Busca um vídeo pelo código.
     *
     * @param id O código do vídeo a ser buscado.
     * @return O vídeo encontrado ou null se não for encontrado.
     */
    public static Video buscarVideo(int id) {
        for (Video video : VIDEOS) {
            if (video.getCodigo() == id) {
                return video;
            }
        }
        return null;
    }

    /**
     *
     * @return String de usuários
     */
    public static String verUsuarios() {
        StringBuilder usuarios = new StringBuilder();
        for (Usuario usuario : USUARIOS) {
            usuarios.append(usuario);
        }
        return usuarios.toString();
    }

    /**
     *
     * @return String de usuários
     */
    public static String verAdmins() {
        StringBuilder usuarios = new StringBuilder();
        for (Usuario usuario : USUARIOS) {
            if ( usuario instanceof Admin ) {
                usuarios.append(usuario);
            }
        }
        return usuarios.toString();
    }

    /**
     * Lista todos os vídeos.
     *
     * @return Uma string com todos os vídeos.
     */
    public static String verVideos() {
        StringBuilder videos = new StringBuilder();
        for (Video video : VIDEOS) {
            videos.append(video);
        }
        return videos.toString();
    }

    /**
     * Lista apenas os filmes.
     *
     * @return Uma string com todos os filmes.
     */
    public static String verFilmes() {
        StringBuilder videos = new StringBuilder();
        for (Video video : VIDEOS) {
            if (video instanceof Filme) {
                videos.append(video);
            }
        }
        return videos.toString();
    }

    /**
     * Lista apenas as séries.
     *
     * @return Uma string com todas as séries.
     */
    public static String verSeries() {
        StringBuilder videos = new StringBuilder();
        for (Video video : VIDEOS) {
            if (video instanceof Serie) {
                videos.append(video);
            }
        }
        return videos.toString();
    }
}
