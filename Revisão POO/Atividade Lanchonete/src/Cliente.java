import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
    }

    public void fazerPedido(Pedido pedido) {
        pedidos.add( pedido );
    }
    public void cancelarPedido(Pedido pedido) {
        pedidos.remove( pedido );
    }
    public String visualizarPedidos() {
        String todosPedidos = "";
        for ( Pedido pedido : pedidos ) {
            todosPedidos += pedido.getCodigoPedido() + pedido.getStatus();
        }
        return todosPedidos;
    }


}