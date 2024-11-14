public class Main {

       public static void main(String[] args) {
        Usuario usuario = new Solicitante( 12312312310L , "joao" );

        OrdemDeServico ordem1 = new OrdemInstalacao
                ( "compra teste" , "concluido" , usuario ,"10" );

        OrdemDeServico ordem2 = new OrdemInstalacao
                ( "colocar pedra" , "em andamento" , usuario ,"12" );

        OrdemDeServico ordem3 = new OrdemInstalacao
                ( "instalar frefaire" , "pendente" , usuario ,"30" );

        OrdemDeServico ordem4 = new OrdemManutencao
                ( "troca roda" , "concluido" , "roda grande" , "54" );

        OrdemDeServico ordem5 = new OrdemManutencao
                ( "colocar agua no radiador de fusca" , "concluido" , "mãos" ,"99" );

        OrdemDeServico ordem6 = new OrdemManutencao
                ( "remover filtro" , "concluido" , "photoshop" ,"2" );
//        Relatorio.gerarRelatorio( ordem2 );
//        Relatorio.gerarRelatorio( ordem3 );
//        Relatorio.gerarRelatorio( ordem4 );
//        Relatorio.gerarRelatorio( ordem5 );
//        Relatorio.gerarRelatorio( ordem6 );


        Atendente usuario1 = new Atendente( 98765432101L , "Atendnman" );
        OrdemDeServico obj = new OrdemInstalacao( "teste" , "feito" , usuario1 , "12/12/2006" );
        usuario1.criarOrdem( obj );

        Administrador administrador = new Administrador( 56849568490L , "Ademir" );
        usuario1.criarOrdem( ordem1 );

        try {
         administrador.editarOrdem(1, new OrdemInstalacao("aoba", "parei", administrador, "date"));
        } catch ( IndexOutOfBoundsException indexOutOfBoundsException ) {
         System.out.println( "índice nao existe" );
        }

        //System.out.println (GerenciadorOrdens.getOrdens().get( 1 ).mostrarDados() );

        usuario1.criarOrdem( ordem2 );

        usuario1.criarOrdem( ordem3 );

        usuario1.criarOrdem( ordem4 );

       usuario1.criarOrdem( ordem5 );

       usuario1.criarOrdem( ordem6 );

        System.out.println(usuario1.verOrdens());
     }
}