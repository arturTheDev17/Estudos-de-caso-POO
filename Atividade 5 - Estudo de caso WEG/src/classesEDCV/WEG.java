package classesEDCV;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Classe onde são mantidos: 
 * objetos produtoWeg e suas subclasses;
 * serviços de manutencao. 
 * Além de ser onde o método main está presente, sendo assim a classe principal
 * @author artur_hopner
 *
 */
public class WEG {
	
	/**
	 * lista dos servicos de manutencao cadastrados na execucao da main
	 */
	private ArrayList<ServicoManutencao> listaServicoManutencao = new ArrayList<ServicoManutencao>();
	/**
	 * lista dos produtos cadastrados na execucao da main
	 */
	private ArrayList<ProdutoWEG> listaProdutoWEG = new ArrayList< ProdutoWEG >();
	
	
	/**
	 * Execução do código envolvendo os métodos de várias classes, fazendo funções como: Cadastro de produtos;
	 * Cadastro de serviços de manutenção; Adição de produtos à lista; Adição de serviços de manutenção à lista; 
	 * Listagem de produtos; Realização de manutenção; Descrição de produtos.
	 * @param args
	 */
	public static void main ( String [] args ) {
		
		WEG weg = new WEG ();
		String [] escolhas = 
		{  "--- Cadastrar ---" , "Gerador" , "Inversor de frequência" , "Motor elétrico" , "Outro produto" , "Serviço de manutenção" , " " , "--- Vincular ---" ,  "Serviço de manutenção a um produto" , " " , "--- Visualizar ---" , "Produtos e serviços cadastrados" , "Serviços de um produto" };
		JList<String> lista = new JList<String>( escolhas );
		int sair = JOptionPane.showConfirmDialog
		(  null, lista , "Escolha uma opção" , JOptionPane.PLAIN_MESSAGE , JOptionPane.PLAIN_MESSAGE );
		String escolha = lista.getSelectedValue();

		while ( sair != -1 ) {
			
			if ( escolha != null )
			switch ( escolha ) {
			case "Inversor de frequência" : {
				InversorFrequencia inversor = InversorFrequenciaCadastro.CadastroProduto();
				if ( inversor != null ) {
					weg.addProdutoWEG ( inversor );
				}
			} break;
			case "Motor elétrico" : {
				MotorEletrico motor = MotorEletricoCadastro.CadastroProduto();
				if ( motor != null  ) {
					weg.addProdutoWEG ( motor );
				}
			} break;
			case "Gerador" : {
				Gerador gerador = GeradorCadastro.CadastroProduto();
				if ( gerador != null  ) {
					weg.addProdutoWEG ( gerador );
				}
			} break;
			case "Outro produto" : {
				ProdutoWEG produto = ProdutoWEGcadastro.CadastroProduto();
				if ( produto != null  ) {
					weg.addProdutoWEG ( produto );
				}
			} break;
			case "Serviço de manutenção" : {
				ServicoManutencao servico = ServicoManuntencaoCadastro.CadastroServico();
				if ( servico != null  ) {
					weg.addManutencao ( servico );
				}
			
			} break;
			
			case "Produtos e serviços cadastrados" : {
				weg.verProdutosCadastrados();
			} break;
			
			case "Serviços de um produto" : {
				weg.verServicosProduto();
			} break;
			
			case "Serviço de manutenção a um produto" : {
				weg.vincularProdutoManutencao( weg.verServicosProduto() );
			} break;
			
			
			}
			sair = JOptionPane.showConfirmDialog
			(  null, lista , "Escolha uma opção" , JOptionPane.PLAIN_MESSAGE , JOptionPane.PLAIN_MESSAGE );
			escolha = lista.getSelectedValue();
			
			
		}
		
	}
	
	
	/**
	 * add um ProdutoWEG no atributo arraylist que guarda os ProdutosWEG
	 * @param produto
	 */
	public void addProdutoWEG ( ProdutoWEG produto ) {
		listaProdutoWEG.add( produto );
			
	}
	/**
	 * add um ServicoManutencao no atributo arraylist que guarda os ServicosManutencao
	 * @param servico
	 */
	public void addManutencao ( ServicoManutencao servico ) {
		listaServicoManutencao.add( servico );
			
	}
	/**
	 * remove um ProdutoWEG do atributo arraylist que guarda os ProdutosWEG
	 * @param produto
	 */
	public void removeProdutoWEG ( ProdutoWEG produto ) {
		listaProdutoWEG.remove ( produto );
	}
	/**
	 * remove um ServicoManutencao do atributo arraylist que guarda os ServicoManutencao
	 * @param servico
	 */
	public void removeManutencao ( ServicoManutencao servico ) {
		listaServicoManutencao.remove ( servico );
	}
	
	/**
	 * Exibe uma janela que mostra todos os objetos {@link ServicoManutencao} e {@link ProdutoWEG} cadastrados na execução atual do método main
	 * 
	 */
	public void verProdutosCadastrados () {
		if ( !listaProdutoWEG.isEmpty() || !listaServicoManutencao.isEmpty() ) {
			String produtos [];
			
			if ( !listaProdutoWEG.isEmpty() ) {
				produtos = new String [ listaProdutoWEG.size() ] ;
			} else {
				produtos = new String [] { "Não há produtos cadastrados" };
			}
			
			for ( int i = 0; i < listaProdutoWEG.size() ; i++ ) {	
				
				if ( listaProdutoWEG.get(i) instanceof InversorFrequencia ) {
					produtos [ i ] = "Nome: " + listaProdutoWEG.get(i).getNome() + "    Preço: R$" + String.format( "%.2f" , listaProdutoWEG.get(i).getPreco()) + 
							"    Número de fases: " + (( InversorFrequencia ) listaProdutoWEG.get(i)).getNumeroFases();
						
				} else if ( listaProdutoWEG.get(i) instanceof MotorEletrico ){
					produtos [ i ] = "Nome: " + listaProdutoWEG.get(i).getNome() + "    Preço: R$" + String.format( "%.2f" ,  listaProdutoWEG.get(i).getPreco()) + 
							"    Tipo de enrolamento: " + (( MotorEletrico ) listaProdutoWEG.get(i)).getTipoEnrolamento();
					
				} else if ( listaProdutoWEG.get(i) instanceof Gerador ){
					produtos [ i ] = "Nome: " + listaProdutoWEG.get(i).getNome() + "    Preço: R$" + String.format( "%.2f" , listaProdutoWEG.get(i).getPreco()) + 
							"    Horas de autonomia: " + (( Gerador ) listaProdutoWEG.get(i)).getAutonomia();
					
				} else {
					produtos [ i ] = "Nome: " + listaProdutoWEG.get(i).getNome() + "    Preço: R$" + String.format( "%.2f" , listaProdutoWEG.get(i).getPreco());
				}
			}
			
			String manutencao [];
			
			if ( !listaServicoManutencao.isEmpty() ) {
				manutencao = new String [ listaServicoManutencao.size() ] ;
			} else {
				manutencao = new String [] { "Não há serviços cadastrados" };
			}
			
			for ( int i = 0; i < listaServicoManutencao.size() ; i++ ) {
				manutencao [ i ] = "Descrição: " + listaServicoManutencao.get(i).getDescricao() +"    " + "Custo: " + listaServicoManutencao.get(i).getCusto();
			}	
			
			JList<String> listProdutos = new JList<String> ( produtos );
			JList<String> listManutencoes = new JList<String> ( manutencao );
			
			JLabel 	produtosW = new JLabel( "Produtos: " ), 
					servicosManutencao = new JLabel ( "Serviços de Manutenção: " );
			
			Object componentes [] = { produtosW , listProdutos , servicosManutencao , listManutencoes };
			JOptionPane.showMessageDialog( null , componentes);
			
		} else {
			JOptionPane.showMessageDialog ( null ,"NÃO HÁ PRODUTOS NEM SERVIÇOS CADASTRADOS!" , null, JOptionPane.ERROR_MESSAGE  );
		}
		
		}
	
	/**
	 * exibe os servicos vinculados a um produto selecionado, e retorna o nome deste produto
	 * @return retorna (String) nome do produto selecionado
	 */
	public String verServicosProduto () {
		
		String produtos [] = new String [ listaProdutoWEG.size() ] ;
		
		if ( !listaProdutoWEG.isEmpty() ) {
			
		for ( int i = 0; i < listaProdutoWEG.size() ; i++ ) {	
			produtos [ i ] = "Cód." + String.format("%05d", i ) + "    Nome: " + listaProdutoWEG.get(i).getNome() + "    Tipo: " + listaProdutoWEG.get(i).getTipo() ;
		
		}		
		JList<String> lista = new JList<String>( produtos );
		int sair = JOptionPane.showConfirmDialog
				(  null, lista , "Escolha um produto" , JOptionPane.PLAIN_MESSAGE , JOptionPane.QUESTION_MESSAGE );
		String escolha = lista.getSelectedValue();
		
			if ( sair != -1 && escolha != null ) {
				for ( int i = 0; i < listaProdutoWEG.size() ; i++ ) {	
					if ( escolha.equals( produtos[i] ) ) {
						String manutencao [] = new String [ listaServicoManutencao.size() ] ;
						
						if ( !listaProdutoWEG.get(i).getServicosRegistrados().isEmpty() ) {
							for ( int j = 0; j < listaProdutoWEG.get(i).getServicosRegistrados().size() ; j++ ) {
								manutencao [ j ] = "Descrição: " + listaProdutoWEG.get(i).getServicosRegistrados().get(j).getDescricao() +"    " + "Custo: " + listaProdutoWEG.get(i).getServicosRegistrados().get(j).getCusto();
							}
							JList<String> listManutencoes = new JList<String> ( manutencao );
							
							JLabel 	servicosManutencao = new JLabel ( "Serviços de Manutenção já cadastrados: " );
							
							Object componentes [] = { servicosManutencao , listManutencoes };
							JOptionPane.showMessageDialog( null , componentes);
							
						
						} else {
							JOptionPane.showMessageDialog ( null ,"NÃO HÁ SERVIÇOS REGISTRADOS NESSE PRODUTO!" , null, JOptionPane.ERROR_MESSAGE  );
						}
						
						return listaProdutoWEG.get(i).getNome();
					}
				}
			}
			
			
		
		} else {
			JOptionPane.showMessageDialog ( null ,"NÃO HÁ PRODUTOS CADASTRADOS!" , null, JOptionPane.ERROR_MESSAGE  );
		}
			
		return null;
			
				
			 
		} 
	
	/**
	 * recebe o nome de um produto e se válido, requisita o nome de um servico cadastrado para vincula-lo ao produto selecionado
	 * @param nomeProduto
	 */
	public void vincularProdutoManutencao ( String nomeProduto ) {
		System.out.println( nomeProduto );
		if ( !listaServicoManutencao.isEmpty() ) {
			ProdutoWEG produto = null;
			String servicos [] = new String [ listaServicoManutencao.size() ] ;
			
			if ( nomeProduto != null ) {
				for ( int i = 0; i < listaProdutoWEG.size() ; i++ ) {	
					if ( nomeProduto.equals( listaProdutoWEG.get(i).getNome() ) ) {
						System.out.println ( "setou" ) ;
						produto = listaProdutoWEG.get(i);
					}
				}
				
			for ( int i = 0; i < listaServicoManutencao.size() ; i++ ) {	
				servicos [ i ] = "Cód." + String.format("%05d", i ) + "    Nome: " + listaServicoManutencao.get(i).getDescricao() + "    Custo: " + listaServicoManutencao.get(i).getCusto() ;
			}		
			
			JList<String> lista = new JList<String>( servicos );
			int sair = JOptionPane.showConfirmDialog
					(  null, lista , "Escolha uma manutencao" , JOptionPane.PLAIN_MESSAGE , JOptionPane.QUESTION_MESSAGE );
			String escolha = lista.getSelectedValue();
			
			if ( sair != -1 && escolha != null ) {
				System.out.println ( "Tamanho: " + listaServicoManutencao.size() );
				for ( int i = 0; i < listaServicoManutencao.size() ; i++ ) {	
					if ( escolha.equals( servicos[i] ) ) {
						produto.addServicosRegistrados( listaServicoManutencao.get(i) );
					}
				}
				for ( int i2 = 0 ; i2 < listaProdutoWEG.size() ; i2++ ) {
					if ( nomeProduto.equals( listaProdutoWEG.get(i2).getNome() ) ) {
						System.out.println ( "guardo" );
						listaProdutoWEG.set ( i2, produto );
					}
				}
			}
			
			
			}
			
		
		} else {
			JOptionPane.showMessageDialog ( null ,"NÃO HÁ SERVIÇOS CADASTRADOS!" , null, JOptionPane.ERROR_MESSAGE  );
		}
}

}
