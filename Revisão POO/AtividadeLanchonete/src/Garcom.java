public class Garcom extends Pessoa {

    private double pagamento;

    public Garcom(String nome, String endereco, String telefone, double pagamento) {
        super(nome, endereco, telefone);
        this.pagamento = pagamento;
    }

    public void cadastrarPedido(Cliente cliente, Pedido pedido) {
        cliente.fazerPedido( pedido );
    }

    //TODO arrumar
    public String exibirMenu() {
        String menu = "";
        for ( Produto produto : GerenciadorDeCardapio.getCardapio() ) {
            menu += produto.exibirDetalhes();
        }
        return "";
    }

    public void adicionarItemAoPedido(Pedido pedido, Produto item) {
        pedido.adicionarItem( item );
    }

    public void removerItemDoPedido(Pedido pedido, int codigo) {
        pedido.removerItem( codigo );
    }

    public void confirmarPedido(Pedido pedido) {
        pedido.confirmarPedido();
    }

    public double calcularPagamento(Pedido pedido) {
        return pedido.calcularTotal();
    }
}