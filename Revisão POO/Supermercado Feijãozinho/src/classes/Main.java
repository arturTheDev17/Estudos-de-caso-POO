package classes;

import classes.usuarios.Administrador;
import classes.usuarios.Cliente;

public class Main {

    public static Usuario login(String login, String senha) {
        return BancoSupermercado.login( login , senha );
    }

    public static String cadastro ( String nomeUsuario , String senha , boolean tipo ) {

        Usuario usuario;

        if ( !tipo ) {
            usuario = new Cliente( nomeUsuario , senha );
        } else {
            usuario = new Administrador( nomeUsuario , senha );
        }

        BancoSupermercado.addUsuario( usuario );
        return usuario.getNomeUsuario();
    }
}