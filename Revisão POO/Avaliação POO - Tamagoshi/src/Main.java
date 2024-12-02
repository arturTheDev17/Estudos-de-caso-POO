import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );
        Banco banco = new Banco();

        banco.cadastrarPessoa( new Pessoa( 12345678911L , "João Pets" , "senha123" ) );

        banco.cadastrarPet( new Pet( "doguineo" ) );

        banco.cadastrarAlimento( new Alimento( "cenourinhas" , 45 ) );

        banco.cadastrarBrincadeira( new Brincadeira( "jogar bola" , 50 , 25 , 25 , 25 , 25 ) );


        int escolha;
        boolean logado = false;
        Pessoa pessoaLogada = null;

        System.out.println( "BEM VINDO AO PET SIMULATOR!" );

        while ( true ) {
            if ( !logado ) {
                System.out.println( "---------------------------------------------" );
                System.out.println( "1. Cadastrar pet" );
                System.out.println( "2. Cadastrar pessoa" );
                System.out.println( "3. Cadastrar alimento" );
                System.out.println( "4. Cadastrar brincadeira" );
                System.out.println( "5. Fazer Login" );
                System.out.println( "---------------------------------------------" );
                escolha = sc.nextInt();

                switch ( escolha ) {

                    case 1 : {
                        System.out.print( "Insira o nome do pet: " );
                        String nomePet = sc.nextLine();
                        banco.cadastrarPet( new Pet( nomePet ) );
                        sc.nextLine();
                    } break;

                    case 2 : {
                        sc.nextLine();
                        System.out.print( "Insira o nome: " );
                        String nomePessoa = sc.nextLine();
                        System.out.print( "Insira a senha: " );
                        String senha = sc.nextLine();
                        long cpf;
                        do {
                            System.out.print( "Insira o CPF: (11 caracteres) " );
                            cpf = sc.nextLong();
                        } while ( Long.toString( cpf ).length() != 11 );
                        banco.cadastrarPessoa( new Pessoa( cpf , nomePessoa , senha ) );
                        sc.nextLine();
                    } break;

                    case 3 : {
                        sc.nextLine();
                        System.out.print( "Insira o nome do alimento: " );
                        String nomeAlimento = sc.nextLine();
                        int nutricao;
                        do {
                            System.out.print( "Insira a nutrição: " );
                            nutricao = sc.nextInt();
                        } while ( nutricao < 0 || nutricao >= 100 );
                        banco.cadastrarAlimento( new Alimento( nomeAlimento , nutricao ) );
                        sc.nextLine();
                    } break;

                    case 4 : {
                        sc.nextLine();
                        System.out.print( "Insira o nome da brincadeira: " );
                        String nomeBrincadeira = sc.nextLine();
                        int beneficios;

                        do {
                            System.out.print( "Insira o quanto ela divertirá o pet: " );
                            beneficios = sc.nextInt();
                        } while ( beneficios < 0 || beneficios >= 100 );

                        int desgaste;
                        do {
                            System.out.print( "Insira o quanto ela desgastará o pet: " );
                            desgaste = sc.nextInt();
                        } while ( desgaste < 0 || desgaste >= 100 );

                        banco.cadastrarBrincadeira( new Brincadeira( nomeBrincadeira , beneficios , desgaste , desgaste , desgaste , desgaste ) );
                        sc.nextLine();
                    } break;

                    case 5 : {
                        System.out.println( "Digite o CPF: " );
                        long cpf = sc.nextLong();
                        sc.nextLine();
                        System.out.println( "Digite a senha: " );
                        String senha = sc.nextLine();
                        if ( banco.login( cpf , senha ) != null ) {
                            logado = true;
                            pessoaLogada = banco.login( cpf , senha );
                            System.out.println( "Logou como:\n" + pessoaLogada );
                            System.out.println( "DICA:  Você só pode administrar seu pet quando ele estiver acordado e vivo" );
                        } else {
                            System.out.println( "cpf ou senha inválidos" );
                        }
                    } break;
                }

            } else {
                System.out.println( "---------------------------------------------" );
                pessoaLogada.avaliarPet();
                System.out.println( "AÇÕES:\n0. Adotar pet" );
                System.out.println( "1. Acordar Pet" );
                System.out.println( "2. Botar Pet para dormir" );
                System.out.println( "3. Alimentar pet " );
                System.out.println( "4. Dar água para o pet" );
                System.out.println( "5. Brincar com o pet" );
                System.out.println( "6. Levar o pet para fazer as necessidades" );
                System.out.println( "7. Limpar o pet" );
                System.out.println( "8. Logout" );
                System.out.println( "---------------------------------------------" );

                escolha = sc.nextInt();
                switch ( escolha ) {
                    case 0 : {
                        for ( Pet pets : Banco.getPets() ) {
                            System.out.println(  pets.getCodigo() + ". " + pets.getNome() );
                        }
                        System.out.println( "Digite o código do pet que deseja adotar." );
                        int codigo = sc.nextInt();
                        pessoaLogada.adotarPet( banco.procurarPet(codigo) );

                    } break;
                    case 1: {
                        pessoaLogada.acordarPet();
                    }
                    break;
                    case 2: {
                        pessoaLogada.botaPetParaDormir();
                    }
                    break;
                    case 3: {
                        for ( Alimento alimentos : Banco.getAlimentos() ) {
                            System.out.println(  alimentos.getCodigo() + ". " + alimentos.getNome() );
                        }
                        System.out.println( "Digite o código do alimento que deseja dar para o pet." );
                        int codigo = sc.nextInt();
                        pessoaLogada.alimentarPet(banco.procurarAlimento(codigo));
                    }
                    break;
                    case 4: {
                        pessoaLogada.darAguaParaPet();
                    }
                    break;
                    case 5: {
                        for ( Brincadeira brincadeiras : Banco.getBrincadeiras() ) {
                            System.out.println(  brincadeiras.getCodigo() + ". " + brincadeiras.getNome() );
                        }
                        System.out.println( "Digite o código da brincadeira que deseja realizar com pet." );
                        int codigo = sc.nextInt();
                        pessoaLogada.brincarComPet(banco.procurarBrincadeira(0));
                    }
                    break;
                    case 6: {
                        pessoaLogada.levarPerParaFazerNecessidades();
                    }
                    break;
                    case 7: {
                        pessoaLogada.limparPet();
                    } break;
                    case 8: {
                        logado = false;
                    } break;
                }
            }
        }
    }

}