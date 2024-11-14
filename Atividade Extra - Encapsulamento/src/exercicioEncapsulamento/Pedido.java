package exercicioEncapsulamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Pedido {
	Random ran = new Random();
	private int numero = ran.nextInt ( 1000 ) + 1;
	private Date data;
	//Associa a classe pessoa
	private Pessoa pessoa;
	private ArrayList < Produto > produtos = new ArrayList< Produto >();	
	
	public void setPessoa ( Pessoa pessoa ) {
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa () {
		return this.pessoa;
	}
	
	public ArrayList < Produto > getProdutos () {
		return this.produtos;
	}
	
	public void addProduto ( Produto produto ) {
		//Adiciona um produto à lista de produtos.
		this.produtos.add ( produto );
	}
	public Produto getProduto ( int indice ) {
		//Adiciona um produto à lista de produtos.
		return this.produtos.get ( indice );
	}
	public int getQtdProdutos (  ) {
		return this.produtos.size();
	}
	
	public int getNumero () {
		return this.numero;
	}

	public void setData (  ) {
		this.data = new Date ( System.currentTimeMillis() );
	}
	public Date getData ( ) {
		return this.data;
	}

	public float getValorTotal (  ) {
		float valorTotal = 0;
		for ( int i = 0 ; i < getQtdProdutos() ; i++ ) {
			if ( i - 1 > 0 ) {
				System.out.println ( i - 1  + "   " + getProduto ( i - 1 ).getPreco() );
				System.out.println ( i - 1  + "   " + getProduto ( i - 1 ).getNome() );
			}
			System.out.println ( i  + "   " + getProduto ( i ).getPreco() );
			System.out.println ( i   + "   " + getProduto ( i ).getNome() );
			valorTotal = valorTotal + ( getProduto ( i ).getPreco() );
		}
		return valorTotal;
	}
	
	
	/*public boolean setNumero ( int numero ) {
	if ( numero.isBlank() ) {
		System.out.println ( "ERRO. Numero deve ser apenas numeros..." );
		return false;
	}
	for ( int n = 0 ; n < numero.length() ; n++ ) {
		if ( !Character.isDigit ( numero.charAt(n)  ) ) {
			System.out.println ( "ERRO. Numero deve ser apenas numeros..." );
			return false;
		}
	}
	this.numero = numero ;
	return true;
}*/ 
	/*public boolean setQtdItens ( String qtdItens ) {
		for ( int n = 0 ; n < qtdItens.length() ; n++ ) {
			if ( !Character.isDigit ( qtdItens.charAt(n) ) ) {
				System.out.println ( "A quantidade de itens deve ser um numero." );
				return false;
			}
		}
		this.qtdItens = qtdItens ;
		return true;
	} */
}
