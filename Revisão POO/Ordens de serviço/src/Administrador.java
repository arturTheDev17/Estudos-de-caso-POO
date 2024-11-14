public class Administrador extends Usuario {

    /*
    Um usuário administrador deve poder criar ordens de serviço,
    editar todas as ordens de serviço, remover todas as ordens
    de serviço e visualizar todas as ordens de serviço.
    */
    private final GerenciadorOrdens gerenciadorOrdens = new GerenciadorOrdens();

    public Administrador(long cpf, String nome) {
        super(cpf, nome);
    }

    public void criarOrdem(OrdemDeServico ordem) {
        gerenciadorOrdens.criarOrdem( ordem );
    }

    public void deletarOrdem(int numeroOrdem) {
        gerenciadorOrdens.deletarOrdem( numeroOrdem );
    }

    public void editarOrdem(int numeroOrdem, OrdemDeServico ordem) {
        gerenciadorOrdens.editarOrdem( numeroOrdem , ordem );
    }

    public GerenciadorOrdens getGerenciadorOrdens() {
        return gerenciadorOrdens;
    }

    public String verOrdens() {
        return gerenciadorOrdens.mostrarDados();
    }
}