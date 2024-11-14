package estudodecaso03;

/**
 * Essa classe serve para executar as funções de verificação da produção.
 * @author Saymon Oliveira de Castro
 */

import java.util.Scanner;

public class ProducaoCadastro {
	
	public static void main ( String [] args, Dados dados ) {
		
		Scanner sc = new Scanner ( System.in );
		
		String maquina;
		
		Producao producao1 = new Producao ();
		
		do {
			
			System.out.println( " Insira o setor " );
			
		} while ( !producao1.setSetor(sc.nextLine()));
		
		
		do {
			
			System.out.println( " Insira o status da linha " );
			
		} while ( !producao1.setStatus(sc.nextLine()));
		
		do {
			
			System.out.println( " Insira o tempo de ciclo em minutos " );
			
		} while ( !producao1.setTempo(sc.nextLine()));
		
		/**
		 * Guarda o id como o próprio tamanho do HashMap, ou seja, autoIncrement.
		 */
		
		producao1.setId ( ( Integer ) dados.linhasProducao.size() );

		dados.inserirLinhaProducao ( dados.linhasProducao.size() , producao1 );
		
		System.out.println( " Produção cadastrada com sucesso" );
 			
	}	

	public static void fazerComentario (  ) {
		Scanner sc = new Scanner ( System.in );

		if ( Dados.linhasProducao.size () == 0 ) {
			
		} else {
		System.out.println ( "Insira o setor da linha de produção que desejas comentar:\n" );
		
		for ( Integer chave : Dados.linhasProducao.keySet() ) {
			System.out.println ( "Setor : " + Dados.linhasProducao.get(chave).getSetor() );
			System.out.println ( "Ativa? " +Dados.linhasProducao.get(chave).getAtiva() );
		}
		
		String linha = sc.nextLine();
		boolean conteve = false;
		do {
			
			for ( Integer chave : Dados.linhasProducao.keySet() ) {
				
				/*
				 * Essa parte usa um for:Each para comparar o nome da linha inserida com todas as registrados, e se
				 * existir tal operário, aprovar o registro dele na manutenção.
				 */
				
				if ( Dados.linhasProducao.get( chave ).getSetor().equals ( linha ) ) {
					System.out.println ( "Faça seu comentário: " );
					String comentario = sc.nextLine();
					Dados.linhasProducao.get(chave).setComentario ( comentario );
					System.out.println ( "Cometário feito:\n" + Dados.linhasProducao.get(chave).getComentario() );
					conteve = true;
				
				}
				
			}
			
			if ( !conteve ) {
				System.out.println ( "Linha não encontrada." );
			}
			
		} while ( !conteve );
		
		
		}
	}
}