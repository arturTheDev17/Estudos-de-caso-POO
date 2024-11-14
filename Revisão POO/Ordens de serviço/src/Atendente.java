public class Atendente extends Usuario {
    /*
    Um usuário atendente deve poder criar ordens de serviço,
    editar todas as ordens de serviço e visualizar todas as ordens
    de serviço.
    */
    private GerenciadorOrdens gerenciadorOrdens = new GerenciadorOrdens();

    public Atendente(long cpf, String nome) {
        super(cpf, nome);
    }

    public void criarOrdem(OrdemDeServico ordem) {
        gerenciadorOrdens.criarOrdem( ordem );
    }
    public void editarOrdem(int numeroOrdem, OrdemDeServico ordem) {
        gerenciadorOrdens.editarOrdem( numeroOrdem , ordem );
    }

    public String verOrdens() {
        return gerenciadorOrdens.mostrarDados();
    }

}
