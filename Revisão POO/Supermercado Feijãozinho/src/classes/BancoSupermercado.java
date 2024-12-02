package classes;

import classes.usuarios.Cliente;

import javax.swing.plaf.ProgressBarUI;
import java.util.ArrayList;

public class BancoSupermercado {
    private static final ArrayList<Produto> PRODUTOS = new ArrayList<>();
    private static final ArrayList<Usuario> USERS = new ArrayList<>();

    public static void addProduto( Produto produto ) {
        PRODUTOS.add( produto );
    }

    public static void removeProduto( int id ) {
        PRODUTOS.remove( id );
    }

    public static Produto buscaProduto( String nome ) {

        for ( Produto produto : PRODUTOS ) {
            if ( produto.getNome().equals(nome) ) {
                return produto;
            }
        }
        return null;
    }

    public static void setProduto(Produto produto , int id) {
        PRODUTOS.set( id , produto );
    }

    public static void addUsuario( Usuario usuario ) {
        USERS.add( usuario );
    }

    public static void removeUsuario( int id ) {
        USERS.remove( id );
    }

    public static Usuario buscaUsuario( String nomeUsuario ) {
        for ( Usuario usuario : USERS ) {
            if ( usuario.getNomeUsuario().equals(nomeUsuario) ) {
                return usuario;
            }
        }
        return new Cliente( );
    }

    public static void setUsuario(Usuario usuario , int id) {
        USERS.set( id , usuario );
    }

    public static Usuario login( String nomeUsuario , String senha ) {
        Usuario user = buscaUsuario( nomeUsuario );
        if (user.login(nomeUsuario, senha) != null) {
            return user;
        }

        return new Cliente();
    }

    public static String getUsers() {
        String usuarios = "";
        for ( Usuario usuario : USERS ) {
            usuarios += usuario + "\n";
        }
        return usuarios;
    }

    public static String mostraCategoria(String categoria) {
        String produtos = "";
        int contador = 0;
        for ( Produto produto : PRODUTOS ) {
            if ( produto.getClass().getSimpleName().equals( categoria ) || categoria.equals( "tudo" ) ){
                contador++;
                produtos += produto;
            }
        }
        if ( contador == 0 ) {
            produtos = "Não há produtos nesta categoria.";
        }
        return produtos;
    }
}
