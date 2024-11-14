package estudodecaso03;

import java.util.HashMap;
import java.util.Map;

/**
 * Essa classe serve para guardar os dados da nossa indústria.
 * @author Artur Neves Höpner
 */

public class Dados {
	
	public static Map < Integer , Maquina > maquinas = new HashMap < Integer , Maquina >();
	public static Map < Integer , Produto > produtos = new HashMap < Integer , Produto >();
	public static Map < Integer , Operario > operarios = new HashMap < Integer , Operario >();
	public static Map < Integer , Producao > linhasProducao = new HashMap < Integer , Producao >();
	public static Map < Integer , Manutencao > manutencoes = new HashMap < Integer , Manutencao >();
	
	/**
	 * Criação dos HashMaps para guardar os diversos dados.
	 */

	/**
	 * Esse atributo serve apenas para garantir que não sejam inseridos dados duplicados.
	 */
	
	/**
	 *  Essa função serve para guardar os dados no banco de dados.
	 * @param args
	 * @param escolha
	 */
	public static void main ( String [] args, char escolha ) {
		
		if ( escolha == '2' ) {
		
			for ( Integer chave : maquinas.keySet() ) {
				
				System.out.println ( "\n------------------------------------------------------------" );
				System.out.println ( " Nome : " +  maquinas.get( chave ).getNome());
				System.out.println ( " Status : " +  maquinas.get(chave).getStatus());
				System.out.println ( " Tipo : " +  maquinas.get(chave).getTipo());
				System.out.println ( " Tempo atividade : " +  maquinas.get(chave).getDadosDesempenho()[0] + "h" );
				System.out.println ( " Tempo inatividade : " +  maquinas.get(chave).getDadosDesempenho()[1]  + "h" );
				System.out.println ( " Tempo de produtividade : " +  maquinas.get(chave).getDadosDesempenho()[2] + "%" );
				System.out.println ( "------------------------------------------------------------" );

		
			}
		
		} 
		
		else if ( escolha == '1' ) { 
			
			for ( Integer chave : produtos.keySet() ) {
				
				System.out.println ( "\n------------------------------------------------------------" );
				System.out.println ( " Nome : " + produtos.get( chave ).getNome());
				System.out.println ( " Processo : " + produtos.get( chave ).getProcesso());
				System.out.println ( " Descrição : " + produtos.get(chave).getDescriçao());
				System.out.println ( " Componentes : " + produtos.get(chave).getComponentes());
				System.out.println ( "------------------------------------------------------------" );

			}
		
		} 
		
		else if ( escolha == '3' ) {
			
			for ( Integer chave : operarios.keySet() ) {
				
				System.out.println ( "\n------------------------------------------------------------" );
				System.out.println ( " Nome : " + operarios.get( chave ).getNome());
				System.out.println ( " Salário: R$ " + operarios.get(chave).getSalario());
				System.out.println ( " Habilidades: " +  operarios.get(chave).getHabilidade());
				System.out.println ( "------------------------------------------------------------" );

			}
		
		} 
		
		else if ( escolha == '4' ) {
			
			for ( Integer chave : manutencoes.keySet() ) {
				
				System.out.println ( "\n------------------------------------------------------------" );
				System.out.println ( " Data : " + manutencoes.get( chave ).getData());
				System.out.println ( " Horário : " + manutencoes.get( chave ).getHora());
				System.out.println ( " Máquina : " + manutencoes.get( chave ).getMaquinator().getNome());
				System.out.println ( " Manutentor : " + manutencoes.get( chave ).getManutentor().getNome());
				System.out.println ( "------------------------------------------------------------" );
			}
		
		} 
		
		else if ( escolha == '5' ) {
			
			for ( Integer chave : linhasProducao.keySet() ) {
				
				System.out.println ( "\n------------------------------------------------------------" );
				System.out.println ( " Status : " + linhasProducao.get( chave ).getStatus() );
				System.out.println ( " Setor : " + linhasProducao.get( chave ).getSetor() );
				System.out.println ( " Está ativa? " + linhasProducao.get( chave ).getAtiva() );
				System.out.println ( " Tempo de ciclo: " + linhasProducao.get( chave ).getTempo() );
				System.out.println ( "------------------------------------------------------------" );
			}
		}
		
		
		
	}

	/**
	 * Essa função serve para inserir dados de teste no banco de dados.
	 */
	
	public static void inserirDados ( boolean inserido ) {
		if ( inserido ) {
			System.out.println ( "Os valores já foram inseridos." );
		} else {
			Operario operario1 = new Operario();
			Operario operario2 = new Operario();

			operario1.setHabilidade ( "Esperto" );
			operario1.setId ( 88 );
			operario1.setNome ( "Gabriel" );
			operario1.setSalario ( "1400" );
			
			operario2.setHabilidade ( "Sagaz" );
			operario2.setId ( operarios.size() );
			operario2.setNome ( "Eduardo" );
			operario2.setSalario ( "2000" );
			
			operarios.put ( operario1.getId() , operario1 );
			operarios.put ( operario2.getId() , operario2 );
			
			Producao producao1 = new Producao();
			producao1.setId ( 99 );
			producao1.setSetor ( "Acabamento" );
			producao1.setStatus ( "Em operação" );
			producao1.setTempo( "10" );
			linhasProducao.put ( producao1.getId() , producao1 );
			
			Producao producao2 = new Producao();
			producao2.setId ( linhasProducao.size() );
			producao2.setSetor ( "Corte" );
			producao2.setStatus ( "Com gargalos" );
			producao2.setTempo ( "12" );
			linhasProducao.put ( producao2.getId() , producao2 );
			
			Maquina maquina1 = new Maquina();
			maquina1.setMaquinaID ( 99 );
			maquina1.setNome ( "Torno" );
			maquina1.setStatus( "Funcionando" );
			maquina1.setTaxaDeProdutividade( "60" );
			maquina1.setTipo( "Fabricação" );
			maquina1.setTempoDeAtividade( "12" );
			maquina1.setTempoDeInatividade( "12" );
			maquina1.setLinha ( producao1 );

			Maquina maquina2 = new Maquina();
			maquina2.setMaquinaID ( maquinas.size() );
			maquina2.setNome ( "Rebolo" );
			maquina2.setStatus( "Precisa de manutenção" );
			maquina2.setTaxaDeProdutividade( "40" );
			maquina2.setTipo( "Acabamento" );
			maquina2.setTempoDeAtividade( "6" );
			maquina2.setTempoDeInatividade( "18" );
			maquina2.setLinha ( producao2 );

			maquinas.put  ( maquina1.getMaquinaID() , maquina1 );
			maquinas.put  ( maquina2.getMaquinaID() , maquina2 );

			Produto produto1 = new Produto();
			produto1.setProcesso ( "Torneamento a laser" );
			produto1.setDescriçao ( "Caixa de metal 3m³" );
			produto1.setNome ( "Caixotão" );
			produto1.setId ( 99 );

			Produto produto2 = new Produto();
			produto2.setProcesso ( "Furação por respiração" );
			produto2.setDescriçao ( "Enorme mesa de carvalho de lei" );
			produto2.setNome ( "Mesa" );
			produto2.setId ( produtos.size() );
			
			produtos.put ( produto1.getId() , produto1 );
			produtos.put ( produto2.getId() , produto2 );
			
			Manutencao manutencao1 = new Manutencao();
			Manutencao manutencao2 = new Manutencao();
			
			manutencao1.setData ( "17/11/2012" );
			manutencao1.setHora ( "14:30" );
			manutencao1.setId ( 99 );
			manutencao1.setManutentor ( operario1 );
			manutencao1.setMaquinator ( maquina1 );

			manutencoes.put ( manutencao1.getId() , manutencao1 );
			
			manutencao2.setData ( "19/11/2012" );
			manutencao2.setHora ( "16:30" );
			manutencao2.setId ( manutencoes.size() );
			manutencao2.setManutentor ( operario2 );
			manutencao2.setMaquinator ( maquina2 );

			manutencoes.put ( manutencao2.getId() , manutencao2 );
			
		}
		
	}
	
	/**
	 * Essas funções servem para guardar os dados nos respectivos banco de dados.
	 * @param cod
	 * @param maquina
	 */
	
	public static void inserirMaquina ( Integer cod, Maquina maquina ) {
	
		maquinas.put ( cod, maquina );
	
	}
	
	public static void inserirProduto ( Integer cod, Produto produto ) {
		produtos.put ( cod, produto );
	
	}
	
	public static void inserirOperario ( Integer cod, Operario operario ) {
		operarios.put ( cod, operario );
	
	}
	
	public static void inserirManutencao ( Integer cod, Manutencao manutencao ) {
		
		manutencoes.put ( cod, manutencao );
	}
	
	public static void inserirLinhaProducao ( Integer cod, Producao producao ) {
		
		linhasProducao.put ( cod, producao );
		
	}
	
	

}