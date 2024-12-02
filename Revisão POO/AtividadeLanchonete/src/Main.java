import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> products = new ArrayList<Produto>();
        products.add( new Lanche( "X-burguer" , 10 , 400 ) );
        products.add( new Bebida( "Refri" , 5 , 600 ) );
        Combo combo = new Combo( "Combo 1" , 20 , products );

        System.out.println( combo.exibirDetalhes() );


    }
}