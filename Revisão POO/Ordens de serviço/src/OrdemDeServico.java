public abstract class OrdemDeServico implements Imprimivel {
    private static int numeroOrdemGerador = 0;
    private int numeroOrdem;
    private String descricao;
    private String status;

    public OrdemDeServico() {
        numeroOrdemGerador++;
        numeroOrdem = numeroOrdemGerador;
    }
    public OrdemDeServico( String descricao, String status) {
        this.descricao = descricao;
        this.status = status;
        numeroOrdemGerador++;
        numeroOrdem = numeroOrdemGerador;
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String mostrarDados() {
        return  "Numero da Ordem: " + numeroOrdem +
                "\nDescrição: " + descricao +
                "\nStatus: " + status;
    }

    public void atualizarStatus (String novoStatus ) {
        this.status = novoStatus;
    }
}
