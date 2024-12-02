public class Bebida extends Produto {

    private double volume; //volume da bebida em litros.

    public Bebida(String descricao, double preco, double volume) {
        super(descricao, preco);
        this.volume = volume;
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
                "\nVolume (L): " + this.volume;
    }

}