public class Solicitante extends Usuario {

    /*
    Um usuário solicitante deve poder criar ordens de serviço,
    editar uma de suas ordens de serviço e visualizar as suas
    ordens de serviço.
    */

    private final GerenciadorOrdens gerenciadorOrdens = new GerenciadorOrdens();

    public Solicitante(long cpf, String nome) {
        super(cpf, nome);
    }

    public void criarOrdem(OrdemDeServico ordem) {
        gerenciadorOrdens.criarOrdem( ordem );
    }

    public void editarOrdem(int numeroOrdem, OrdemDeServico ordem) {
        if ( gerenciadorOrdens.procurarOrdem( ordem.getNumeroOrdem() ) != null ) {
            gerenciadorOrdens.editarOrdem(numeroOrdem, ordem);
        }
    }

    public String verOrdens() {
        return gerenciadorOrdens.mostrarDados();
    }
}
