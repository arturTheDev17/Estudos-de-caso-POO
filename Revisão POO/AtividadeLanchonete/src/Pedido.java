import  java.util.ArrayList;
public class Pedido {

    private static int geradorCodigo = 0;
    private int codigoPedido;
    private Cliente cliente;
    private ArrayList<Produto> itens = new ArrayList<>();
    private String status;

    public void adicionarItem(Produto item) {
        itens.add(item);
    }
    public void removerItem(int codigo) {
        itens.remove( codigo );
    }
    public double calcularTotal() {
        double total = 0;
        for ( Produto item : itens ) {
            total += item.getPreco();
        }
        return total;
    }
    public void confirmarPedido() {
        this.status = "Confirmado";
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public String getStatus() {
        return status;
    }
}