public class Outro extends Produto {

    private String tamanho; //tamanho do item (por exemplo, "Pequeno", "Médio", "Grande").

    public Outro(String descricao, double preco, String tamanho) {
        super(descricao, preco);
        this.tamanho = tamanho;
    }

    @Override
    public double calcularPreco(double desconto) {
        return getPreco();
    }

    @Override
    public String exibirDetalhes() {
        return  "-- Lanche --" +
                "\nDescrição: " + getDescricao() +
                "\nPreço: " + getPreco() +
                "\nTamanho: " + this.tamanho;
    }
}