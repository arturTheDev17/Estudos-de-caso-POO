import java.util.ArrayList;

public class GerenciadorDeCardapio {
    private static ArrayList<Produto> cardapio = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        cardapio.add( produto );
    }
    public void removerProduto(int codigo) {
        cardapio.remove( codigo );
    }
    public void editarProduto(int codigo, Produto novoProduto) {
        cardapio.set( codigo , novoProduto );
    }
    public ArrayList<Produto> listarProdutos() {
        return cardapio;
    }
    public static ArrayList<Produto> getCardapio() {
        return cardapio;
    }
}