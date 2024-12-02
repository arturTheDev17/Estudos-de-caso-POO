import java.util.ArrayList;

public class Combo extends Produto {

    private double desconto;
    private ArrayList<Produto> produtos;

    public Combo(String descricao, double desconto , ArrayList<Produto> produtos ) {
        super(descricao);
        this.desconto = desconto;
        this.produtos = produtos;
        this.setPreco(this.calcularDesconto());
    }

    public double calcularDesconto() {
        return  calcularPreco(0) - calcularPreco( 0 ) * ( this.desconto  / 100 );
    }

    @Override
    public double calcularPreco(double desconto) {
        //achar um jeito de nao estragar o valor
        double precoTotal = 0;
        for ( Produto produto : produtos ) {
            precoTotal += produto.getPreco();
        }
        return precoTotal;
    }

    @Override
    public String exibirDetalhes() {
        String detalhes =   "-- Lanche --" +
                            "\nDescrição: " + getDescricao() +
                            "\nPreço: " + getPreco() +
                            "\nDesconto: " + ((int)this.desconto) + "%" +
                            "\nItens: ";
        ;
        for ( Produto produto : produtos ) {
            detalhes += "\n" + produto.getDescricao();
        }
        return detalhes;
    }

}