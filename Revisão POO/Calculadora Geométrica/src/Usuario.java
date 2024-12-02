public class Usuario {
    private String login;
    private String senha;

    public Usuario ( String login , String senha ) {
        this.login = login;
        this.senha = senha;
    }

    public void setLogin(String login , String senha ) {
        if ( checkSenha( senha ) ) {
            this.login = login;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean checkSenha ( String senha ) {
        return this.senha.equals( senha );
    }
}
