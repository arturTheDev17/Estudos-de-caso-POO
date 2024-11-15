// Classe abstrata, já que no sistema não pode-se instanciar Usuarios, apenas suas subclasses.
public abstract class Usuario {

    //Atributos (encapsulados)
    private String nome;
    private String senha;

    @Override
    public String toString() {
        return  "\nUsuário " + getClass().getSimpleName() + "\n" +
                "Nome: " + nome + "\n";
    }

    // Construtor
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    //getter do nome
    public String getNome() {
        return nome;
    }

    // Método para verificar se as credenciais fornecidas correspondem às do usuário.
    public boolean login(String nome, String senha) {
        return (nome.equals(this.nome) && senha.equals(this.senha));
    }

}