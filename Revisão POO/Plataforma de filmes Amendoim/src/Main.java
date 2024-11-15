import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que gerencia a interação do usuário com o sistema de
 * entretenimento audiovisual, permitindo login, cadastro e ações relacionadas a vídeos.
 */
public class Main {

    static Scanner sc = new Scanner(System.in); // Scanner para entrada de dados
    static Usuario logado; // Usuário atualmente logado

    /**
     * Exibe o cabeçalho de boas-vindas.
     */
    private static void cabecalho() {
        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│                       BEM VINDO AO                         │");
        System.out.println("│            AMENDOIM AUDIOVISUAL ENTERTAINMENT !            │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
    }

    /**
     * Lê um valor double do usuário, tratando exceções de entrada.
     *
     * @return O valor double lido.
     */
    private static double tryDouble() {
        double valor = 0;
        boolean erro = true;

        while (erro) {
            try {
                valor = sc.nextDouble(); // Tenta ler um double
                erro = false; // Sai do loop se a leitura for bem-sucedida
            } catch (InputMismatchException i) {
                System.out.println("Valor inválido. Insira novamente: ");
                sc.next(); // Limpa a entrada inválida
            }
        }

        return valor; // Retorna o valor lido
    }

    /**
     * Gerencia o processo de login ou cadastro do usuário.
     */
    private static void login() {
        System.out.println("• O que deseja fazer?");
        System.out.println("  1. Login\n  2. Cadastro\n  0. Sair");

        int escolha = (int) tryDouble(); // Lê a escolha do usuário

        if (escolha == 1) {
            sc.nextLine(); // Limpa o buffer
            System.out.println("Insira seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Insira sua senha: ");
            String senha = sc.nextLine();

            // Verifica se o usuário existe
            if (Banco.buscarUsuario(nome, senha) != null) {
                logado = Banco.buscarUsuario(nome, senha);
            } else {
                System.out.println("Dados inválidos ou usuário não cadastrado.");
            }

        } else if (escolha == 2) {
            sc.nextLine(); // Limpa o buffer
            cadastro(); // Chama o método de cadastro
        } else if (escolha == 0) {
            System.out.println( "SAINDO! Tchau..." );
            System.exit(0); // Encerra o programa
        } else {
            System.out.println("Escolha inválida...");
        }
    }

    /**
     * Lê e verifica se a senha inserida pelo usuário é válida.
     *
     * @return A senha válida.
     */
    private static String senha() {
        System.out.println("Insira sua senha: ");
        String senha = sc.nextLine();
        System.out.println("Confirme sua senha: ");
        String senhaConf = sc.nextLine();

        if (!(senha.equals(senhaConf))) {
            System.out.println("ERRO! Digite a mesma senha!");
            return senha(); // Chama recursivamente até a confirmação ser válida
        }
        return senha; // Retorna a senha válida
    }

    /**
     * Realiza o cadastro de um novo usuário.
     */
    private static void cadastro() {
        System.out.println("Insira o nome: ");
        String nome = sc.nextLine();

        // Verifica se o nome de usuário já existe
        if (Banco.buscarUsuario(nome)) {
            System.out.println("Esse nome de usuário já existe, insira outro.");
            cadastro(); // Chama recursivamente se o nome já existir
        } else {
            String senha = senha(); // Obtém a senha

            // Cria um novo cliente
            Banco.criarCliente(nome, senha);
        }
    }

    private static void cadastroAdmin() {
        System.out.println("Insira o nome do Administrador: ");
        String nome = sc.nextLine();

        // Verifica se o nome de usuário já existe
        if (Banco.buscarUsuario(nome)) {
            System.out.println("Esse nome de usuário já existe, insira outro.");
            cadastroAdmin(); // Chama recursivamente se o nome já existir
        } else {
            String senha = senha(); // Obtém a senha

            // Cria um novo cliente
            Banco.criarAdmin(nome, senha);
        }
    }

    /**
     * Método principal que inicia o programa.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        cabecalho(); // Exibe o cabeçalho

        // Dados iniciais para teste
        Banco.criarCliente("test", "123");
        Banco.criarAdmin("admin", "123");
        Banco.criarFilme("Truman's Show", 150);
        Banco.criarFilme("Interstellar", 200);
        Banco.criarSerie("Breaking Bad");

        // Adiciona episódios à série
        ((Serie) Banco.buscarVideo("Breaking Bad")).addEpisodio("Piloto", 50, 1);
        ((Serie) Banco.buscarVideo("Breaking Bad")).addEpisodio("Final", 70, 6);

        // Loop principal para ações do usuário
        while (true) {
            switch (logado) {
                case null -> login(); // Se não houver usuário logado, chama login
                case Cliente cliente -> acoes(); // Ações para clientes
                case Admin admin -> acoesAdmin(); // Ações para administradores
                default -> {
                }
            }
        }
    }

    /**
     * Gerencia as ações disponíveis para administradores.
     */
    public static void acoesAdmin() {
        cabecalho();
        System.out.println("1. Ver todos os filmes e séries.");
        System.out.println("2. Menu filmes.");
        System.out.println("3. Menu séries.");
        System.out.println("4. Menu usuários.");
        System.out.println("0. Sair da conta.");

        int escolha = (int) tryDouble(); // Lê a escolha do administrador
        switch (escolha) {
            case 1: {
                System.out.println("TODOS FILMES E SÉRIES DA PLATAFORMA: ");
                System.out.println(Banco.verVideos());
            }
            break;

            case 2: {
                do {
                    System.out.println("┌──────────────────────────┐");
                    System.out.println("│          FILMES          │");
                    System.out.println("└──────────────────────────┘");
                    System.out.println("1. Ver todos os filmes cadastrados.");
                    System.out.println("2. Adicionar um filme.");
                    System.out.println("3. Remover um filme.");
                    System.out.println("4. Editar um filme.");
                    System.out.println("0. Voltar.");

                    escolha = (int) tryDouble(); // Lê a escolha do administrador
                    switch (escolha) {
                        case 1: {
                            System.out.println("TODOS FILMES DA PLATAFORMA: ");
                            System.out.println(Banco.verFilmes());
                        }
                        break;

                        case 2: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verFilmes());
                            System.out.print("Digite o nome do filme que deseja adicionar: ");
                            String nome = sc.nextLine();
                            System.out.print("Digite a duração do filme que deseja adicionar: ");
                            int duracao = (int) tryDouble();
                            Banco.criarFilme(nome, duracao); // Cria um novo filme
                        }
                        break;

                        case 3: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verFilmes());
                            System.out.print("Digite o nome do filme que deseja editar: ");
                            String nome = sc.nextLine();
                            Video video = Banco.buscarVideo(nome);

                            // Verifica se o filme existe
                            if (video != null) {
                                System.out.print("Digite o novo nome do filme que está editando: ");
                                String nomeNovo = sc.nextLine();
                                System.out.print("Digite a nova duração do filme que está editando: ");
                                int duracao = (int) tryDouble();
                                Banco.editarVideo(video, nomeNovo, duracao);
                                sc.nextLine(); // Limpa o buffer
                            } else {
                                System.out.println("Filme não encontrado.");
                                break;
                            }
                        }
                    }
                } while (escolha != 0); // Retorna ao menu principal de filmes

            }
            break;

            case 3: {
                do {
                    System.out.println("┌──────────────────────────┐");
                    System.out.println("│          SÉRIES          │");
                    System.out.println("└──────────────────────────┘");
                    System.out.println("1. Ver todas as séries cadastradas.");
                    System.out.println("2. Ver episódios de uma série.");
                    System.out.println("3. Adicionar uma série.");
                    System.out.println("4. Adicionar episódios a uma série.");
                    System.out.println("5. Remover episódios de uma série.");
                    System.out.println("6. Remover uma série.");
                    System.out.println("7. Editar uma série.");
                    System.out.println("0. Voltar.");

                    escolha = (int) tryDouble(); // Lê a escolha do administrador
                    switch (escolha) {
                        case 1: {
                            System.out.println("TODAS SÉRIES DA PLATAFORMA: ");
                            System.out.println(Banco.verSeries());
                        }
                        break;

                        case 2: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println("TODAS SÉRIES DA PLATAFORMA: ");
                            System.out.println(Banco.verSeries());
                            System.out.println("Escolha uma série para ver os episódios:");
                            String nome = sc.nextLine();

                            // Verifica se a série existe
                            if (Banco.buscarVideo(nome) instanceof Serie serie) {
                                System.out.println(serie.verEpisodios());
                            }
                        }
                        break;

                        case 3: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verSeries());
                            System.out.print("Digite o nome da série que deseja adicionar: ");
                            String nome = sc.nextLine();
                            Banco.criarSerie(nome); // Cria uma nova série
                        }
                        break;

                        case 4: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verSeries());
                            System.out.print("Digite o nome da série que deseja modificar: ");
                            String nome = sc.nextLine();

                            // Verifica se a série existe
                            if (Banco.buscarVideo(nome) instanceof Serie serie) {
                                String continuar = "";

                                // Loop para adicionar episódios
                                while (continuar.isBlank()) {
                                    System.out.print("Digite o nome do episódio que deseja adicionar: ");
                                    String nomeEp = sc.nextLine();
                                    System.out.print("Digite a duração do episódio que deseja adicionar: ");
                                    int duracao = (int) tryDouble();
                                    System.out.print("Digite o número da temporada a qual o episódio pertence: ");
                                    int temporada = (int) tryDouble();
                                    if (serie.addEpisodio(nomeEp, duracao, temporada)) {
                                        System.out.println( "Adicionado com sucesso!" );
                                    } else {
                                        System.out.println( "Não existe!" );
                                    }
                                    serie.addEpisodio(nomeEp, duracao, temporada); // Adiciona o episódio

                                    sc.nextLine();
                                    System.out.println("Se deseja continuar, pressione enter, senão, digite alguma coisa.");
                                    continuar = sc.nextLine();
                                }

                            } else {
                                System.out.println("Série não encontrada.");
                            }
                        }
                        break;

                        case 5: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verSeries());
                            System.out.print("Digite o nome da série que deseja modificar: ");
                            String nome = sc.nextLine();

                            // Verifica se a série existe
                            if (Banco.buscarVideo(nome) instanceof Serie serie) {
                                String continuar = "";

                                if (serie.verEpisodios() != null ){
                                    // Loop para remover episódios
                                    while (continuar.isBlank()) {
                                        serie.verEpisodios();
                                        System.out.print("Digite o nome do episódio que deseja remover: ");
                                        String nomeEp = sc.nextLine();
                                        if (serie.removeEpisodio(nomeEp)) {
                                            System.out.println( "Removido com sucesso!" );
                                        } else {
                                            System.out.println( "Não existe!" );
                                        }
                                        System.out.println("Se deseja continuar, pressione enter, senão, digite alguma coisa.");
                                        continuar = sc.nextLine();
                                    }
                                } else {
                                    System.out.println( "Essa série não tem episódios." );
                                }

                            } else {
                                System.out.println("Série não encontrada.");
                            }
                        }
                        break;

                        case 6: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verSeries());
                            System.out.print("Digite o nome da série que deseja remover: ");
                            String nome = sc.nextLine();
                            Banco.removerVideo(Banco.buscarVideo(nome)); // Remove a série
                        }
                        break;

                        case 7: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verSeries());
                            System.out.print("Digite o nome da série que deseja editar: ");
                            String nome = sc.nextLine();
                            Video video = Banco.buscarVideo(nome);

                            // Verifica se a série existe
                            if (video != null) {
                                System.out.print("Digite o novo nome da série que está editando: ");
                                String nomeNovo = sc.nextLine();
                                Banco.editarVideo(video, nomeNovo);
                                sc.nextLine(); // Limpa o buffer
                            } else {
                                System.out.println("Série não encontrada.");
                                break;
                            }
                        }
                    }
                } while (escolha != 0); // Retorna ao menu principal de séries

            }
            break;

            case 4: {
                do {
                    System.out.println("┌──────────────────────────┐");
                    System.out.println("│         USUÁRIOS         │");
                    System.out.println("└──────────────────────────┘");
                    System.out.println("1. Ver todos usuários cadastrados.");
                    System.out.println("2. Adicionar um administrador.");
                    System.out.println("3. Remover um usuário.");
                    System.out.println("0. Voltar.");

                    escolha = (int) tryDouble(); // Lê a escolha do administrador
                    switch (escolha) {
                        case 1: {
                            System.out.println("TODOS USUÁRIOS");
                            System.out.println(Banco.verUsuarios());
                        }
                        break;

                        case 2: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println("TODOS ADMINS");
                            System.out.println(Banco.verAdmins());
                            cadastroAdmin();
                        }
                        break;

                        case 3: {
                            sc.nextLine(); // Limpa o buffer
                            System.out.println(Banco.verUsuarios());
                            System.out.println( "OBS: Se o usuário excluído for este logado, ele será removido ao sair da conta." );
                            System.out.print("Digite o nome do usuário que deseja remover: ");
                            String nome = sc.nextLine();
                            System.out.print("Digite a senha do usuário que deseja remover: ");
                            String senha = sc.nextLine();
                            if (Banco.removerUsuario(Banco.buscarUsuario(nome , senha))){
                                System.out.println( "USUÁRIO REMOVIDO" );
                            } else {
                                System.out.println( "USUÁRIO INVÁLIDO" );
                            }
                        }
                        break;
                    }
                } while (escolha != 0); // Retorna ao menu principal de séries

            }
            break;


            case 0: {
                logado = null; // Desloga o usuário
            }
            break;

            default: {
                System.out.println("Valor inválido! ");
            }
            break;
        }
    }

    /**
     * Gerencia as ações disponíveis para clientes.
     */
    public static void acoes() {
        cabecalho();
        System.out.println("1. Ver todos os filmes e séries.");
        System.out.println("2. Ver todos os filmes.");
        System.out.println("3. Ver todas as séries.");
        System.out.println("4. Ver episódios de uma série.");
        System.out.println("--------------------------------");
        System.out.println("5. Adicionar aos favoritos.");
        System.out.println("6. Remover dos favoritos.");
        System.out.println("7. Ver meus favoritos.");
        System.out.println("--------------------------------");
        System.out.println("0. Sair da conta.");

        int escolha = (int) tryDouble(); // Lê a escolha do cliente
        switch (escolha) {
            case 1: {
                System.out.println("TODOS FILMES E SÉRIES DA PLATAFORMA: ");
                System.out.println(Banco.verVideos());
            }
            break;

            case 2: {
                System.out.println("TODOS FILMES DA PLATAFORMA: ");
                System.out.println(Banco.verFilmes());
            }
            break;

            case 3: {
                System.out.println("TODAS SÉRIES DA PLATAFORMA: ");
                System.out.println(Banco.verSeries());
            }
            break;

            case 4: {
                sc.nextLine(); // Limpa o buffer
                System.out.println("TODAS SÉRIES DA PLATAFORMA: ");
                System.out.println(Banco.verSeries());
                System.out.println("Insira o nome de uma série para ver os episódios:");
                String nome = sc.nextLine();

                // Verifica se a série existe
                if (Banco.buscarVideo(nome) instanceof Serie serie) {
                    System.out.println( "EPISÓDIOS:" );
                    System.out.println(serie.verEpisodios());
                } else {
                    System.out.println( "Insira uma série válida!" );
                }
            }
            break;

            case 5: {
                sc.nextLine(); // Limpa o buffer
                System.out.println(Banco.verVideos());
                System.out.println( "Insira o nome de um filme/série para adicionar aos favoritos: " );
                if (((Cliente) logado).addFavorito(Banco.buscarVideo(sc.nextLine()))){
                    System.out.println( "Adicionado com sucesso!" );
                } else {
                    System.out.println( "Não existe ou já foi adicionado!!" );
                }
            }
            break;

            case 6: {
                if ( !((Cliente) logado).verFavoritos().isBlank() ) {
                    sc.nextLine(); // Limpa o buffer
                    System.out.println(((Cliente) logado).verFavoritos());
                    System.out.println( "Insira o nome de um de seus filmes/séries favoritos para removê-los: " );
                    if (((Cliente) logado).removeFavorito(Banco.buscarVideo(sc.nextLine()))){
                        System.out.println( "Removido com sucesso!" );
                    } else {
                        System.out.println( "Não é um favorito!!" );
                    }
                } else {
                    System.out.println( "NÃO HÁ FAVORITOS CADASTRADOS." );
                }
            }
            break;

            case 7: {
                if ( !((Cliente) logado).verFavoritos().isBlank() ) {
                    System.out.println( "FAVORITOS DE " + logado.getNome().toUpperCase() );
                    System.out.println(((Cliente) logado).verFavoritos()); // Exibe os favoritos
                } else {
                    System.out.println( "NÃO HÁ FAVORITOS CADASTRADOS." );
                }
            }
            break;

            case 0: {
                System.out.println( "Saindo..." );
                logado = null; // Desloga o usuário
            }
            break;

            default: {
                System.out.println("Valor inválido! ");
            }
            break;
        }
    }
}