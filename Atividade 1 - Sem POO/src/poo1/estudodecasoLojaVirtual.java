package poo1;

import java.util.Scanner;
import java.util.ArrayList;
public class estudodecasoLojaVirtual {
	public static void main ( String [] args ) {
		String [] placeholder = new String [ 2 ];
		String [] dados = new String [ 2 ];
		int escolha = 9;
		boolean logado = false;
		Scanner sc = new Scanner ( System.in );
		menuInicio ( logado , placeholder );
		do {
			escolha = sc.nextInt();
			switch ( escolha ) {
			case 0 :
				System. exit(0);
				break;
			case 1 :
				String login = null , senha = null ;
				boolean erro = false;
					System.out.println ( "\n------------------- LOJA VIRTUAL -------------------" );
					while ( erro == false ) {
						System.out.println ( "Insira seu login. OBS: Maior que 2 caracteres e menor que 20." );
						login = sc.next();
						
						if ( testeLogin ( login , "a" ) == true ) {
							erro = true;
						} else {
							System.out.println ( "login inválido. Tente novamente." );
						}
					}
					dados [ 0 ] = login;
					erro = false;
					while ( erro == false ) {
						System.out.println ( "Insira sua senha. OBS: menor que 10 caracteres." );
						senha = sc.next();
						if ( testeLogin ( "aaa", senha ) == true ) {
							erro = true;
						} else {
							System.out.println ( "senha inválida. Tente novamente." );
						}
					}
				dados [ 1 ] = senha;
				logado = true;
				break;
			case 2 :
				mostrarProdutos();
				break;
			case 3 :
				mostrarCategorias();
				break;
			case 4 :
				buscarProduto();
				break;
			case 5 :
				if ( logado == false ) {
					System.out.println ( "Faça login para acessar o carrinho!" );
					break;
				}
				logado = carrinho();
				break;
			default:
				System.out.println ( "VALOR INVÁLIDO" );
			}
			
			menuInicio ( logado , dados );
			escolha = 9;
		} while ( escolha != 0 );
	}
	public static void menuInicio ( boolean logado , String [] dados  ) {
		if ( logado == false ) {
			System.out.println ( "\n------------------- LOJA VIRTUAL -------------------" );
			System.out.println ( "| 1 | Fazer login            | 2 | Mostrar produtos" );
			System.out.println ( "| 3 | Buscar categorias      | 4 | Buscar produto" );
			System.out.println ( "| 5 | Ver carrinho           | 0 | Sair" );
		} else if ( logado == true ) {
			System.out.println ( "\n------------------- LOJA VIRTUAL -------------------" );
			System.out.println ( "Conta: " + dados [ 0 ] );
			System.out.println ( "| 1 | Trocar conta           | 2 | Mostrar produtos" );
			System.out.println ( "| 3 | Buscar categorias      | 4 | Buscar produto" );
			System.out.println ( "| 5 | Ver carrinho           | 0 | Sair" );
		}
		
	}
	public static boolean testeLogin ( String login , String senha ) {
		if ( login.length() > 2 && login.length() < 20 && senha.length() < 10  ) {
			return true;
		} else {
			return false;
		}
	}	
	public static String [][] listaProdutos () {
		String lista [][] = new String [ 20 ][ 3 ];
		//lista [ 0 ] [ 0 ] = "Eletronicos"; lista [ 0 ] [ 1 ] = "Processador AMD"; lista [ 0 ] [ 2 ] = "Ryzen 5 5600x";
		lista [ 1 ] [ 0 ] = "Roupas"; lista [ 1 ] [ 1 ] = "Camiseta Pac Man"; lista [ 1 ] [ 2 ] = "Camiseta Pac Man tamanho P";
		//lista [ 2 ] [ 0 ] = "Roupas"; lista [ 2 ] [ 1 ] = "Tênis Meninas Superpoderosas"; lista [ 2 ] [ 2 ] = "Tênis Meninas Superpoderosas\nda Docinho.";
		lista [ 3 ] [ 0 ] = "Eletronicos"; lista [ 3 ] [ 1 ] = "Controle Megadrive"; lista [ 3 ] [ 2 ] = "Controle para console da SEGA";
		lista [ 4 ] [ 0 ] = "Alimentos"; lista [ 4 ] [ 1 ] = "M&M"; lista [ 4 ] [ 2 ] = "Pacote M&M 300g tamanho família";
		lista [ 5 ] [ 0 ] = "Medicina"; lista [ 5 ] [ 1 ] = "Poção de Cura"; lista [ 5 ] [ 2 ] = "Criada cuidadosamente nas terras médias.";

		return lista;
	}
	public static void mostrarProdutos () {
		String lista[][] = listaProdutos();
		boolean vazio = true;
		System.out.println ( "------------------ TODOS PRODUTOS ------------------" );
		for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
			if ( vazio == false ) {
				System.out.println();
			}
			for ( int colunas = 0 ; colunas < 3 ; colunas++ ) {
				if ( lista [ linhas ] [ colunas ] != null ) {
					System.out.println (  lista [ linhas ] [ colunas ] + " " );
					vazio = false;
				} else {
					vazio = true;
				}
				
			}
		}
	}
	public static void mostrarCategorias() {
		Scanner sc = new Scanner ( System.in );
		String lista [][] = listaProdutos() , categoriaDeProduto;
		System.out.println ( "------------------- CATEGORIAS -------------------" );
		int conta = 0;
		for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
			if ( lista [ linhas ] [ 0 ] != null ) {
				System.out.println ( ( conta + 1 ) + " - " + lista [ linhas ] [ 0 ] + " " );
				conta++;
			}
		}
		int categoria = sc.nextInt();
		int numero = 1;
		switch ( categoria ) {
		case 1 :
			categoriaDeProduto = lista [ 0 ][ 0 ];
			for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
				if ( lista [ linhas ] [ 1 ] != null && lista [ linhas ] [ 0 ] == categoriaDeProduto ) {
					System.out.println ( ( numero ) + lista [ linhas ] [ 1 ] + " " );
					numero++;
				}
			}
			break;
		case 2 :
			categoriaDeProduto = lista [ 1 ][ 0 ];
			for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
				if ( lista [ linhas ] [ 1 ] != null && lista [ linhas ] [ 0 ] == categoriaDeProduto ) {
					System.out.println ( ( numero ) + lista [ linhas ] [ 1 ] + " " );
					numero++;
				}
			}
		/*case 3 :
			categoriaDeProduto = lista [ 4 ][ 0 ];
			for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
				if ( lista [ linhas ] [ 1 ] != null && lista [ linhas ] [ 0 ] == categoriaDeProduto ) {
					System.out.println ( ( numero ) + lista [ linhas ] [ 1 ] + " " );
					numero++;
				}
			}
			break;
		case 4 :
			categoriaDeProduto = lista [ 5 ][ 0 ];
			for ( int linhas = 0 ; linhas < lista.length; linhas++ ) {
				if ( lista [ linhas ] [ 1 ] != null && lista [ linhas ] [ 0 ] == categoriaDeProduto ) {
					System.out.println ( ( numero ) + lista [ linhas ] [ 1 ] + " " );
					numero++;
				}
			}
			break;*/
		}
	}
	public static void buscarProduto () {
		Scanner sc = new Scanner ( System.in );
		String lista [][] = listaProdutos();
		float precos [] = precos();
		System.out.println ( "Busque pelo produto que deseja. Você pode digitar apenas partes do nome do produto: " );
		String produto = sc.next();
		for ( int contador = 0 ; contador < 20 ; contador++ ) {
			if ( lista [ contador ] [ 1 ] != null && (lista [ contador ] [ 1 ]) .contains ( produto ) ) {
				produto = lista [ contador ] [ 1 ];
				System.out.println ( "Este produto existe! Vá ao carrinho para comprá-lo." );
				System.out.println ( "Informações do Produto:\n" );
				System.out.println ( lista [ contador ] [ 1 ] + "\nR$ " + precos [ contador ] + "\n" + lista [ contador ] [ 2 ] );
			break;
			}
		}
	}
	public static boolean carrinho () {
		Scanner sc = new Scanner ( System.in );
		String lista [][] = listaProdutos();
		ArrayList <String> carrinho = new ArrayList <String>();
		float precos [] = precos() , somaCarrinho = 0; int contadorCarrinho = 0;
		System.out.println ( "Bem vindo ao carrinho!" );
		char escolha;
		int choice = 9 , erro = 1;
		String valor; 
		while ( choice != 0 ) {
			System.out.println ( "\n------------------- CARRINHO -------------------" );
			System.out.println ( "| 1 | Buscar produto          | 2 | Remover produto" );
			System.out.println ( "| 3 | Finalizar compra        | 0 | Fechar carrinho" );
			choice = sc.nextInt();
			switch ( choice ) {
			case 1 : 
				System.out.println ( "Busque pelo produto que deseja. Você pode digitar apenas partes do nome do produto: " );
				String produto = sc.next();
				for ( int contador = 0 ; contador < 20 ; contador++ ) {
					
					if ( lista [ contador ] [ 1 ] != null && (lista [ contador ] [ 1 ]) .contains ( produto ) ) {
						produto = lista [ contador ] [ 1 ];
						System.out.println ( "Informações do Produto:\n" );
						System.out.println ( lista [ contador ] [ 1 ] + "\nR$ " + precos [ contador ] + "\n" + lista [ contador ] [ 2 ] );
						System.out.println ( "Adicionar ao carrinho? s/n" );
						escolha = sc.next().charAt(0);
						if ( escolha == 'S' || escolha == 's' ) {
							carrinho.add ( produto );
							contadorCarrinho++;
							somaCarrinho = somaCarrinho + precos [ contador ];
						}
					}
				}
				break;
			case 2 :
				for ( int listar = 0 ; listar < carrinho.size() ; listar++ ) {
					System.out.println ( ( 1 + listar ) + "- " + carrinho.get ( listar ) );
				}
				System.out.println ( "Escolha o produto que desejas remover." );
				choice = sc.nextInt();
				carrinho.remove ( choice - 1 );
			case 3 :
				if ( somaCarrinho <= 0 ) {
					System.out.println ( "Coloque algo no carrinho para finalizar a compra..." );
					break;
				}
				System.out.println ( "\n------------------- CARRINHO -------------------" );
				for ( int listar = 0 ; listar < carrinho.size() ; listar++ ) {
					System.out.println ( ( 1 + listar ) + "- " + carrinho.get ( listar ) );
				}
				System.out.println ( "Valor Total : | R$ " + somaCarrinho + " |" );
				System.out.println ( "Desejas continuar? s/n" );
				escolha = sc.next().charAt(0);
				if ( escolha == 'S' || escolha == 's' ) {
					System.out.println ( "| Insira sua forma de pagamento: |" );
					System.out.println ( "| 1 | PIX |    5% de desconto    |" );
					System.out.println ( "| 2 |      CARTÃO DE CRÉDITO     |" );
					choice = sc.nextInt();
					if ( choice == 1 ) {
						while ( erro != 0 ) {
							System.out.println  ( "Insira seu CPF ( não insira de verdade por favor... )" );
							valor = sc.next();
							if ( valor.length() == 11 ) {
								erro = 0;
							} else {
								System.out.println ( "Valor inválido..." );
							}
						}
						System.out.println ( "Recebendo PIX de " + somaCarrinho * 0.95f );
						System.out.println ( "PIX recebido. Deseja sair da sua conta? s/n" );
						escolha = sc.next().charAt(0);
						if ( escolha == 'S' || escolha == 's' ) {
							return false;
						} else {
							return true;
						}
					} else if ( choice == 2 ) {
						while ( erro != 0 ) {
							System.out.println  ( "Insira seu número de cartão ( não insira de verdade por favor... )" );
							valor = sc.next();
							if ( valor.length() == 16 ) {
								erro = 0;
							} else {
								System.out.println ( "Valor inválido..." );
							}
						}
						erro = 1;
						while ( erro != 0 ) {
							System.out.println  ( "Insira a expiração do cartão ( formato MM/AA )" );
							valor = sc.next();
							if ( valor.length() == 5 ) {
								erro = 0;
							} else {
								System.out.println ( "Valor inválido..." );
							}
						}
						while ( erro != 0 ) {
							System.out.println  ( "Insira seu CVV ( não insira de verdade por favor... )" );
							valor = sc.next();
							if ( valor.length() == 3 ) {
								erro = 0;
							} else {
								System.out.println ( "Valor inválido..." );
							}
						}
						System.out.println ( "Recebendo pagamento de " + somaCarrinho );
						System.out.println ( "Pagamento efetuado. Deseja sair da sua conta? s/n" );
						escolha = sc.next().charAt(0);
						if ( escolha == 'S' || escolha == 's' ) {
							return false;
						} else {
							return true;
						}
					}
				}
				break;
			}
		}
		return true;
	}
	public static float [] precos() {
		float [] precos = new float [ 20 ];
		precos [ 0 ] = 1000; precos [ 1 ] = 100; precos [ 3 ] = 300; precos [ 4 ] = 500; precos [ 5 ] = 20; precos [ 6 ] = 9999;
		return precos;
	}
}