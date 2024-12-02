package classes;

import classes.categorias.*;
import classes.usuarios.Administrador;
import classes.usuarios.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Exec extends Main {

        private static final Scanner sc = new Scanner( System.in );
        private static Cliente cliente;
        private static Administrador administrador;
        private static Usuario usuario = new Cliente();

    public static void main(String[] args) {

        BancoSupermercado.addUsuario( new Administrador( "admin" , "123" ) );
        BancoSupermercado.addUsuario( new Cliente( "asdf" , "123" ) );
        BancoSupermercado.addProduto( new Alimento( "Carne" , 15f ) );
        BancoSupermercado.addProduto( new Bebida("Leite", 10f));
        BancoSupermercado.addProduto( new Higiene("Sabonete", 5f));
        BancoSupermercado.addProduto( new Limpeza("Amaciante", 20f));
        BancoSupermercado.addProduto( new Pets("Gato", 200f));
        BancoSupermercado.addProduto( new Roupa( "camisa polo" , 38.5f ) );

        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│                       BEM VINDO AO                         │");
        System.out.println("│                 SUPERMERCADO FEIJÃOZINHO !                 │");
        System.out.println("└────────────────────────────────────────────────────────────┘");

        while (true) {

            if ( usuario.getNomeUsuario() == null ) {
                usuario = escolhasInicial( );
            } else if ( usuario instanceof Cliente ) {
                cliente = (Cliente) usuario;
                escolhasLogadoCliente();
            } else if ( usuario instanceof Administrador ) {
                administrador = (Administrador)usuario;
                escolhasLogadoAdm();
            }

        }

    }

    private static Usuario escolhasInicial( ){

        System.out.println( "\uD83C\uDF31 SUPERMERCADO FEIJÃOZINHO \uD83C\uDF31" );
        System.out.println("1. Login.");
        System.out.println("2. Cadastro.");
        System.out.println("0. Sair.");
        int escolhaMenuInicial = (int)tryDouble();

        if ( escolhaMenuInicial == 0 ) {
            System.out.println("Saindo...");
            System.exit(0);

        } else if ( escolhaMenuInicial == 1 ) {

            System.out.println("Insira o nome do seu usuário:");
            String nomeLogin = tryRegexString(0);

            System.out.println("Insira a senha do usuário:");
            String senhaLogin = sc.next();

            Usuario user = login(nomeLogin, senhaLogin);

            if ( user.getNomeUsuario() == null ) {
                System.out.println( "Esse usuário não está registrado!!" );
            } else  {
                return login(nomeLogin, senhaLogin);
            }

        } else if ( escolhaMenuInicial == 2 ) {
            cadastrarUsuario( false );
        }

        else {

            System.out.println("Opção inválida ou inexistente.");

        }
        return new Cliente(  );
    }

    public static boolean tiposDeLogin() {
        System.out.println("Escolha a opção de usuário:");
        System.out.println("1.Administrador;");
        System.out.println("2.Usuário;");
        int opcaoDesejada = (int)tryDouble();

        return opcaoDesejada == 1;
    }

    private static void cabecalhoLogadoCliente() {
        System.out.println( "\n\uD83C\uDF31 Usuário: " + cliente.getNomeUsuario() +" \uD83C\uDF31" );
    }

    private static void cabecalhoLogadoAdm () {
        System.out.println(( "\n\uD83C\uDF31 Administrador: " + administrador.getNomeUsuario()) +"\uD83C\uDF31");
    }

    private static void escolhasLogadoCliente () {
        cabecalhoLogadoCliente();
        System.out.println("1. Ver Itens do mercado por categoria.");
        System.out.println("2. Entrar no carrinho \uD83D\uDED2");
        System.out.println("3. Finalizar compra ✅");
        System.out.println("0. Sair da conta ⬅️");
        int escolhaMenuCliente = (int)tryDouble();

        switch ( escolhaMenuCliente ) {
            case 1 : {

                cabecalhoLogadoCliente();
                System.out.println( "ESCOLHA A CATEGORIA: " );
                System.out.println( "1. Alimentos." );
                System.out.println( "2. Bebidas." );
                System.out.println( "3. Higiene." );
                System.out.println( "4. Produtos de limpeza." );
                System.out.println( "5. Itens para pets." );
                System.out.println( "6. Vestuário." );
                int categoria = (int)tryDouble();
                System.out.println( BancoSupermercado.mostraCategoria( mostraCategoria( categoria ) ) );

            } break;

            case 2 : {
                cabecalhoLogadoCliente();
                carrinho();
            } break;

            case 3 : {
                calcularTotal();
            } break;
            case 0 : {
                usuario = new Cliente();
            }
        }
    }

    private static void escolhasLogadoAdm () {
        cabecalhoLogadoAdm();
        System.out.println("1. Cadastrar um produto novo.");
        System.out.println("2. Ver produtos cadastrados.");
        System.out.println("3. Remover um produto.");
        System.out.println("4. Ver usuários cadastrados.");
        System.out.println("5. Cadastrar um usuário.");
        System.out.println("0. Logout.");
        int escolha = (int)tryDouble();

        switch ( escolha ) {
            case 1 : {
                cadastrarProduto();
            } break;

            case 2 : {
                System.out.println( BancoSupermercado.mostraCategoria( "tudo" ) );
            } break;

            case 3 : {
                System.out.println( BancoSupermercado.mostraCategoria( "tudo" ) );
                removerProduto();
            } break;

            case 4 : {
                System.out.println( BancoSupermercado.getUsers() );
            } break;

            case 5 : {
                cadastrarUsuario( true );
            } break;

            case 0 : {
                usuario = new Administrador();
            }

            default : {
                System.out.println( "O valor inserido é inválido." );
            }
        }

    }

    private static void cadastrarProduto () {

        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println("Insira a categoria do produto:");
            for (int i = 1; i <= 6; i++) {
                System.out.println(i + " - " + mostraCategoria(i));
            }

            int categoria = (int) tryDouble();

            if (categoria < 1 || categoria > 6) {
                System.out.println("Categoria inválida! Tente novamente.");
                continue;
            }

            System.out.println("Insira o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.println("Insira o preço do produto:");
            double precoProduto = scanner.nextDouble();
            scanner.nextLine();

            switch (categoria) {
                case 1: {
                    BancoSupermercado.addProduto(new Alimento(nomeProduto, precoProduto));
                    System.out.println("Alimento adicionado com sucesso.");
                }
                break;

                case 2: {
                    BancoSupermercado.addProduto(new Bebida(nomeProduto, precoProduto));
                    System.out.println("Bebida adicionada com sucesso.");
                }
                break;

                case 3: {
                    BancoSupermercado.addProduto(new Higiene(nomeProduto, precoProduto));
                    System.out.println("Produto de higiene adicionado com sucesso.");
                }
                break;

                case 4: {
                    BancoSupermercado.addProduto(new Limpeza(nomeProduto, precoProduto));
                    System.out.println("Produto de limpeza adicionado com sucesso.");
                }
                break;

                case 5: {
                    BancoSupermercado.addProduto(new Pets(nomeProduto, precoProduto));
                    System.out.println("Produto para pets adicionado com sucesso.");
                }
                break;

                case 6: {
                    BancoSupermercado.addProduto(new Roupa(nomeProduto, precoProduto));
                    System.out.println("Roupa adicionada com sucesso.");
                }

                break;

            }

            System.out.println("Deseja adicionar outro produto? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;

            }
        }
    }

    private static void cadastrarUsuario( boolean tipo ) {
        boolean adm = false;

        if ( tipo ) {
            adm = tiposDeLogin( );
        }
        System.out.println("Insira o nome do seu usuário:");
        String nomeLogin = tryRegexString(0);

        System.out.println("Insira a senha do usuário:");
        String senhaLogin = sc.next();

        if ( adm ) {
            nomeLogin = cadastro(nomeLogin, senhaLogin, true);
        } else {
            nomeLogin = cadastro(nomeLogin, senhaLogin, false);
        }

        System.out.println("Usuário cadastrado como: " + nomeLogin);
    }

    private static void carrinho() {
        int escolhaCarrinho;
        do {
            System.out.println( "CARRINHO DE " + cliente.getNomeUsuario() );
            System.out.println( "1. Adicionar produto. ➕" );
            System.out.println( "2. Remover produto. ➖" );
            System.out.println( "3. Listar itens. \uD83D\uDCDD" );
            System.out.println( "4. Finalizar compra. ✅" );
            System.out.println( "0. Sair do carrinho. ⬅️" );
            escolhaCarrinho = (int)tryDouble();

            switch ( escolhaCarrinho ) {
                case 1 : {
                    Produto produto = buscaProduto();
                    System.out.println( "Insira a quantidade de unidades deste produto que quer adicionar: " );
                    int quantidade;
                    do {
                        quantidade = (int) tryDouble();
                        if ( quantidade < 1 ) {
                            System.out.println( "Insira uma quantidade válida." );
                        }
                    } while ( quantidade < 1 );
                    cliente.adicionarProdutoCarrinho( produto , quantidade );
                } break;
                case 2 : {
                    Produto produto = buscaProduto();
                    System.out.println( "Tem certeza? Digite 1 para sim." );
                    if ( (int)tryDouble() == 1 ) {
                        cliente.removerProdutoCarrinho( produto );
                    }
                } break;

                case 3 : {
                    System.out.println( cliente.mostrarCarrinho() );
                } break;
                case 4 : {
                    calcularTotal();
                } break;
            }
        } while ( escolhaCarrinho != 0 );
    }

    private static void removerProduto( ) {
        BancoSupermercado.removeProduto( buscaProduto( ).getCodigo() );
    }

    private static void calcularTotal() {
        System.out.println( "Tem certeza? Digite 1 para sim." );
        if ( (int)tryDouble() == 1 ) {
            System.out.println( "TOTAL: R$ " + cliente.calcularTotal() );
        }
    }

    private static Produto buscaProduto() {

        System.out.println( "ESCOLHA A CATEGORIA QUE DESEJA ADICIONAR: " );
        System.out.println( "1. Alimentos." );
        System.out.println( "2. Bebidas." );
        System.out.println( "3. Higiene." );
        System.out.println( "4. Produtos de limpeza." );
        System.out.println( "5. Itens para pets." );
        System.out.println( "6. Vestuário." );
        int categoria = (int)tryDouble();
        System.out.println( BancoSupermercado.mostraCategoria( mostraCategoria( categoria ) ) );

        System.out.println( "Insira o nome do produto: " );
        Produto produto;

        do {
            produto = BancoSupermercado.buscaProduto(tryRegexString(1));
            if ( produto == null ) {
                System.out.println( "Produto inválido ou não encontrado, insira novamente." );
            }
        } while ( produto == null );

        return produto;
    }

    private static String mostraCategoria(int categoria) {
        if ( categoria == 1 ) {
            return Alimento.class.getSimpleName();
        } else if ( categoria == 2 ) {
            return Bebida.class.getSimpleName();
        } else if ( categoria == 3 ) {
            return Higiene.class.getSimpleName();
        } else if ( categoria == 4 ) {
            return Limpeza.class.getSimpleName();
        } else if ( categoria == 5 ) {
            return Pets.class.getSimpleName();
        } else if ( categoria == 6 ) {
            return Roupa.class.getSimpleName();
        }
        return null;
    }

    private static double tryDouble() {
        double valor = 0;
        boolean erro = true;
        while ( erro ) {
            try {
                valor = sc.nextDouble();
                erro = false;
            } catch ( InputMismatchException i ) {
                System.out.println( "Valor inválido. Insira novamente: " );
                sc.next();
            }
        }

        return valor;
    }

    private static String tryRegexString( int cod ) {
        boolean erro = true;
        String valor;
        sc.nextLine();
        do {
            valor = sc.nextLine();
            if (valor.matches("^(?=.*[A-Za-z])[A-Za-z0-9_]{3,}$" ) && cod == 0
                    || valor.matches( "^[a-zA-Z]+( [a-zA-Z]+)*$" ) && cod == 1 ) {
                erro = false;
            } else {
                System.out.println( "Erro. Digite novamente." );
            }
        } while ( erro );
        return valor;
    }
}
