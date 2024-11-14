public abstract class Usuario {

    private long cpf;
    private String nome;

    public Usuario(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
