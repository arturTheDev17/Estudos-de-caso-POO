package classes.usuarios;

import classes.Produto;
import classes.Usuario;

import java.util.HashMap;

public class Cliente extends Usuario {

    private final HashMap<Produto , Integer> CARRINHO = new HashMap<>();

    public Cliente(String nomeUsuario, String senha) {
        super(nomeUsuario, senha);
    }

    public Cliente() {
        super();
    }

    public void adicionarProdutoCarrinho( Produto produto , int quantidade ) {

        if ( CARRINHO.containsKey( produto ) ) {
            CARRINHO.put( produto , ( quantidade + CARRINHO.get( produto )) );
        } else {
            CARRINHO.put( produto , quantidade );
        }
    }
    public void removerProdutoCarrinho( Produto produto ) {
        CARRINHO.remove( produto );
    }

    public float calcularTotal( ){
        float total = 0;
        for ( Produto produto : CARRINHO.keySet() ) {
            total += ( CARRINHO.get(produto) * produto.getPreco() );
        }
        return total;
    }

    public String mostrarCarrinho() {
        String itens = "";
        if ( CARRINHO.isEmpty() ) {
            itens = "Não há itens no carrinho";
        } else {
            for (Produto produto : CARRINHO.keySet()) {
                itens += produto.toString();
            }
        }
        return itens;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Tipo de usuário: Cliente";
    }
}
