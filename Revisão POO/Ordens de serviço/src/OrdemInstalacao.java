public class OrdemInstalacao extends OrdemDeServico implements Imprimivel {
    private Usuario cliente;
    private String dataInstalacao;

    public OrdemInstalacao () {

    }
    public OrdemInstalacao(String descricao, String status, Usuario cliente, String dataInstalacao) {
        super(descricao, status);
        this.cliente = cliente;
        this.dataInstalacao = dataInstalacao;
    }

    @Override
    public String mostrarDados() {
        return  super.mostrarDados() +
                "\nCliente: " +
                cliente.getNome() +
                "\nData de Instalação: " +
                dataInstalacao;
    }
}
