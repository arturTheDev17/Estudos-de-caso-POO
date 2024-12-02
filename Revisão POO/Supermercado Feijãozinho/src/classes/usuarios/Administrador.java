package classes.usuarios;

import classes.Usuario;

public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(String nomeUsuario, String senha) {
        super(nomeUsuario, senha);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Tipo de usuário: Administrador";
    }

    // BancoSupermercado.addUsuario( new Cliente( "nome" , "123" ) );
//        BancoSupermercado.addUsuario( new Cliente( "nome" , "123" ) );
//        BancoSupermercado.addUsuario( new Cliente( "nomezinho" , "123" ) );
//        BancoSupermercado.addUsuario( new Cliente( "nomezinho" , "123" ) );
//        BancoSupermercado.addUsuario( new Cliente( "nome" , "123" ) );
//
//        Cliente cliente = (Cliente) BancoSupermercado.buscaUsuario( "nome2" );
//
//        BancoSupermercado.addProduto( new Alimento( "Carne" , 15.50f ));
//        BancoSupermercado.addProduto( new Bebida( "Suco" , 15.50f ));
//
//        cliente.adicionarProdutoCarrinho( BancoSupermercado.buscaProduto( "Carne" ) , 2 );
//        cliente.adicionarProdutoCarrinho( BancoSupermercado.buscaProduto( "Carne" ) , 2 );
//        cliente.adicionarProdutoCarrinho( BancoSupermercado.buscaProduto( "Carne" ) , 2 );
//        cliente.adicionarProdutoCarrinho( BancoSupermercado.buscaProduto( "Carne" ) , 2 );
//        cliente.adicionarProdutoCarrinho( BancoSupermercado.buscaProduto( "Suco" ) , 2 );
//
//
//        for ( Produto produto : cliente.getCARRINHO().keySet() ) {
//            System.out.print( produto.getNome() + ": " );
//            System.out.println( cliente.getCARRINHO().get( produto ) );
//
//        }
}
