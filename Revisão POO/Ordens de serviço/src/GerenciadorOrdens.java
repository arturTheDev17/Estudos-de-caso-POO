import java.util.ArrayList;

public class GerenciadorOrdens implements CriadorOrdem , EditorOrdem , RemovedorOrdem , ProcuradorOrdem , Imprimivel , VisualizadorOrdem {
    private static ArrayList<OrdemDeServico> ordens = new ArrayList<OrdemDeServico>();
    @Override
    public void criarOrdem(OrdemDeServico ordem) {
        ordens.add( ordem );
    }

    @Override
    public void editarOrdem(int numeroOrdem, OrdemDeServico ordem) {
        ordens.set( numeroOrdem , ordem );
    }

    @Override
    public OrdemDeServico procurarOrdem( int id ) {
        for ( OrdemDeServico ordem : ordens ) {
            if ( ordem.getNumeroOrdem() == id ) {
                return ordem;
            }
        }
        return null;
    }

    @Override
    public void deletarOrdem(int numeroOrdem) {
        ordens.removeIf( ordem -> ordem.getNumeroOrdem() == numeroOrdem );
    }

    @Override
    public void verOrdens() {
        mostrarDados();
    }

    public static ArrayList<OrdemDeServico> getOrdens() {
        return ordens;
    }

    @Override
    public String mostrarDados() {
        String todosDados = "";
        for ( OrdemDeServico ordem : ordens ) {
            todosDados +=
                    ordem.mostrarDados() +
                    "\n---------------------------";
        }
        return todosDados;
    }
}
