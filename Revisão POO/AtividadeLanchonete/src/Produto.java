public abstract class Produto {

    private static int geradorCodigo = 0;
    //identificador único do produto.
    private int codigo;
    //descrição do produto.
    private String descricao;
    //preço do produto.
    private double preco;

    public Produto( String descricao ){
        this.codigo = geradorCodigo;
        geradorCodigo++;
        this.descricao = descricao;
    }

    public Produto(String descricao, double preco) {
        this.codigo = geradorCodigo;
        geradorCodigo++;
        this.descricao = descricao;
        this.preco = preco;
    }

    //calcula o preço do produto com desconto.
    public abstract double calcularPreco(double desconto);
    //exibe os detalhes do produto.
    public abstract String exibirDetalhes();

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
}