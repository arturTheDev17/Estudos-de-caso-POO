public class Lanche extends Produto {

    private double peso; //peso do lanche em kg.

    public Lanche(String descricao, double preco, double peso) {
        super(descricao, preco);
        this.peso = peso;
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
                "\nPeso (Kg): " + this.peso;
    }
}