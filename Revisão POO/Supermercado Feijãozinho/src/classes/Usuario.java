package classes;

import classes.BancoSupermercado;

public abstract class Usuario {

    private String nomeUsuario;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String senha) {
        //criado uma variável de apoio para fazer as iterações
        String nomePivot = nomeUsuario;
        int codigo = 0;

        //enquanto o nome de usuário existir dentre os usuários registrados, ele busca um novo nome vago.
        while ( nomePivot.equals( BancoSupermercado.buscaUsuario( nomePivot ).getNomeUsuario() ) ) {
            nomePivot = nomeUsuario;
            codigo++;
            nomePivot += codigo;
        }

        //verifica se há necessidade de incrementar o nome
        if ( nomePivot.equals( nomeUsuario ) ) {
            this.nomeUsuario = nomeUsuario;
        } else {
            this.nomeUsuario = nomePivot;
        }
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String login( String nomeUsuario , String senha ) {
        if ( nomeUsuario.equals(this.nomeUsuario) && senha.equals(this.senha) ) {
            return senha;
        } else
            return null;
    }

    @Override
    public String toString() {
        return  "\n Nome de usuário : " + nomeUsuario +
                "\n Sua senha : " + senha;
    }
}
