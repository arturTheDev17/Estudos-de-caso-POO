package classes;

public abstract class Produto {

    private static int geradorCodigo = 0;
    private int codigo;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.codigo = geradorCodigo;
        geradorCodigo++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "\nCódigo do produto: " + codigo +
                "\nCategoria: " + getClass().getSimpleName() +
                "\nNome do produto: " + nome +
                "\nPreço: " + "R$ " + String.format( "%.2f" , preco ) + "\n";
    }
}
